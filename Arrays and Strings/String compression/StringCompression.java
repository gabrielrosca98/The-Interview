import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Collections;
import java.io.FileReader;
import java.io.BufferedReader;

public class StringCompression
{
  public static BufferedReader input;
  public static PrintWriter output;
  public static String compresString(String reqString)
  {
    String newString = "";
    int index = 0;
    while(index < reqString.length())
    {
      int apparition = 1;
      int indexChar = index + 1;
      while(indexChar < reqString.length()
                      && reqString.charAt(index) == reqString.charAt(indexChar))
      {
        apparition++;
        indexChar++;
      }
      newString = newString + reqString.charAt(index)
                  + Integer.toString(apparition);
      index = indexChar;
    }
    if(newString.length() > reqString.length())
    {
      return reqString;
    }
    else
    {
      return newString;
    }
  }
  public static void main(String[] args)
  {

    try
    {
      //Set the input and output
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      String word = input.readLine();
      System.out.println(compresString(word));
    }
    catch (Exception exception)
    {
      System.err.println(exception);
    }
  }
}
