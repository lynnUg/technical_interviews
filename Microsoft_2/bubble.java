import java.util.*;
import java.io.*;
public class bubble 
    {
      public static void main(String[] args)
        {
          int [] array1 = {12,9,4,99,120,1,3,10};
          bubble_srt(array1,array1.length);
          for(int a: array1)
            {
              //System.out.println(a);
            }


        }
      public static void bubble_srt( int a[], int n )
        {
          int i,j,t=0;
          i=0;
         // for(i = 0; i < n; i++)
         // {
             for(j = 1; j < (n-i); j++)
             {
              System.out.println(a[j-1]);
              System.out.println(a[j]);
              System.out.println(t);
               if(a[j-1] > a[j])
               {
                     t = a[j-1];
                     a[j-1]=a[j];
                     a[j]=t;
             //  }
            }
          }
        }
    }
