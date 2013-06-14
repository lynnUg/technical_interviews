//Write a function to zero all duplicate values in an integer array. How would you test it?
import java.util.*;
import java.io.*;
public class Test9
	{
		public static void main(String [] args)
		{
           int [] a ={1,2,2,3,4};
           duplicate_arr(a);
           for(int z :a)
           {
           	System.out.println(z);
           }

		}
		public static void duplicate_arr(int [] values)
		{
			Map<Integer,Integer> duplicate= new HashMap<Integer,Integer>();
			//Map<Character, Integer> match= new HashMap<Character ,Integer> ()
			int i=0;
			for(int a: values)
			{
				if(duplicate.containsKey(a))
				{
					values[duplicate.get(a)]=0;
					values[i]=0;

				}
				else
				{
					duplicate.put(a,i);
				}
			i++;
			}
		}
	}