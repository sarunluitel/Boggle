package Boggle;

import java.util.ArrayList;
import java.util.Scanner;

class GameController
{
  private ArrayList<String> TheWordList = new ArrayList<>();
  private int totalWords=0;
  private int wordsFound =0;


  void initialize(int boardSize)
  {
    Dictionary dictionary= new Dictionary();
    Board board = new Board(boardSize);


    GetAllWords wordList = new GetAllWords(board.getBoard());

    for (String word :
        dictionary.getDictionary())
    {
      // first condition true means every word passes in wordList object will
      // be have at least 3 characters
      if(word!=null && word.length()>2 && wordList.isWordinBoard(word))
      {
        //code to add to the final list that contains. all the word that can be
        //formed from  the board.
        this.TheWordList.add(word);
        totalWords++;
      }
    }

    ViewBoard.setBoard(board.getBoard());

  }

  private void playGame()
  {
    String input = getInput();
    if(input.equalsIgnoreCase("-1")) System.out.println(TheWordList.toString());

    if(TheWordList.contains(input))
    {
      wordsFound++;
      System.out.println("found "+ wordsFound +" words out of "+ totalWords );

    }
    else System.out.println("not Found");


  }

  private String getInput()
  {
    System.out.println("type a word from the board or -1 to give up");
    System.out.println("found "+ wordsFound +" words out of "+ totalWords );
    Scanner in = new Scanner(System.in);

    return in.next();
  }


}
