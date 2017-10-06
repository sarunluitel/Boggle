package Boggle;

import java.util.ArrayList;
import java.util.Scanner;

class GameController
{
  private ArrayList<String> TheWordList = new ArrayList<>();
  private int totalWords=0;
  private int wordsfound=0;

  void initialize()
  {

    Dictionary dictionary= new Dictionary();
    Board board = new Board(10 );


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
        //System.out.println(word);
      }
    }

    while(totalWords!=wordsfound)
    {
      playGame();
    }
    System.out.println("Awesome found all words");

  }

  private void playGame()
  {
    String input = getInput();
    if(input.equalsIgnoreCase("-1")) System.out.println(TheWordList.toString());

    if(TheWordList.contains(input))
    {
      wordsfound++;
      System.out.println("found "+ wordsfound +" words out of "+ totalWords );

    }
    else System.out.println("not Found");

  }

  private String getInput()
  {
    System.out.println("type a word from the board or -1 to give up");
    Scanner in = new Scanner(System.in);

    return in.next();
  }
}
