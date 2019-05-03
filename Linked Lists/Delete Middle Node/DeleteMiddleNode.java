import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
public class DeleteMiddleNode
{
  public static Scanner input;
  public static PrintWriter output;

  public static Node deleteNode(Node reqFirst, int reqNode)
  {
    if(reqFirst == null)
    {
      System.out.println("Invalid list");
      System.exit(0);
    }

    //If the node to be deleted is the head
    if(reqFirst.data == reqNode)
    {
      return reqFirst.next;
    }

    //Check between the head and tail for the node
    Node current = reqFirst;
    while(current.next.next != null)
    {
      if(current.next.data == reqNode)
      {
        current.next = current.next.next;
        return reqFirst;
      }
      current = current.next;
    }

    //If the last node is to be deleted
    if(current.next.data == reqNode)
    {
      current.next = null;
      return reqFirst;
    }

    return reqFirst;
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
      int deleteNode = input.nextInt();

      //Delete the node with the req info
      firstNode = deleteNode(firstNode, deleteNode);

      //Iterate through the list
      Node iterator = firstNode;
      while(iterator != null)
      {
        System.out.println(iterator);
        iterator = iterator.next;
      }

    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }//catch
  }
}
