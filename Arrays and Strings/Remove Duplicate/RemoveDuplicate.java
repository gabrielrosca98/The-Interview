//The program will check if a string contains only unique characters using
//a HashSet to store the characters found in the String


import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Collections;
import java.io.FileReader;
public class RemoveDuplicate
{
  public static String removeDuplicate(String reqString)
  {
    for(int index = 0; index < reqString.length(); )
    {
      //If this is a duplicate modify the string
      if(reqString.indexOf(reqString.charAt(index)) != index)
      {
        reqString = reqString.substring(0, index) + reqString.substring(index + 1);
      }
      else
      {
        //If not advance through the string
        index++;
      }

    }
    return reqString;
  }
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
      System.out.print("Please enter the desired word: ");
      String line = input.readLine();
      String newLine = removeDuplicate(line);
      System.out.println("The word which contains no duplicates is: " + newLine);
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
