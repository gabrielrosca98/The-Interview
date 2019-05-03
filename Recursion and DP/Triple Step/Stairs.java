import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.InputStreamReader;
public class Stairs
{
  public static int numberSol = 0;
  public static void solution(int reqStairs)
  {
    //System.out.println(reqStairs);
    if(reqStairs == 0)
    {
      numberSol++;
    }
    else
    {
      if(reqStairs > 0)
      {
        solution(reqStairs - 1);
        solution(reqStairs - 2);
        solution(reqStairs - 3);
      }
    }
  }

  public static int solution1(int reqStairs)
  {
    if(reqStairs < 0)
    {
      return 0;
    }
    else
    {
      if(reqStairs == 0)
      {
        return 1;
      }
      else
      {
        return solution1(reqStairs - 1) + solution1(reqStairs - 2) + solution1(reqStairs - 3);
      }
    }
  }
  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(new InputStreamReader(System.in));
      int numberStairs = input.nextInt();
      System.out.println(solution1(numberStairs));
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
