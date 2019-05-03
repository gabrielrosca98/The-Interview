import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Balanced
{
  public static int heightNode(Node root)
  {
    if(root == null)
    {
      return 0;
    }
    else
    {
      return Math.max(heightNode(root.left), heightNode(root.right)) + 1;
    }
  }
  public static boolean checkBalanced(Node root)
  {
    int leftHeight = heightNode(root.left);
    int rightHeight = heightNode(root.right);
    return Math.abs(leftHeight - rightHeight) < 1;
  }
  public static void main(String[] args)
  {
    try
    {
      // Scanner input = new Scanner(new FileReader(args[0]));
      // int rootInfo = input.nextInt();
      //Test case for balanced
      // Node root = new Node(rootInfo);
      // root.left = new Node(3);
      // root.right = new Node(4);
      // root.left.left = new Node(5);
      // root.left.right = new Node(6);
      // root.right.right = new Node(10);

      //Test case for unbalanced
      Node root = new Node(1);
      root.left = new Node(2);
      root.left.left = new Node(3);
      root.left.left.left = new Node(4);
      root.right = new Node(5);
      if(checkBalanced(root))
      {
        System.out.println("The tree is balanced");
      }
      else
      {
        System.out.println("The tree is not balanced");
      }
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
