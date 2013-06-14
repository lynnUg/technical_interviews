import java.util.*;
import java.lang.*;
public class Exercise_11
	{
		public static void main(String []args)
		{
			
			//System.out.println(Arrays.toString(new_array));
		}
		public static int[] Compact(int the array)
		{
			//int [] the_array={1,1,2,2,3,3,4,4};
			HashSet<Integer> the_set=new HashSet<Integer>();
			for(int item: the_array )
				{
 					if(!the_set.contains(item))
 						{
 							the_set.add(item);


 						}
				}
			int [] new_array=new int [the_set.size()];
			System.out.println(the_set.size());
    		int i=0; 
			for(int a :the_set)
				{
					new_array[i]=a;
					i++;

				}
		return new_array;
		}

	    public static void the_route()
	    {
	       Map <String, String> routes =new HashMap<String, String>();
	       for()

	    }
	}