import java.util.*;
import java.io.*;
public class Test5 
{
  public static void main(String [] args)
  {
    int [] x={1,2,3,4,5};
    System.out.println(Find(x,3));
  }
  public static boolean Find(int [] a, int item)
    {
      int high =a.length;
      int low =0;
      int index= 0;
      while(low<high)
        {
         index=low+((high-low)/2);
              if(a[index]==item)
                {
                  return true;
                }
                else if(item >a[index])
                {
                low=index+1;

                }
                else
                {
                  high=index-1;
                }
        }

        return false;

    }

}

