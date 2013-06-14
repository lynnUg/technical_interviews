import java.util.*;
import java.lang.*;
public class Exercise_3
	{
	   public static void main(String [] args)
	   	{
	   		List<Float> first_1=new ArrayList<Float>(Arrays.asList(new Float[] {5f,7f,9f,10f,2f,6f,7f}));
	   		List<Float> second_1=new ArrayList<Float>(Arrays.asList(new Float[] {3f,2f,5f,1f,5f,8f,7f}));
	   		List <Float> merged =merge(first_1,second_1);
            System.out.println("Merge list 1 unsorted " + Arrays.asList(first_1.toArray())+ "and list 2 unsorted" +Arrays.asList(second_1.toArray())
            	+ "result is "+Arrays.asList(merged.toArray()));
            System.out.println();
	   		
	   		List<Float> first_2=new ArrayList<Float>(Arrays.asList(new Float[] {1f,2f,3f,4f,5f,6f,7f}));
	   		merged=merge2(first_2,second_1);
	   		 System.out.println("Merge list 1 sorted " + Arrays.asList(first_2.toArray())+ "and list 2 unsorted" +Arrays.asList(second_1.toArray())
            	+ "result is "+Arrays.asList(merged.toArray()));
	   		
	   		System.out.println();
            System.out.println("Mean of list 1  " + Arrays.asList(first_1.toArray())+ "and list 2 " +Arrays.asList(second_1.toArray())
            	+ "is "+mean(first_1,second_1));
	   		System.out.println();

	   		List<List<Float>> third_1=new ArrayList< List<Float>>();
	   		third_1.add(first_1);
	   		third_1.add(second_1);
	   		 System.out.println("Mean of list 1  " + Arrays.asList(first_1.toArray())+ "and list 2 " +Arrays.asList(second_1.toArray())
            	+ "is "+mean2(third_1));
	   		System.out.println();

	   		System.out.println("Median of list 1  " + Arrays.asList(first_2.toArray())+ "is " +median(first_2));
	   		System.out.println();

	   		System.out.println("Median of list 1  " + Arrays.asList(first_2.toArray())+ "and list 2 " +Arrays.asList(first_2.toArray())
            	+ "is "+median(first_2,first_2));





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
	  
	   public static <T extends Comparable <T>> int binary_search(List<T> search , T item)
	   		{
	   			
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

	   	public static Float mean(List<Float>first, List<Float>second)
	   	{
	   	   if(first.size()==0 && second.size()==0)
	   	    {
	   	      return 0.0f;
	   	    }

	   	    ListIterator<Float> firstIterator = first.listIterator();
	   	    ListIterator<Float> secondIterator = second.listIterator();
	   	    Float sum=0.0f;
	   	   
	   	    
	   	    while(firstIterator.hasNext()&& secondIterator.hasNext())
	   	    {
	   	    	sum+=firstIterator.next()+secondIterator.next();
	   	    }
	   	    ListIterator<Float> remainIterator=firstIterator.hasNext()? firstIterator : secondIterator;
	   	    List<Float> remain=firstIterator.hasNext()? first: second;

             while(remainIterator.hasNext())
             {
             	sum+=remainIterator.next();
             }
             return sum/(first.size()+second.size());

	   	}


	   	public static Float mean2(List<List<Float>> many)
	   	{
	   	   if(many.size()==0)
	   	   {
	   	   	return 0f;
	   	   }
          
	   	   ListIterator<List<Float>> many_Iter =many.listIterator();
	   	   Float sum=0f;
	   	   int num_items=0;
	   	   while(many_Iter.hasNext())
	   	   {
	   	   	List <Float> list_1=many_Iter.next();
	   	   	ListIterator<Float> list_1_iter=list_1.listIterator();
	   	   	while(list_1_iter.hasNext())
	   	   		{
	   	   		  sum+=list_1_iter.next();

	   	   		}
	   	   	num_items+=list_1.size();
	   	   }
	   		return sum/num_items;
	   	}

	   	public static Float median(List <Float>list_1)
	   	{
	   		if(list_1.size()==0)
	   		{
	   			return 0f;
	   		}
	   		int mid =list_1.size()/2;
	   		return list_1.get(mid);
	   	}
	   	public static Float median(List<Float>list_1,List<Float> list_2)
	   	{
	   		if(list_1.size()==0&&list_2.size()==0)
	   		{
	   			return 0f;
	   		}
            int mid=(list_1.size()+list_2.size())/2;
            int tracker=0;
	   		ListIterator<Float> list_1_iter=list_1.listIterator();
	   		ListIterator<Float> list_2_iter=list_2.listIterator();
	   		//List<Float> result=new ArrayList<Float>();
	   		while(list_1_iter.hasNext()&&list_2_iter.hasNext())
	   		{
	   			Float element_1= list_1_iter.next();
	   			Float element_2=list_2_iter.next();
               if(element_1<=element_2)
               {
               	if(tracker==mid)
               	{
               		return element_1;
               	}
                 list_2_iter.previous();
               }
               else
               {
               	if(tracker==mid)
               	{
               		return element_2;
               	}
               	list_1_iter.previous();

               }

               tracker++;

	   		}
	   		ListIterator<Float> remainIterator=list_1_iter.hasNext()?list_1_iter:list_2_iter;
	   		List<Float> remain=list_1_iter.hasNext()? list_1 :list_2;
	   		while(remainIterator.hasNext())
	   		{
	   			Float element_3=remainIterator.next();
	   			if(tracker==mid)
	   			{
	   				return element_3;
	   			}
	   			tracker++;
	   		}
	   		return 0.0f;
	   	}

	}