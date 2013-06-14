public class Binary
       {
      public static void main (String [] args)
            { 
		bin(4);
          } 
      public static void bin(int a)
          { 
               if (a>1)
                  bin(a/2);
               System.out.println(a%2);  
         }
      }