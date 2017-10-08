package Boggle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Controller4
{

  @FXML
  private Button btn00,Button01,Button02,Button03,Button04,Button10,Button11,Button12,
      Button13,Button14,Button20,Button21,Button22,Button23,Button24,Button30,Button31,
      Button32,Button33,Button34,Button40,Button41,Button42,Button43,Button44;

  @FXML
  private GridPane Grid;

  @FXML
  private void iniBoard(Event event)
  {
    int row, col;

    for (int i = 0; i < 16;  i++)
    {
      Button b =(Button) Grid.getChildren().get(i);
      String id=b.getId();
      System.out.print(id);
      row= id.charAt(6)-48; //convert char to string.
      col=id.charAt(7)-48;// take away the differential in ASCII

      System.out.println("      button clicked at index "+row+"  "+col);


    }
    //System.out.println(Grid.getChildren().get(3));
    Button clicked= (Button) event.getSource();

  }

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
}
