import java.*;
import java.io.*;
import java.util.Scanner;

public class PowerSet
{
  public static int[] array;

  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(new FileReader(args[0]));
      //int sizeArray = input.nextInt();
      //int k = 0;
      //array = new int[sizeArray];
      String currentLine = input.next();
      input.nextLine();
      //String curr = input.next();
      String newName = "records_" + currentLine;
      System.out.println(newName);

    }
    catch(Exception exception)
    {
      System.err.println(exception);
    }
  }
}
