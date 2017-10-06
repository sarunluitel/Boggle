package Boggle;

class GetAllWords
{
  //Structure to hold every word in the Dictionary and board
  private char[][] board;
  private int size;
  private int currentplace;


  GetAllWords(char[][] board)
  {
    this.board = board;
    this.size=board.length;
  }

  boolean isWordinBoard(String InputWord)
  {
    boolean isWordUsed[][] = new boolean[size][size];
    currentplace=0;
    for (int i = 0; i < InputWord.length()-1; i++)
    {

      if(!checkNeighbour(InputWord.charAt(i),InputWord.charAt(i+1),isWordUsed))
        return false;
    }
    return true;
  }


  private boolean checkNeighbour(char a, char b,boolean[][] wordUsed)
  {
    int foundIndex=getIndex(a,currentplace/10,currentplace%10);
    if (foundIndex==-1) return false;

    b=Character.toUpperCase(b);
    while(foundIndex!=-1)
    {
      int y= foundIndex/10;
      int x= foundIndex%10;
      wordUsed[y][x]=true;

      b = Character.toUpperCase(b);

      if (x != 0 && y != (size - 1) && !wordUsed[y + 1][x - 1] && board[y + 1][x - 1] == b)
      { //checked DownLeft
        wordUsed[y + 1][x - 1]=true;
        currentplace= (y+1)*10+(x-1);
        return true;
      }

      if (y != (size - 1) && !wordUsed[y + 1][x] && board[y + 1][x] == b)
      {//checked Direct South
        wordUsed[y + 1][x]=true;
        currentplace= (y+1)*10+(x);
        return true;
      }

      if (x != (size - 1) && y != (size - 1) && !wordUsed[y + 1][x + 1] && board[y + 1][x + 1] == b)
      { //Checked DownRight
        wordUsed[y + 1][x + 1]=true;
        currentplace= (y+1)*10+(x+1);
        return true;
      }

      if (x != 0 && !wordUsed[y][x - 1] && board[y][x - 1] == b)
      { //checked Left
        wordUsed[y][x - 1]=true;
        currentplace= (y)*10+(x-1);
        return true;
      }

      if (x != (size - 1) && !wordUsed[y][x + 1] && board[y][x + 1] == b)
      { //check Right
        wordUsed[y][x + 1]=true;
        currentplace= (y)*10+(x+1);
        return true;
      }

      if (x != 0 && y != 0 && !wordUsed[y - 1][x - 1] && board[y - 1][x - 1] == b)
      { //checked upLeft
        wordUsed[y - 1][x - 1]=true;
        currentplace= (y-1)*10+(x-1);
        return true;
      }

      if (y != 0 && !wordUsed[y - 1][x] && board[y - 1][x] == b)
      { //checked Up
        wordUsed[y - 1][x]=true;
        currentplace= (y-1)*10+(x);
        return true;
      }

      if (x != (size - 1) && y != 0 && !wordUsed[y - 1][x + 1] && board[y - 1][x + 1] == b)
      { //check upRight
        wordUsed[y - 1][x + 1]=true;
        currentplace= (y-1)*10+(x+1);
        return true;
      }
      foundIndex=getIndex(a,y,x+1);
    }
    return false;
  }

  private int getIndex(char a,int i, int j)
  {
    for (int y= i; y < size; y++)
    {
      for (int x = j; x< size; x++)
      {
        if(board[y][x]==Character.toUpperCase(a)) return (y*10+x);
      }
    }
    return -1;
  }
}
