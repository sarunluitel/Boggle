package Boggle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller4 implements Initializable
{

  @FXML
  private Button btn00,Button01,Button02,Button03,Button04,Button10,Button11,Button12,
      Button13,Button14,Button20,Button21,Button22,Button23,Button24,Button30,Button31,
      Button32,Button33,Button34,Button40,Button41,Button42,Button43,Button44;

  @FXML
  private GridPane Grid;

  @FXML
  private void mouseDrag(Event event)
  {
    Button clicked= (Button) event.getTarget();

    System.out.println(clicked.getId());
  }

  @FXML
  private void timeUp()
  {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    char[][] board= ViewBoard.getBoard();
    int row, col;

    for (int i = 0; i < 16;  i++)
    {
      Button b =(Button) Grid.getChildren().get(i);
      String id=b.getId();
      System.out.print(id);
      row= id.charAt(6)-48; //convert char to string.
      col=id.charAt(7)-48;// take away the differential in ASCII
      b.setText(Character.toString(board[row][col]));
    }
  }
}
