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
import java.util.Scanner;
import java.util.HashMap;

public class PalindromePerm
{
  public static BufferedReader input;
  public static PrintWriter output;
  public static HashMap<Character, Integer> charWord = new HashMap<Character, Integer>();
  public static String deleteSpaces(String reqString)
  {
    String newString = "";
    for(int index = 0; index < reqString.length(); index++)
    {
      if(reqString.charAt(index) != ' ')
      {
        newString = newString + reqString.charAt(index);
      }
    }
    return newString;
  }
  public static boolean checkPalindrome(String reqString)
  {
    for(int index = 0; index < reqString.length(); index++)
    {
      Character currentChar = reqString.charAt(index);
      if(charWord.get(currentChar) == null)
      {
        charWord.put(currentChar, 1);
      }
      else
      {
        charWord.put(currentChar, charWord.get(currentChar) + 1);
      }
    }
    boolean ok = true;
    Iterator<Map.Entry<Character, Integer>> iterator = charWord.entrySet().iterator();
    while(iterator.hasNext())
    {

      Map.Entry<Character, Integer> currentItem = iterator.next();
      if(currentItem.getValue() % 2 == 1 && ok)
      {
        ok = false;
      }
      else
        if(currentItem.getValue() % 2 == 1 && !ok)
        {
          return false;
        }
    }
    return true;
  }
  public static void main(String[] args)
  {

    try
    {
      //Set the input and output
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      String word = input.readLine();
      System.out.println(checkPalindrome(deleteSpaces(word)));
    }
    catch (Exception exception)
    {
      System.err.println(exception);
    }
  }
}
