import java.util.*;
import java.io.*;
public class Test10
{
  public static void main(String [] args)
  {
    int [] x={1,2,3,4,5};
    //int [] x={};
    System.out.println("here");
    System.out.println(Find(x,5));
  }
  public static boolean Find(int [] a, int item)
    {
      int high =a.length-1;
      int low =0;
      int index= 0;
      while(low<high|| low==high)
        {
         index=low+((high-low)/2);
         //System.out.println(index);
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

