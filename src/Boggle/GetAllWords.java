package Boggle;

class GetAllWords
{
  //Structure to hold every word in the Dictionary and board
  private char[][] board;


  GetAllWords(char[][] board)
  {
    this.board = board;

  }

  boolean isWordinBoard(String InputWord)
  {
    boolean isWordUsed[][] = new boolean[board.length][board.length];
    for (int i = 0; i < InputWord.length()-1; i++)
    {

      if(!checkNeighbour(InputWord.charAt(i),InputWord.charAt(i+1),isWordUsed))
      return false;
    }
    return true;

  }

  private boolean checkNeighbour(char a, char b,boolean[][] wordUsed)
  {
    int foundIndex=getIndex(a,0,0);
    if (foundIndex==-1) return false;

    int y= foundIndex/10;
    int x= foundIndex%10;
    wordUsed[y][x]=true;
    int size=board.length;
    b=Character.toUpperCase(b);
    if(x==size-1 && y==size-1)

    if (x != 0 && y != (size - 1) && !wordUsed[y+1][x-1] && board[y + 1][x - 1]==b )
      return true; //check Downleft

    if (y != (size - 1) && !wordUsed[y+1][x] && board[y + 1][x]==b )
      return true; //check DirectSouth

    if (x != (size - 1) && y != (size - 1)&& !wordUsed[y+1][x+1] && board[y + 1][x + 1]==b)
      return true; // check SouthEast

    if (x != 0 && !wordUsed[y][x-1] && board[y][x - 1]==b)
      return true; //check DirectWest

    if (x != (size - 1) && !wordUsed[y][x+1] && board[y][x + 1]==b)
      return true; //check DirectEast

    if (x != 0 && y != 0 && !wordUsed[y-1][x-1] && board[y - 1][x - 1]==b)
      return true; //check NorthWest

    if (y != 0 && !wordUsed[y-1][x] && board[y - 1][x]==b)
      return true; //check DirectNorth

    if (x != (size-1)&& y != 0 && !wordUsed[y-1][x+1]  && board[y - 1][x + 1]==b)
      return true; // check NorthEast

    //getIndex(a,y,x);
    return false;
  }

  private int getIndex(char a,int i, int j)
  {
    for (int x= i/10; x < board.length; x++)
    {
      for (int y = j%10; y < board.length; y++)
      {
        if(board[x][y]==Character.toUpperCase(a)) return (x*10+y);

      }

    }
    return -1;
  }

}
