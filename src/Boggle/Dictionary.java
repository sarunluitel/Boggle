package Boggle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


class Dictionary
{

  private String[] Dictionary = new String[178696];

  Dictionary()
  {
    try
    {
      File file = new File("src/res/OpenEnglishWordList.txt");
      BufferedReader buffer = new BufferedReader(new FileReader(file));

      String thisLine;
      int i = 0;

      while ((thisLine = buffer.readLine()) != null)
      {
        Dictionary[i] = thisLine;
        i++;
      }


    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private boolean binarySearch(String wordSearch, int start, int end)
  {
    int pivot = (start + end) / 2;

    int compare = Dictionary[pivot].compareToIgnoreCase(wordSearch);
    if (compare == 0) return true;
    if((end-start)==1) return false;
    if (compare > 0) return binarySearch(wordSearch, start, pivot);
    if (compare < 0) return binarySearch(wordSearch, pivot, end);

    return false;

  }

  public boolean checkWord(String wordSearch, int Start, int end){
    return binarySearch(wordSearch,Start , end);
  }
}