import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
public class SumLists
{
  public static Scanner input;
  public static PrintWriter output;

  public static Node addLists(Node reqFirst, Node reqSecond)
  {
    int firstNumber = 0;
    int secondNumber = 0;
    int power = 1;
    while(reqFirst != null)
    {
      firstNumber += reqFirst.data * power;
      power *= 10;
      reqFirst = reqFirst.next;
    }
    power = 1;
    while(reqSecond != null)
    {
      secondNumber += reqSecond.data * power;
      power *= 10;
      reqSecond = reqSecond.next;
    }

    int finalNumber = secondNumber + firstNumber;

    Node finalNode = new Node(finalNumber % 10);
    finalNumber /= 10;
    while(finalNumber != 0)
    {
      finalNode.appendToTail(finalNumber % 10);
      finalNumber /= 10;
    }
    return finalNode;
  }

  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Get the number of elements
      int numberElements1 = input.nextInt();
      int numberElements2 = input.nextInt();

      //Store the list
      int firstInfo = input.nextInt();
      Node firstNode = new Node(firstInfo);
      for(int index = 1; index < numberElements1; index++)
      {
        int currentInfo = input.nextInt();
        firstNode.appendToTail(currentInfo);
      }

      int secondInfo = input.nextInt();
      Node secondNode = new Node(secondInfo);
      for(int index = 1; index < numberElements2; index++)
      {
        int currentInfo = input.nextInt();
        secondNode.appendToTail(currentInfo);
      }


      //Iterate through the list
      Node iterator = addLists(firstNode, secondNode);
      while(iterator != null)
      {
        System.out.print(iterator + " ");
        iterator = iterator.next;
      }
      System.out.println();

    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }//catch
  }
}
