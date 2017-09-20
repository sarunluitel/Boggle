package Boggle;


import java.io.*;
import java.util.Scanner;

public class main
{
  private static BufferedReader reader;


  public static void main(String[] args)
  {

    openFile();
    linearSearch(getInput());
  }

  static String getInput(){
    System.out.println("type a word you want to find");
    Scanner in = new Scanner(System.in);

    return in.next();
  }



  static void linearSearch(String wordSearch){

    try
    {
      System.out.println("Method: linear search");


      while(true)
      {
        if((reader.readLine()).equalsIgnoreCase(wordSearch))
        {
          System.out.println("Found :" + wordSearch);
          System.exit(10);
        }
      }

    }
    catch(Exception e)
    {
      System.out.println("Not Found :" + wordSearch);
    }

  }

  static void openFile()
  {
    try
    {
      File file = new File("/home/sarun/IdeaProjects/Boggle/src/res/OpenEnglishWordList.txt");
      reader = new BufferedReader(new FileReader(file));


    }
    catch (Exception e)
    {

    }
  }
}
