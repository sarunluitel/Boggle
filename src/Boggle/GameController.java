package Boggle;

import java.util.ArrayList;

class GameController
{
  private ArrayList<String> TheWordList = new ArrayList<>();
  private ArrayList<String> wordsPlayed = new ArrayList<>();
  private int totalWords=0;
  private int wordsFound =0;
  private int totalScore=0;
  private static GameController instance = new GameController();

  private GameController(){};

  static GameController getInstance()
  {
    return instance;
  }

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

  boolean playGame(String input)
  {

    if(TheWordList.contains(input.toUpperCase())&& !wordsPlayed.contains(input.toUpperCase()))
    {
      wordsFound++;
      wordsPlayed.add(input);
      totalScore=totalScore+input.length()-2;
      return true;

    }
    else System.out.println("not Found");

    return false;

  }
  int getTotalWords(){ return this.totalWords;}
  int getWordsFound(){return this.wordsFound;}
  int getScore(){ return this.totalScore;}
  ArrayList getTheLise(){return this.TheWordList;}

}
