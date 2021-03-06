package Boggle;
/*************************************************************
 @author Sarun Luitel

 Class provides methods to create a random grid and calculate
 if a wird in in the board.

 *************************************************************/
import java.util.ArrayList;

class GameController
{
  private ArrayList<String> TheWordList = new ArrayList<>();
  private ArrayList<String> wordsPlayed = new ArrayList<>();
  private int totalWords=0;
  private int wordsFound =0;
  private int totalScore=0;
  private static GameController instance = new GameController();


  //Singleton design pattern. Private Constructor.
  private GameController(){};

  static GameController getInstance()
  {
    return instance;
  }


  /*************************************************************
   @param  boardSize gets the size of board from the GUI

   *************************************************************/
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
        this.TheWordList.add(word.toUpperCase());
        totalWords++;
      }
    }

    ViewBoard.setBoard(board.getBoard());


  }

  /*************************************************************
   @param  input takes in word from the board.

   Method checks if the word is in the list.

   *************************************************************/

  boolean playGame(String input)
  {

    if(TheWordList.contains(input.toUpperCase())&& !wordsPlayed.contains(input.toUpperCase()))
    {
      wordsFound++;
      wordsPlayed.add(input);
      totalScore=totalScore+input.length()-2;
      return true;

    }
    // command line version //else System.out.println("not Found");

    return false;

  }
  int getTotalWords(){ return this.totalWords;}
  int getWordsFound(){return this.wordsFound;}
  int getScore(){ return this.totalScore;}
  ArrayList getTheLise(){return this.TheWordList;}

}
