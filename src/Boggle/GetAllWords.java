package Boggle;

import java.util.ArrayList;

class GetAllWords
{
  private ArrayList<String> wordsFromBoard =new ArrayList<>();
  private char[][] board;




  GetAllWords(char[][] board)
  {
    this.board=board;
    int size =board.length;

    isWordinBoard("",0,0,size,new boolean[size][size]);
    for(String a : wordsFromBoard)
    {
      System.out.println(a);
    }



  }
  public void checkWord()
  {
    //isWordinBoard(wordFromDictionary);
  }

  private void isWordinBoard(String currentWord, int x, int y, int size, boolean[][] isChecked)
  {
    String nextWord= currentWord+board[x][y];
    if (nextWord.length()>2) wordsFromBoard.add(nextWord);
    isChecked[x][y]=true;
    System.out.println(nextWord+"@ index   "+x+"   "+y);
    if (nextWord.length()<20)
    {

      if (x != 0 && y != (size - 1) && !isChecked[x - 1][y + 1])
        isWordinBoard(nextWord, x - 1, y + 1, size, isChecked);

      if (y != (size - 1) && !isChecked[x][y + 1])
        isWordinBoard(nextWord, x, y + 1, size, isChecked);

      if (x != (size - 1) && y != (size - 1) && !isChecked[x + 1][y + 1])
        isWordinBoard(nextWord, x + 1, y + 1, size, isChecked);

      if (x != 0 && !isChecked[x - 1][y])
        isWordinBoard(nextWord, x - 1, y, size, isChecked);

      if (x != (size - 1) && !isChecked[x + 1][y])
        isWordinBoard(nextWord, x + 1, y, size, isChecked);

      if (x != 0 && y != 0 && !isChecked[x - 1][y - 1])
        isWordinBoard(nextWord, x - 1, y - 1, size, isChecked);

      if (y != 0 && !isChecked[x][y - 1])
        isWordinBoard(nextWord, x, y - 1, size, isChecked);

      if (x != 0 && y != 0 && !isChecked[x - 1][y - 1])
        isWordinBoard(nextWord, x - 1, y - 1, size, isChecked);
    }

  }



}
