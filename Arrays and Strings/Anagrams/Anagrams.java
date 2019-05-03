//Program will check whether two words are anagrams or not

import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.Collections;
import java.io.FileReader;
import java.util.Map;
import java.util.Iterator;

public class Anagrams
{
  public static TreeMap<Character, Integer> firstWord = new TreeMap<Character, Integer>();
  public static TreeMap<Character, Integer> secondWord = new TreeMap<Character, Integer>();

  public static boolean checkAnagrams(String firstString, String secondString)
  {
    if(firstString.length() != secondString.length())
    {
      return false;
    }
    for(int index = 0; index < firstString.length(); index++)
    {
      Character currentChar1 = firstString.charAt(index);
      Character currentChar2 = secondString.charAt(index);

      if(firstWord.get(currentChar1) == null)
      {
        firstWord.put(currentChar1, 1);
      }
      else
      {
        firstWord.put(currentChar1, firstWord.get(currentChar1) + 1);
      }
      if(secondWord.get(currentChar2) == null)
      {
        secondWord.put(currentChar2, 1);
      }
      else
      {
        secondWord.put(currentChar2, secondWord.get(currentChar2) + 1);
      }

      Iterator<Map.Entry<Character, Integer>> iterator1 = firstWord.entrySet().iterator();
      Iterator<Map.Entry<Character, Integer>> iterator2 = secondWord.entrySet().iterator();

      while(iterator1.hasNext())
      {
        Map.Entry<Character, Integer> element1 = iterator1.next();
        Map.Entry<Character, Integer> element2 = iterator2.next();
        if(element2.getValue() != element1.getValue() || element1.getKey() != element2.getKey())
        {
          return false;
        }//if
      }//while
    }//for
    return true;
  }//checkAnagrams
  public static void main(String[] args)
  {
    //Set the input and output to null
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //Set the input and output
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Read the string
      System.out.println("Please enter the two words: ");
      String word1 = input.readLine();
      String word2 = input.readLine();
      System.out.println(checkAnagrams(word1, word2));
    }
    catch (Exception exception)
    {
      System.err.println(exception);
    }
    finally
    {
      //Try to close the input
      try { if(input != null) input.close();}
      catch(IOException exception)
        {System.err.println("Could not close input" + exception);}
      if(output != null)
      {
        //Close the output
        output.close();
        //Check if there was any error during closing the output
        if(output.checkError())
        {
          System.err.println("Something went wrong");
        }
      }//if
    }//finally
  }//main
}//class
