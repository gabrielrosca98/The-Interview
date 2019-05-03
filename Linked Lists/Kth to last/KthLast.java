import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
public class KthLast
{
  public static Scanner input;
  public static PrintWriter output;

  public static Node returnKth(Node reqFirst, int kth)
  {
    Node current = reqFirst;
    Node follower = reqFirst;
    for(int index = 0; index < kth - 1; index++)
    {
      if(current == null) return null;
      current = current.next;
    }

    while(current.next != null)
    {
      current = current.next;
      follower = follower.next;
    }

    return follower;
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
      Node firstNode = new Node(firstInfo);
      for(int index = 1; index < numberElements; index++)
      {
        int currentInfo = input.nextInt();
        firstNode.appendToTail(currentInfo);
      }
      int reqK = input.nextInt();
      System.out.println(reqK);
      System.out.println(returnKth(firstNode, reqK));
      //Iterate through the list
      /*
      Node iterator = firstNode;
      while(iterator != null)
      {
        System.out.println(iterator);
        iterator = iterator.next;
      }*/

    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }//catch
  }
}
