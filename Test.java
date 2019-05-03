import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test
{
  public static HashSet<Integer> myHash = new HashSet<Integer>();
  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(new InputStreamReader(System.in));
      int number = Integer.parseInt(input.next());
      int numb = input.nextInt();
      System.out.println(number + " " + numb);
      while(input.hasNext())
      {
        int x = input.nextInt();
        myHash.add(x);
      }
      Iterator iterator = myHash.iterator();
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
