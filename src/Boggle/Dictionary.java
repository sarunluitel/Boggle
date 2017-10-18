package Boggle;
/************************************
 @author Sarun Luitel

 takes in word dictionary and stores for
 rest of the program to use. provices method to binary
 search
 ************************************/
import java.io.*;


class Dictionary
{
// initialize the size of array to hold the entire dictionary.
  private String[] Dictionary = new String[178696];

  // constructor opens dictionary and stores in array.
  Dictionary()
  {
    try
    {

      InputStream is = ClassLoader.getSystemResourceAsStream("res/OpenEnglishWordList.txt");
      InputStreamReader r = new InputStreamReader(is);

    //  File file = new File();
      BufferedReader buffer = new BufferedReader(r);

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

/* The code uses a differnt structure where searchin is not necessary.
unused methods commented.


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

  boolean checkWord(String wordSearch, int Start, int end){
    return binarySearch(wordSearch, Start, end);


  }*/

  String[] getDictionary(){
    return this.Dictionary;
  }
}