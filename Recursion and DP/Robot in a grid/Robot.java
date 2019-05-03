import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.util.*;
public class Robot
{
  public static boolean maze[][];
  public static ArrayList<Point> getPath(boolean[][] maze)
  {
    if(maze == null || maze.length == 0)
    {
      return null;
    }
    ArrayList<Point> path = new ArrayList<Point>();
    if(getPath(maze, maze.length - 1, maze[0].length - 1, path))
    {
      return path;
    }
    return null;
  }

  public static boolean getPath(boolean[][] maze, int row, int column, ArrayList<Point> path)
  {
    if(row < 0 || column < 0 || !maze[row][column])
    {
      return false;
    }

    boolean origin = (row == 0) && (column == 0);
    if(origin || getPath(maze, row, column - 1, path) ||
       getPath(maze, row - 1, column, path))
    {
      Point point = new Point(row, column);
      path.add(point);
      return true;
    }

    return false;
  }
  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(new FileReader(args[0]));
      int rows = input.nextInt();
      int columns = input.nextInt();
      maze = new boolean[rows][columns];
      for(int index = 0; index < rows; index++)
      {
        for(int index2 = 0; index2 < columns; index2++)
        {
          if(input.nextInt() == 1)
          {
            maze[index][index2] = true;
          }
          else
          {
            maze[index][index2] = false;
          }
        }
      }

      ArrayList<Point> path = getPath(maze);
      Iterator<Point> iterator = path.iterator();
      while(iterator.hasNext())
      {
        System.out.println(iterator.next());
      }
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
