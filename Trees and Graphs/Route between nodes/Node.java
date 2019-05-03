public class Node
{
  public int  value;
  public Node[] children;
  public int  numberChildren;
  public boolean visited;
  private int currentChild = 0;

  public Node(int reqValue, int reqChild)
  {
    value = reqValue;
    numberChildren = reqChild;
    children = new Node[numberChildren];
  }

  public void addChildren(Node reqNode)
  {
    children[currentChild++] = reqNode;
  }
}
