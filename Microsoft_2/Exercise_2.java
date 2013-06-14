import java.util.*;
import java.lang.*;
import java.io.*;
public class Exercise_2
	{
	  public static void main(String [] args)
	  	{
	  		List <Integer> first= new ArrayList<Integer> (Arrays.asList(new Integer[] {1,2,3,5,7,8}));
	  		List <Integer> second=new ArrayList<Integer>(Arrays.asList(new Integer[] {0,5,7,9,11,10}));
	  		//second.add(0,21);
	  		List <Integer> merged=merge(first,second);
	  		System.out.println(Arrays.toString(merged.toArray()));
	  		//Integer [] array1=(Integer[])first.toArray();
	  		//System.out.println(binary_search(first,6));



	  	}
	  public static <T extends Comparable <T> > List <T>  merge(List <T> sorted ,List <T> unsorted)
	   {
	      List <T> result = new ArrayList<T> ();
	      result.addAll(sorted);

	      ListIterator<T> unsorted_iterator = unsorted.listIterator();
	      
	      
	      
	      while(unsorted_iterator.hasNext())
	     	 {
	     	 	T element= unsorted_iterator.next();
	     	 	int sorted_index =0;
	     	 	boolean inList=false;
	     	 	ListIterator<T> sorted_iterator=result.listIterator();
	     	 	while(sorted_iterator.hasNext())
	     	 		{
	     	 		  T element_2=sorted_iterator.next();

	     	 			if(element.compareTo(element_2)<=0)
	     	 			{
	     	 				result.add(sorted_index,element);
                            inList= true;
	     	 				break;
	     	 			}
	     	 			sorted_index++;
	     	 		}
	     	 		if(!inList)
	     	 			{

	     	 				result.add(sorted_index,element);
	     	 			}
	     	 	
	     	 }
	     	return result;

	   }
	    public static <T extends Comparable <T> > List <T>  merge2(List <T> sorted ,List <T> unsorted)
	   {
	      List <T> result = new ArrayList<T> ();
	      result.addAll(sorted);

	      ListIterator<T> unsorted_iterator = unsorted.listIterator();
	      
	      
	      
	      while(unsorted_iterator.hasNext())
	     	 {
	     	 	T element= unsorted_iterator.next();
	     	 	int sorted_index =binary_search(result,element);
	     	 	result.add(sorted_index,element);
	     	 	
	     	 	
	     	 	
	     	 }
	     	return result;

	   }
	  /* public static <T extends Comparable<T> > List<T> merge2(List<T> sorted,List<T> unsorted)
	   {
	   	List <T> result=new ArrayList<T>();
	   	ListIterator unsorted_iterator = unsorted.listIterator();
	   	while(unsorted_iterator.hasNext())
	   		{
	   			T element= unsorted_iterator.next();
	   			binary_search()

	   		}
	   	return result;
	   }*/
	   public static <T extends Comparable <T>> int binary_search(List<T> search , T item)
	   		{
	   			//System.out.println("here_1");
	   			int low=0;
	   			int high=search.size()-1;
	   			int mid=0;
	   			while(low<=high)
	   			{
	   				mid=low+((high-low)/2);
	   			   if(item.compareTo(search.get(mid))==0)
	   			   {
	   			   	return mid;
	   			   }
	   			   else if(item.compareTo(search.get(mid))>0)
	   			   {
	   			   	low=mid+1;
	   			   }
	   			   else
	   			   {
	   			   	high=mid-1;
	   			   }
	   			}
	   			return mid;
	   		}
	}