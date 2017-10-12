package Boggle;
/*******************************************************************
@author Sarun Luitel
class makes the board as a variable for multie classes to use.
 ********************************************************************/
class ViewBoard
{
  private static char[][] Board;

  static void setBoard(char[][] board){
    Board=board;
  }

  static char[][] getBoard(){
    return Board;
  }
}
