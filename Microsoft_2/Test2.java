import java.util.*;
import java.io.*;
public class Test2 
	{
	   public static void  main (String [] args)
	   	{

	   	 List <Integer> first_list =new ArrayList <Integer> (); 
	   	 List <Integer> second_list =new ArrayList <Integer> ();
	   	 int [] a = {1,2,3,4,5};
	   	 int [] b = {5,6,7,8,9};
	   	/* for (int one :a)
	   	 	{
     			first_list.add(one);
	   	 	}*/
	   	/* for(int two : b)
	   	 	{
	   	 		second_list.add(two);
	   	 	}*/
	   	 	//System.out.println(first_list.get(0));
	   	    System.out.println(merge2 (first_list,second_list));


	   	}
	   	public static List<Integer> merge(List<Integer> first,List<Integer> second)
	   	{
	   		for (int a: second)
	   			{
	   				first.add(a);
	   			}
	   		 Collections.sort(first);
	   		//System.out.println(first.size());

	   		return first ;

	   	}
	   	public static List<Integer> merge2(List<Integer> first,List<Integer> second)
	   		{
	   			if(first.size()==0)
	   			{
	   				return  second;
	   			}
	   			else if(second.size()==0)
	   			{
	   				return first;
	   			}
	   			else if (first.size()==0&& second.size()==0)
	   			{
	   				return null;
	   			}
	   			int a =0;
	   			int b =0 ;
                List <Integer> third = new ArrayList<Integer> ();
	   			while (a< first.size()&& b<second.size())
	   			{
	   				if(first.get(a)< second.get(b))
	   				{
	   					third.add(first.get(a));
	   					a++;
	   				}
	   				else if (first.get(a)> second.get(b)) 
	   				{
	   					third.add(second.get(b));
	   					b++;
	   					
	   				}
	   				else
	   				{
	   					third.add(first.get(a));
	   					third.add(second.get(b));
	   					a++;
	   					b++;
	   				}
	   				//System.out.println(a);

	   			}
	   			System.out.println("here");
	   			System.out.println(a);
	   			System.out.println(b);

	   			if (a!=first.size())
	   				{
	   				System.out.println("here");
                       for(int i=b; i< first.size();i++)
                       {
                       	third.add(first.get(i));
                       }
	   				}
	   			else if (b!=second.size())
	   				{
                       for(int i=b; i< second.size();i++)
                       {
                       	third.add(second.get(i));
                       }
	   				}
	   			return third;

	   		}


	}