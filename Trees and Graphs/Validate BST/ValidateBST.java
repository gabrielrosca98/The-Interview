import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class ValidateBST
{
  public static boolean checkBST(Node root,Integer minim, Integer maxim)
  {
    if(root == null)
    {
      return true;
    }
    if((minim != null && root.info <= minim) || (maxim != null && root.info >= maxim) )
    {
      return false;
    }
    if(!checkBST(root.left, minim, root.info) || !checkBST(root.right, root.info, maxim))
    {
      return false;
    }
    return true;
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
      Node root = new Node(10);
      root.left = new Node(5);
      root.right = new Node(15);
      root.left.left = new Node(2);
      root.left.right = new Node(6);
      root.right.right = new Node(20);
      root.right.left = new Node(12);
      System.out.println(checkBST(root, null, null));
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
