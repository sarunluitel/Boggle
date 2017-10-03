package Boggle;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController
{

  void initialize()
  {

    Dictionary dictionary=new Dictionary();
    Board board = new Board(2 );


    GetAllWords wordlist =new GetAllWords(board.getBoard());

    if(dictionary.checkWord(getInput(),0,178697))
    {
      System.out.println("found");
    }

  }

  private String getInput()
  {
    System.out.println("type a word you want to find");
    Scanner in = new Scanner(System.in);

    return in.next();
  }
}
