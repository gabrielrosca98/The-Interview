//Rotate a matrix by 90 degrees
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

public class RotateImage
{
  public static int sizeOfImage;
  public static int[][] image;
  public static Scanner input;
  public static PrintWriter output;

  public static void printMatrix(int[][] reqMatrix)
  {
    for(int index1 = 0; index1 < sizeOfImage; index1++)
    {
      for(int index2 = 0; index2 < sizeOfImage; index2++)
      {
        System.out.print(reqMatrix[index1][index2] + " ");
      }
      System.out.println();
    }
  }

  public static void rotateImage(int[][] reqMatrix)
  {
    for(int index = 0; index < sizeOfImage / 2; index++)
    {
      for(int index1 = index; index1 < sizeOfImage - index - 1; index1++)
      {
        //Save the first element
        int saveFirst = reqMatrix[index][index1];

        //Change top with left
        reqMatrix[index][index1] = reqMatrix[sizeOfImage - index1 - 1][index];

        //Change left with bot
        reqMatrix[sizeOfImage - index1 - 1][index] = reqMatrix[sizeOfImage - index - 1][sizeOfImage - index1 - 1];

        //Change bot with right
        reqMatrix[sizeOfImage - index - 1][sizeOfImage - index1 - 1] = reqMatrix[index1][sizeOfImage - index - 1];

        //Change right with top
        reqMatrix[index1][sizeOfImage - index - 1] = saveFirst;

      }
    }
  }

  public static void main(String[] args)
  {
    try
    {
      input = new Scanner(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      //Read the matrix
      sizeOfImage = input.nextInt();
      image = new int[sizeOfImage][sizeOfImage];
      for(int index1 = 0; index1 < sizeOfImage; index1++)
      {
        for(int index2 = 0; index2 < sizeOfImage; index2++)
        {
          image[index1][index2] = input.nextInt();

          //If we want to do it in place
          //image[index2][sizeOfImage - index1 - 1] = input.nextInt();
        }
      }
      System.out.println("The original matrix: ");
      printMatrix(image);
      rotateImage(image);
      System.out.println("Rotated matrix: s");
      printMatrix(image);
    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
