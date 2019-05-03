import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Depth
{

  public static void preOrder(Node reqRoot)
  {
    //System.out.println(reqRoot.info);
    reqRoot.visited = false;
    if(reqRoot != null);
    {
      if(reqRoot.left != null)
      {
        preOrder(reqRoot.left);
      }
      if(reqRoot.left != null)
      {
        preOrder(reqRoot.right);
      }
    }
  }

  public static ArrayList<LinkedList<Node>> depthNodes(Node root)
  {
    ArrayList<LinkedList<Node>> depthList = new ArrayList<LinkedList<Node>>();
    LinkedList<Node> level = new LinkedList<Node>();
    if(root != null)
    {
      level.add(root);
    }
    while(!level.isEmpty())
    {
      depthList.add(level);
      LinkedList<Node> parents = level;
      level = new LinkedList<Node>();
      for(Node parent : parents)
      {
        if(parent.left != null)
        {
          level.add(parent.left);
        }
        if(parent.right != null)
        {
          level.add(parent.right);
        }
      }

    }
    return depthList;
  }
  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(new FileReader(args[0]));
      int rootInfo = input.nextInt();
      Node root = new Node(rootInfo);
      root.left = new Node(3);
      root.right = new Node(4);
      root.left.left = new Node(5);
      root.left.right = new Node(6);
      root.right.right = new Node(10);
      preOrder(root);
      ArrayList<LinkedList<Node>> result = depthNodes(root);
      for(LinkedList currentList : result)
      {
        /*for(int index = 0; index < currentList.size(); index++)
        {
          Node currentNode = (Node) currentList.get(index);
          System.out.print(currentNode.info + " ");
        }*/
        while(currentList.peekFirst() != null)
        {
          Node currentNode = (Node) currentList.remove();
          System.out.print(currentNode.info + " ");

        }
        System.out.println();
      }
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
