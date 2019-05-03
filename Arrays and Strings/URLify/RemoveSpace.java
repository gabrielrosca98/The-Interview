//Change all the ' ' into "%20"
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;


public class RemoveSpace
{
  public static Scanner input;
  public static PrintWriter output;
  public static String theString;

  //Method to remove the spaces
  public static String removeSpaces(String reqString)
  {
    for(int index = 0; index < reqString.length(); index++)
    {
      //If we encounter a space change the string
      if(reqString.charAt(index) == ' ')
      {
        //Take the substring before the space, add the req chars and the
        //substring after the space eliminating the space
        reqString = reqString.substring(0, index) + "%20"
                    + reqString.substring(index + 1);
      }//if
    }//for
    return reqString;
  }//removeSpaces

  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Read the string
      theString = input.nextLine();

      //Transform the string
      theString = removeSpaces(theString);

      //Print the new string
      System.out.println(theString);
    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }//catch
  }//main
}//class
