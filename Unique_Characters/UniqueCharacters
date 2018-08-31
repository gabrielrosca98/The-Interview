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
public class UniqueCharacters
{
  public static HashSet<Character> charactersString;
  public static boolean isUnique(String reqString)
  {
    //Create a new HashSet to store the characters in the string
    charactersString = new HashSet<Character>();

    //If there are more than 52 characters return false
    if(reqString.length() > 52)
    {
      return false;
    }

    //For each letter in the string check if it has been already added
    for(int index = 0; index < reqString.length(); index++)
    {
      if(!charactersString.add(reqString.charAt(index)))
      {
        //If it's been already added return false
        return false;
      }//if
    }//for

    //The string contains only unique characters
    return true;
  }//isUnique


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
      String line = input.readLine();

      //Output the answer
      if(isUnique(line))
      {
        System.out.println("The string contains only unique characters.");
      }
      else
      {
        System.out.println("The string contains duplicates.");
      }
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
