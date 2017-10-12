package Boggle;

/************************************
 @author Sarun Luitel

 Controller that looks over the 5x5 grid

 ************************************/

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller5 implements Initializable
{

    private String userInput ="";
    private int minute, remsec, seconds=180;// 3 minutes

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
      char[][] board= ViewBoard.getBoard();
      int row, col;

      for (int i = 0; i < 25;  i++)
      {
        Button b =(Button) Grid.getChildren().get(i);
        String id=b.getId();
        row= id.charAt(6)-48; //convert char to string.
        col=id.charAt(7)-48;// take away the differential in ASCII
        b.setText(Character.toString(board[row][col]));
      }
      updateTimer();

    }

    @FXML
    private GridPane Grid;
    @FXML
    private Label lblBuffer, lblFound, lblScore;

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
      Label label=new Label(userInput);
      if(!GameController.getInstance().playGame(userInput))
      {
        label.setTextFill(Color.RED);
        //label.setFont(Font.font(17));
      }
      hBox.setSpacing(10);
      hBox.getChildren().add(label);
      total =GameController.getInstance().getTotalWords();
      found =GameController.getInstance().getWordsFound();
      double ratio=(1.00*found)/(1.00*total);
      System.out.println(ratio);
      timerBar.setProgress(ratio);
      lblScore.setText("Score: "+ GameController.getInstance().getScore());

      userInput="";

      lblFound.setText("found "+found+" / "+total );
    }
    @FXML
    Button btnSubmit, btnGiveUp;
    @FXML
    // Show possible words in the display and disable gameplay.
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
      timeline.stop();
      btnGiveUp.setDisable(true);
    }

    @FXML
    private  Label lblTimer;

    private Timeline timeline;
    @FXML
    private  void updateTimer()
    {
      timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        seconds--;
        minute =seconds/60;
        remsec=seconds%60;


        System.out.println("aa"+minute +"  "+ seconds);
        lblTimer.setText("Time remain: "+minute+": "+remsec);

        if(seconds==0){
          btnSubmit.setDisable(true);
          giveUp();
          btnGiveUp.setDisable(true);
          timeline.stop();
        }
      }));
      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.play();
    }

  }

