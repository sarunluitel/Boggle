package Boggle;

import java.util.Scanner;

public class main
{

  public static void main(String[] args)
  {

    Dictionary dictionary=new Dictionary();
    if(dictionary.binarySearch(getInput(),0,178697))
    {
      System.out.println("word in the dictionary");
    }
  }

  static String getInput()
  {
    System.out.println("type a word you want to find");
    Scanner in = new Scanner(System.in);

    return in.next();
  }

}

