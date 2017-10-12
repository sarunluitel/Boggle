package Boggle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;



public class Controller4 implements Initializable
{
  private String userInput ="";
  private GameController g;


  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    char[][] board= ViewBoard.getBoard();
    int row, col;

    for (int i = 0; i < 16;  i++)
    {
      Button b =(Button) Grid.getChildren().get(i);
      String id=b.getId();
      row= id.charAt(6)-48; //convert char to string.
      col=id.charAt(7)-48;// take away the differential in ASCII
      b.setText(Character.toString(board[row][col]));
    }
  }

  @FXML
  private GridPane Grid;
  @FXML
  private Label lblTimer, lblBuffer, lblFound;

  @FXML
  private void mouseDrag(Event event)
  {
    Button dragged= (Button) event.getTarget();
    userInput = userInput + dragged.getText();
    lblBuffer.setText(userInput);
  }

  @FXML
  private HBox hBox;
  @FXML
  private ProgressBar timerBar;
  @FXML
  private void submit()
  {
    int found=0,total=0;
    if(!GameController.getInstance().playGame(userInput))
    {
      Label label=new Label(userInput);
      label.setTextFill(Color.RED);
      //label.setFont(Font.font(17));
      hBox.setSpacing(10);
      hBox.getChildren().add(label);

    }
    else
      {
        total =GameController.getInstance().getTotalWords();
        found =GameController.getInstance().getWordsFound();
        double ratio=(1.00*found)/(1.00*total);
        System.out.println(ratio);
        timerBar.setProgress(ratio);
      }
    userInput="";

    lblFound.setText("found "+found+" of "+total +" words." );
  }
@FXML
Button btnSubmit;
  @FXML
  private void giveUp()
  {
    hBox.setSpacing(10);
    hBox.getChildren().removeAll();
    for (Object a :
        GameController.getInstance().getTheLise())
    {
      hBox.getChildren().add(new Label((String)a) );
    }
    btnSubmit.setDisable(true);
  }


}
