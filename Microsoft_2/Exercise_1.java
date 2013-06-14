import java.util.*;
import java.io.*;
import java.lang.Comparable;
public class Exercise_1
	{
		public static void main (String [] args)
		{
			 
			List <String> firstList= new ArrayList<String> (Arrays.asList(new String []  {"boy","girl","bat"}));
			List <String> secondList = new ArrayList<String> ();
			List <String> merged= merge(firstList,secondList);
			System.out.println(Arrays.toString(merged.toArray()));



		}
		public static <T extends Comparable <T>> List<T> merge (List<T> unsorted_1,List<T> unsorted_2)
		{
			List <T> result = new ArrayList<T> ();
			if(unsorted_1.size()==0&&unsorted_2.size()==0)
				{
					return result;
				}
			result.addAll(unsorted_1);
			result.addAll(unsorted_2);
			Collections.sort(result);
			return result;


		}


	}
