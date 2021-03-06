package Boggle;
/*******************************************************************
 @author Sarun Luitel
 this class shows welcome screen and provides method to choose board and
 start game
 ********************************************************************/
import javafx.application.Application;
import javafx.event.ActionEvent;
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
  //javafx entry point
  void renderDisplay(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    welcomeScreen(primaryStage);
  }
  // calls welcome screen fxml and displays on the scene
  private void welcomeScreen(Stage primaryStage) throws Exception
  {
    Parent welcomeScene = FXMLLoader.load(getClass().getResource("GUIWelcome.fxml"));
    primaryStage.setTitle("Welcome to Boggle Game");
    primaryStage.setScene(new Scene(welcomeScene));
    primaryStage.show();
  }

  @FXML
  private Button btn4x4, btn5x5;

  @FXML
  //method runs when 4x4 is clicked
  private void clicked4() throws IOException
  {
    GameController.getInstance().initialize(4);
    Stage stage = (Stage) btn4x4.getScene().getWindow();

    Parent fourBy4 = FXMLLoader.load(getClass().getResource("4by4.fxml"));
    stage.setScene(new Scene(fourBy4));
  }

  @FXML
  //methid runs when 5x5 is run.
  private void clicked5() throws IOException
  {
    GameController.getInstance().initialize(5);
    Stage stage = (Stage) btn5x5.getScene().getWindow();

    Parent fiveBy5 = FXMLLoader.load(getClass().getResource("5by5.fxml"));
    stage.setScene(new Scene(fiveBy5));
  }
}
