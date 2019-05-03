import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.Collections;
import java.io.FileReader;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashMap;
public class ZeroMatrix
{
  public static Scanner input;
  public static PrintWriter output;
  public static int m;
  public static int n;
  public static int[][] matrix;

  public static void printMatrix(int[][] reqMatrix,  int reqS1,int reqS2)
  {
    for(int index1 = 0; index1 < m; index1++)
    {
      for(int index2 = 0; index2 <n; index2++)
      {
        System.out.print(matrix[index1][index2] + " ");
      }//for
      System.out.println();
    }//for
  }//printMatrix

  public static int[][] zeroMatrix(int[][] reqMatrix, int reqS1,int reqS2)
  {
    HashMap<Integer, Integer> coord = new HashMap<Integer, Integer>();
    for(int index1 = 0; index1 < reqS1; index1++)
    {
      for(int index2 = 0; index2 < reqS2; index2++)
      {
        if(reqMatrix[index1][index2] == 0)
        {
          coord.put(index1, index2);
        }
      }
    }

    Iterator<Map.Entry<Integer, Integer>> iterator = coord.entrySet().iterator();
    while(iterator.hasNext())
    {
      Map.Entry<Integer, Integer> coordinate = iterator.next();
      for(int index1 = 0; index1 < reqS1; index1++)
      {
        reqMatrix[index1][coordinate.getValue()] = 0;
      }
      for(int index1 = 0; index1 < reqS2; index1++)
      {
        reqMatrix[coordinate.getKey()][index1] = 0;
      }
    }
    return reqMatrix;
  }

  public static void main(String[] args)
  {
    try
    {
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      m = Integer.parseInt(input.next());
      n = Integer.parseInt(input.next());
      matrix = new int[m][n];

      //Read the matrix
      for(int index1 = 0; index1 < m; index1++)
      {
        for(int index2 = 0; index2 <n; index2++)
        {
          matrix[index1][index2] = Integer.parseInt(input.next());
        }//for
      }//for

      System.out.println("The initial matrix: ");
      printMatrix(matrix, m, n);
      System.out.println();
      matrix = zeroMatrix(matrix, m, n);
      System.out.println("The change matrix: ");
      printMatrix(matrix, m, n);

    }//try
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
