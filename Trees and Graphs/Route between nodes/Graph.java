public class Graph
{
  public int size;
  public Node[] nodes;
  private int currentNode;

  public Graph(int reqSize)
  {
    size = reqSize;
    currentNode = 0;
    nodes = new Node[size];
  }

  public void addNode(Node reqNode)
  {
    nodes[currentNode++] = reqNode;
  }

}
