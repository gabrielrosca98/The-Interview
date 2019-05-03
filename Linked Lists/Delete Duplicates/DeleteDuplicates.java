import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
public class DeleteDuplicates
{
  public static Scanner input;
  public static PrintWriter output;

  //Delete the duplicates from a linked list
  public static void deleteDuplicate1(Node firstReq)
  {
    HashSet<Integer> infoNodes = new HashSet<Integer>();
    //Add the first element
    infoNodes.add(firstReq.data);
    //Second node to iterate through the list
    Node prevNode = firstReq.next;
    while(prevNode != null)
    {
      //System.out.println(prevNode.data);
      if(!infoNodes.add(prevNode.data))
      {
        firstReq.next = firstReq.next.next;
        prevNode = firstReq.next;
      }
      else
      {
        infoNodes.add(prevNode.data);
        firstReq = firstReq.next;
        prevNode = prevNode.next;
      }
    }
  }
  public static void main(String[] args)
  {
    try
    {
      //Set the input and output
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      int numberElements = input.nextInt();
      int firstInfo = input.nextInt();
      Node firstNode = new Node(firstInfo, 0);
      for(int index = 1; index < numberElements; index++)
      {
        int currentInfo = input.nextInt();
        firstNode.appendToTail(currentInfo, index);
      }
      deleteDuplicate1(firstNode);
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
