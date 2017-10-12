package Boggle;
/************************************
 @author Sarun Luitel

 Provides methods and attribues to keep track
 of Alphabets in the board .
 ************************************/
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Board
{
  private char[][] boggleBoard;

  /*****************************************************
   @param size gets size of the board to make.

   construct an Object Board with an attribute as nxn board.

   ********************************************************/
  Board(int size)
  {
    boggleBoard = new char[size][size];
    Character[] temp = getAlphabetArray();//get a list of shuffled alphabets

    int j=0;
    for (int i=0; i < (size*size) ; i++)
    {

      boggleBoard[j][i%size]=temp[i];
    //  System.out.print("   "+boggleBoard[j][i%size]+"   ");//uncomment for cmd
      if (i%size==(size-1))j++;// System.out.println("\n");}// command line board

    }

  }
  /*****************************************************
   @return  form a an Character array of shuffled letters of
   AAAA,BBBB.....ZZZZ
   ********************************************************/
  private Character[] getAlphabetArray()
  {
    Character[] wordArray = new Character[104];
    int i=0;
    for(char alphabet = 'A'; alphabet <= 'Z';alphabet++)
    {
      for (int j=0;j<4;j++)
      {
        wordArray[i] = alphabet;
        i++;
      }

    }

    Collections.shuffle(Arrays.asList(wordArray));
    Collections.shuffle(Arrays.asList(wordArray));
    return probQU(wordArray);

  }
  /*****************************************************
   * @param wordArray takes in shuffled array
   @return  increases the array where Q&U are likely together
   ********************************************************/
  private Character[] probQU(Character[] wordArray){

    int Q=0,U=0;
    Random random = new Random();
    for (int i = 0; i < 104; i++)
    {
      if (wordArray[i]=='Q'&& Q==0) Q=i;
      if (wordArray[i]=='U'&& U==0) U=i;
    }
    if (random.nextInt(2)==1)
    {
      char temp = wordArray[Q+1];
      wordArray[Q+1]='U';
      wordArray[U]=temp;
    }
    return wordArray;
  }

  char[][] getBoard(){
    return this.boggleBoard;
  }


}
