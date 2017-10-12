package Boggle;

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
