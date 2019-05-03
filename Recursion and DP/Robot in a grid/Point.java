public class Point
{
  public int xCoord;
  public int yCoord;
  public Point(int reqX, int reqY)
  {
    xCoord = reqX;
    yCoord = reqY;
  }

  public String toString()
  {
    return xCoord + " " + yCoord;
  }
}
