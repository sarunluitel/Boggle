package Boggle;

import java.util.Arrays;
import java.util.Collections;

class Board
{
  private char[][] boggleBoard;

   Board(int size)
  {
    boggleBoard = new char[size][size];
    Character[] temp = getAlphabetArray();

    int j=0;
    for (int i=0; i < (size*size) ; i++)
    {

      boggleBoard[j][i%size]=temp[i];
      System.out.print("   "+boggleBoard[j][i%size]+"   ");
      if (i%size==(size-1)){j++; System.out.println("\n");}

    }

  }

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

    return wordArray;

  }

  char[][] getBoard(){
    return this.boggleBoard;
  }


}
