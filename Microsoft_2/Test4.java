import java.util.*;
import java.io.*;
public class Test4
	{
	  public static void main(String [] args)
	  	{
	  		int [] a ={1,2,3,4,5};
            Queue list =new Queue ();
	  		for(int item : a)
	  			{

	  				list.queue(item);

	  			}
	  			String b=list.dequeue().toString();
	  		System.out.println(b);
	  		Stack list2 =new Stack ();
	  		for(int item : a)
	  			{

	  				list2.push(item);

	  			}
	  			String z=list2.pop().toString();
	  			System.out.println(z);
	  	}
	}