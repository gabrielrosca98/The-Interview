import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;

public class MinimalTree
{
  public static int[] elementsArray;
  public static void preOrderTraversal(Node node)
  {
    if(node != null)
    {
      System.out.println(node.info);
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }
  public static Node createTree(int startIndex, int finishIndex, int[] array)
  {
    if(startIndex > finishIndex)
    {
      return null;
    }
    int mid = (startIndex + finishIndex) / 2;
    Node root = new Node(array[mid]);
    root.left = createTree(startIndex, mid - 1, array);
    root.right = createTree(mid + 1, finishIndex, array);
    return root;
  }

  public static void main(String[] args)
  {
    Scanner input;
    try
    {
      input = new Scanner(new FileReader(args[0]));
      int numberElements = input.nextInt();
      elementsArray = new int[numberElements];
      for(int index = 0; index < numberElements; index++)
      {
        elementsArray[index] = input.nextInt();
      }

      Node root = createTree(0, numberElements - 1, elementsArray);
      preOrderTraversal(root);
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
