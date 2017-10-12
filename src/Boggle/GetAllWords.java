package Boggle;

/************************************
 @author Sarun Luitel

 This class takes in a input and returns if the
 word can be formed from the board.

 ************************************/
class GetAllWords
{
  //Structure to hold every word in the Dictionary and board
  private char[][] board;
  private int size;
  private int currentPlace;
  private char firstChar;
  private char secondChar;
  private int compareChar;


  GetAllWords(char[][] board)
  {
    this.board = board;
    this.size=board.length;
  }
  /*******************************************************************
   @param  InputWord  provided by game comtroller to check if in board

   @return true if word can be formed from the board.

   ********************************************************************/
  boolean isWordinBoard(String InputWord)
  {
    boolean isWordUsed[][] = new boolean[size][size];
    currentPlace =0;
    firstChar = InputWord.charAt(0);
    secondChar = InputWord.charAt(1);
    for (compareChar = 0; compareChar < InputWord.length()-1; compareChar++)
    {

      if(!checkNeighbour(InputWord.charAt(compareChar),InputWord.charAt(compareChar+1),isWordUsed))
        return false;
    }
    return true;
  }
  /*******************************************************************
   @param  a,b,wordUsed  take in characters next to each other and a
   boolean array that sees if a character is already in use.

   methods checks 8 neighbours from a char to see if words can be formed.

   @return true if word can be formed from the board.

   ********************************************************************/

  private boolean checkNeighbour(char a, char b,boolean[][] wordUsed)
  {
    int foundIndex=getIndex(a, currentPlace /10, currentPlace %10);
    if (foundIndex==-1) return false;
    int firstOccurance=foundIndex;

    b=Character.toUpperCase(b);
    while(foundIndex!=-1)
    {
      int y= foundIndex/10;
      int x= foundIndex%10;
      wordUsed[y][x]=true;

      currentPlace=foundIndex;

      b = Character.toUpperCase(b);

      if (x != 0 && y != (size - 1) && !wordUsed[y + 1][x - 1] && board[y + 1][x - 1] == b)
      { //checked DownLeft
        wordUsed[y + 1][x - 1]=true;
        currentPlace = (y+1)*10+(x-1);
        return true;
      }

      if (y != (size - 1) && !wordUsed[y + 1][x] && board[y + 1][x] == b)
      { //checked Direct South
        wordUsed[y + 1][x]=true;
        currentPlace = (y+1)*10+(x);
        return true;
      }

      if (x != (size - 1) && y != (size - 1) && !wordUsed[y + 1][x + 1] && board[y + 1][x + 1] == b)
      { //Checked DownRight
        wordUsed[y + 1][x + 1]=true;
        currentPlace = (y+1)*10+(x+1);
        return true;
      }

      if (x != 0 && !wordUsed[y][x - 1] && board[y][x - 1] == b)
      { //checked Left
        wordUsed[y][x - 1]=true;
        currentPlace = (y)*10+(x-1);
        return true;
      }

      if (x != (size - 1) && !wordUsed[y][x + 1] && board[y][x + 1] == b)
      { //check Right
        wordUsed[y][x + 1]=true;
        currentPlace = (y)*10+(x+1);
        return true;
      }

      if (x != 0 && y != 0 && !wordUsed[y - 1][x - 1] && board[y - 1][x - 1] == b)
      { //checked upLeft
        wordUsed[y - 1][x - 1]=true;
        currentPlace = (y-1)*10+(x-1);
        return true;
      }

      if (y != 0 && !wordUsed[y - 1][x] && board[y - 1][x] == b)
      { //checked Up
        wordUsed[y - 1][x]=true;
        currentPlace = (y-1)*10+(x);
        return true;
      }

      if (x != (size - 1) && y != 0 && !wordUsed[y - 1][x + 1] && board[y - 1][x + 1] == b)
      { //check upRight
        wordUsed[y - 1][x + 1]=true;
        currentPlace = (y-1)*10+(x+1);
        return true;
      }
      firstOccurance++;
      wordUsed=new boolean[size][size];
      compareChar=-1;
      b=Character.toUpperCase(secondChar);

      foundIndex=getIndex(firstChar,firstOccurance/10,firstOccurance%10);


    }
    return false;
  }

  // helper method that loops overbaord to provide index or flags -1 if not found
  private int getIndex(char a,int i, int j)
  {
    a=Character.toUpperCase(a);
    for (int y= i; y < size; y++)
    {
      for (int x = j; x< size; x++)
      {
        if(x==size-1&& y==size-1&& board[y][x]!=a) return-1;
        if(board[y][x]==a) return (y*10+x);
      }
    }
    return -1;
  }
}
