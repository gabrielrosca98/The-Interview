import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
public class Partition
{
  public static Scanner input;
  public static PrintWriter output;

  public static Node partitionN(Node reqFirst, int reqPart)
  {
    Node head = null;
    Node tail = null;
    Node currHead = null;
    while(reqFirst != null)
    {
      if(reqFirst.data < reqPart)
      {
        if(head != null)
        {
          head.appendToTail(reqFirst.data);
          currHead = currHead.next;
        }
        else
        {
          head = new Node(reqFirst.data);
          currHead = head;
        }
      }
      else
      {
        if(tail != null)
        {
          tail.appendToTail(reqFirst.data);
        }
        else
        {
          tail = new Node(reqFirst.data);
        }
      }
      reqFirst = reqFirst.next;
    }
    currHead.next = tail;
    return head;
  }

  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Get the number of elements
      int numberElements = input.nextInt();

      //Store the list
      int firstInfo = input.nextInt();
      Node firstNode = new Node(firstInfo);
      for(int index = 1; index < numberElements; index++)
      {
        int currentInfo = input.nextInt();
        firstNode.appendToTail(currentInfo);
      }
      int partitionNode = input.nextInt();
      //Partition the node
      firstNode = partitionN(firstNode, partitionNode);
      //Iterate through the list
      Node iterator = firstNode;
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
