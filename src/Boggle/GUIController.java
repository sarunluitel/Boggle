package Boggle;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;


public class GUIController extends Application
{

  public void renderDisplay(String[] args)
  {
    launch(args);
    //GameController g = new GameController();
    //g.initialize(); // uncomment to play game
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    welcomeScreen(primaryStage);
  }

  private void welcomeScreen(Stage primaryStage) throws Exception
  {
    Parent welcomeScene = FXMLLoader.load(getClass().getResource("GUIWelcome.fxml"));
    primaryStage.setTitle("Welcome to Boggle Game");
    primaryStage.setScene(new Scene(welcomeScene, 600, 400));
    primaryStage.show();

  }

  @FXML
  private Button btn4x4, btn5x5;
  @FXML
  private ProgressBar timerBar;

  @FXML
  private void clicked4(Event event) throws IOException
  {
    Stage stage = (Stage) btn4x4.getScene().getWindow();
    Parent fourBy4 = FXMLLoader.load(getClass().getResource("4by4.fxml"));
    stage.setScene(new Scene(fourBy4));
    timerBar = new ProgressBar(0);
    timerBar.progressProperty();//word on these to finish progressbar as timer.
  }


  @FXML
  private void clicked5(Event event) throws IOException
  {
    Stage stage = (Stage) btn5x5.getScene().getWindow();
    Parent fiveBy5 = FXMLLoader.load(getClass().getResource("5by5.fxml"));
    stage.setScene(new Scene(fiveBy5, 600, 400));
    timerBar = new ProgressBar(0);
    timerBar.progressProperty();//word on these to finish progressbar as timer.
  }


}
