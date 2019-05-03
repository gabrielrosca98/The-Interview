import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
import java.io.InputStreamReader;
public class Palindrome
{
  public static Scanner input;
  public static PrintWriter output;

  public static boolean checkPalindrome(Node reqFirst)
  {
    Node reversedList = reverseList(reqFirst);
    while(reqFirst != null && reversedList != null)
    {
      System.out.println(reqFirst.data +  " " + reversedList.data);
      if(reqFirst.data != reversedList.data)
      {
        return false;
      }
      reqFirst = reqFirst.next;
      reversedList = reversedList.next;
    }

    return true;
  }

  public static Node reverseList(Node reqFirst)
  {
    Node headList = null;
    while(reqFirst != null)
    {

      Node currentNode = new Node(reqFirst.data);
      currentNode.next = headList;
      headList = currentNode;
      reqFirst = reqFirst.next;
    }

    return headList;
  }

  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Get the number of elements
      //int numberElements = input.nextInt();
      String s = input.nextLine();
      String newHour = "";
        if(s.charAt(8) == 'P')
        {
            int hour = Character. getNumericValue(s.charAt(0)) * 10 + Character. getNumericValue(s.charAt(1));
            hour = (hour != 12) ? hour + 12 : 12;
            Character newH1 = (char)((hour / 10 % 10) + '0');
            Character newH2 = (char)((hour % 10) + '0');
            System.out.println(newH2);
            newHour = "" + newH1 + "" + newH2 + s.substring(2,8);
            System.out.println(newHour);
        }
        else
        {
            if(s.substring(0,2).equals("12"))
            {

              newHour = "00" + s.substring(2,8);
            }
            else{
              newHour = s.substring(0,8);
            }
            System.out.println(newHour);
        }
      //Store the list
      /*int firstInfo = input.nextInt();
      Node firstNode = new Node(firstInfo);
      for(int index = 1; index < numberElements; index++)
      {
        int currentInfo = input.nextInt();
        firstNode.appendToTail(currentInfo);
      }
      System.out.println(checkPalindrome(firstNode));
      /*
      //Iterate through the list
      Node iterator = firstNode;
      while(iterator != null)
      {
        System.out.print(iterator + " ");
        iterator = iterator.next;
      }
      System.out.println();*/

    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }//catch
  }
}
