//Check whether 2 words are 1 edit away from each other(insert/remove/replace char)
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Collections;
import java.io.FileReader;
import java.io.BufferedReader;

public class OneAway
{
  public static BufferedReader input;
  public static PrintWriter output;
  public static boolean isOk(String reqString1, String reqString2)
  {
    if(Math.abs(reqString1.length() - reqString2.length()) > 1)
    {
      return false;
    }
    int mini = Math.min(reqString1.length(), reqString2.length());
    int index = 0;
    while(index < mini && reqString1.charAt(index) == reqString2.charAt(index))
    {
      index++;
    }
    if(reqString1.substring(0, index).equals(reqString2) || reqString2.substring(0, index).equals(reqString1))
    {
      return true;
    }
    if(reqString1.substring(index + 1).equals(reqString2) || reqString2.substring(index + 1).equals(reqString1))
    {
      return true;
    }
    if(reqString1.substring(index + 1).equals(reqString2.substring(index + 1)))
    {
      return true;
    }
    if(reqString1.substring(index + 1).equals(reqString2.substring(index)) ||
       reqString2.substring(index + 1).equals(reqString1.substring(index)) )
    {
      return true;
    }
    return false;
  }
  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      String word1 = input.readLine();
      String word2 = input.readLine();
      System.out.println(isOk(word1, word2));
    }
    catch (Exception exception)
    {
      System.err.println(exception);
    }
  }
}
