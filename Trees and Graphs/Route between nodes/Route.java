import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;
public class Route
{
  public static Node[] listNodes;

  //Search using a BFS
  public static boolean isRoute(Node startNode, Node finalNode, Graph reqGraph)
  {
    if(startNode == finalNode)
    {
      return true;
    }
    for(Node currNode : reqGraph.nodes)
    {
      currNode.visited = false;
    }
    //List used to store the nodes to be visited
    LinkedList<Node> queue = new LinkedList<Node>();

    //Mark the start node
    startNode.visited = true;

    //Add it to the list
    queue.add(startNode);

    while(!queue.isEmpty())
    {

      //Remove the first node in the list
      Node currNode = queue.removeFirst();
      if(currNode != null)
      {
        //Search through all the children
        for(Node indexNode : currNode.children)
        {
          if(indexNode.visited == false)
          {
            if(indexNode == finalNode)
            {
              return true;
            }
            else
            {
              indexNode.visited = true;
              queue.add(indexNode);
            }
          }
        }
        currNode.visited = true;
      }
    }

    return false;
  }
  public static void main(String[] args)
  {
    Scanner input;
    try
    {
      input = new Scanner(new FileReader(args[0]));

      int sizeOfGraph = input.nextInt();
      Graph graph = new Graph(sizeOfGraph);
      listNodes = new Node[sizeOfGraph];

      //Add the nodes to the graph
      for(int index = 0; index < sizeOfGraph; index++)
      {
        int reqChild = input.nextInt();
        Node currNode = new Node(index, reqChild);
        listNodes[index] = currNode;
        graph.addNode(listNodes[index]);
      }

      //Add the links between the nodes
      listNodes[0].addChildren(listNodes[1]);
      listNodes[0].addChildren(listNodes[3]);
      listNodes[1].addChildren(listNodes[2]);
      listNodes[1].addChildren(listNodes[3]);
      listNodes[2].addChildren(listNodes[0]);
      listNodes[2].addChildren(listNodes[3]);
      listNodes[5].addChildren(listNodes[4]);
      int firstNode = input.nextInt();
      int finalNode = input.nextInt();
      if(isRoute(listNodes[firstNode], listNodes[finalNode], graph))
      {
        System.out.println("There is a route between node " + firstNode +
                           " and " + finalNode + ".");
      }
      else
      {
        System.out.println("There is no route between node " + firstNode + 
                           " and " + finalNode + ".");
      }

    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
