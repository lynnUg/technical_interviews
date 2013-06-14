import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class ExerciseMethods {

  private ExerciseMethods() {
    // Static utility methods.
  }

  public static <E extends Comparable<E>> List<E> mergeSortedLists(List<E> first, List<E> second) {
    List<E> result = new ArrayList<E>();
    ListIterator<E> firstIterator = first.listIterator();
    ListIterator<E> secondIterator = second.listIterator();
    // Iterating instead of going through the indices so that it's also fast for non-random-access
    // lists. For instance, linked-lists would be horrible with index-based iteration.
    while (firstIterator.hasNext() && secondIterator.hasNext()) {
      E firstElement = firstIterator.next();
      E secondElement = secondIterator.next();
      if (firstElement.compareTo(secondElement) <= 0) {
        result.add(firstElement);
        secondIterator.previous();
      } else {
        result.add(secondElement);
        firstIterator.previous();
      }
    }
    // Now we know at least one list is done. So let's just add the rest of the other one.
    ListIterator remainingIterator = firstIterator.hasNext() ? firstIterator : secondIterator;
    List<E> remainingList = firstIterator.hasNext() ? first : second;
    result.addAll(remainingList.subList(remainingIterator.nextIndex(), remainingList.size()));
    return result;
  }

  // TODO(Lynn): Fill out these methods (plus tests):

  /**
   * @param first
   * @param second
   * @return ...
   */
  public static <E extends Comparable<E>> List<E> mergeUnsortedLists(
      List<E> first, List<E> second) 
{
    // TODO
          List <E> result = new ArrayList<E> ();
	  if(first.size()==0&&second.size()==0)
		{
		   return result;
		 }
	   result.addAll(first);
	   result.addAll(second);
	   Collections.sort(result);
	   return result;
    // return null;
  }

  /**
   * @param sorted
   * @param unsorted
   * @return ...
   */
  public static <E extends Comparable<E>> List<E> mergeUnsortedIntoSorted(
      List<E> sorted, List<E> unsorted) {
    // TODO
              List <E> result = new ArrayList<E> ();
	      result.addAll(sorted);

	      ListIterator<E> unsorted_iterator = unsorted.listIterator();
	      
	      
	      
	      while(unsorted_iterator.hasNext())
	     	 {
	     	 	E element= unsorted_iterator.next();
	     	 	int sorted_index =findIndex(result,element);
	     	 	result.add(sorted_index,element);
	     	 	
	     	 	
	     	 	
	     	 }
	     	return result;
		//return null;
  }

  /**
   * @param sortedElements
   * @param element
   * @return ...
   */
  public static <E extends Comparable<E>> int findIndex(List<E> sortedElements, E element) {
    // TODO
                      int low=0;
	   	      int high=sortedElements.size()-1;
	   	      int mid=0;
	   	      while(low<=high)
	   		  {
	   		     mid=low+((high-low)/2);
	   		     if(element.compareTo(sortedElements.get(mid))==0)
	   			{
	   			  return mid;
	   			}
	   			else if(element.compareTo(sortedElements.get(mid))>0)
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

  /**
   * @param numbers
   * @param moreNumbers 0 or more unsorted lists of numbers.
   * @return ...
   */
    public static <N extends Number> double computeMean(List<N> numbers,List<N>... moreNumbers) {
    // TODO
	List<Double> result=new ArrayList<Double>();

       	//result.addAll(numbers);
	for(N item:numbers)
	    {
		result.add(item.doubleValue());
	    }
	for(List<N> the_list :moreNumbers)
	    {
		List<Double> list=new ArrayList<Double>();
                for(N item:the_list)
		       {
			 list.add(item.doubleValue());
		       }
               
		result=ExerciseMethods.mergeSortedLists(result,list);
		
		//System.out.println("here");
	    }
        
	Double sum=0.0;
	for(Double item :result)
	    {
		sum+=item;

	    }
	if(result.size()==0)
	    {
		return 0.0;
	    
            }
	else
	    {
		return sum/result.size();
            }
	  }

  /**
   * @param numbers an unsorted list of numbers.
   * @param moreNumbers 0 or more unsorted lists of numbers.
   * @return ...
   */
    public static <N extends Number> double computeMedian( List<N> numbers,List<N>... moreNumbers) 
    {
       List<Double> result=new ArrayList<Double>();
	for(N item:numbers)
	    {
		result.add(item.doubleValue());
	    }
	for(List<N> the_list :moreNumbers)
	    {
		List<Double> list=new ArrayList<Double>();
                for(N item:the_list)
		       {
			 list.add(item.doubleValue());
		       }
               
		result=ExerciseMethods.mergeSortedLists(result,list);
		
		//System.out.println("here");
	    }
	boolean even= result.size()%2==0 ? true :false;
        int mid=result.size()/2;
        if(even)
	    {
		return (result.get(mid-1)+result.get(mid))/2;
	    }
	else
	    {
		return result.get(mid);
	    }
    }

  // TODO(Lynn): add more test cases for each method.

  private static void testMedian() 
  {
    // TODO
      List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(
                  new Integer[] {1, 3, 6, 9, 13}));
      List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(
        new Integer[] {2, 3, 4, 7, 10, 11, 14}));
      System.out.println("Median of list 1  " + Arrays.asList(firstList.toArray())+ "and list 2 " +Arrays.asList(secondList.toArray())
			 + "is "+computeMedian(firstList,secondList));
      System.out.println();
     
   }
    private static void testMean()
    {
      List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(
                  new Integer[] {1, 3, 6, 9, 13}));
      List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(
        new Integer[] {2, 3, 4, 7, 10, 11, 14}));
      System.out.println("Mean of list 1  " + Arrays.asList(firstList.toArray())+ "and list 2 " +Arrays.asList(secondList.toArray())
			 + "is "+computeMean(firstList,secondList));
       System.out.println();
    }
    private static void testSort()
    {
         List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(
        new Integer[] {1, 3, 6, 9, 13}));
       List<Integer> first_1=new ArrayList<Integer>(Arrays.asList(new Integer[] {5,7,9,10,2,6,7}));
       List<Integer> second_1=new ArrayList<Integer>(Arrays.asList(new Integer[] {3,2,5,1,5,8,7}));
        List<Integer>merged=ExerciseMethods.mergeUnsortedLists(first_1, second_1);
        System.out.println("Merge list 1 unsorted " + Arrays.asList(first_1.toArray())+ "and list 2 unsorted" +Arrays.asList(second_1.toArray())
            	+ "result is "+Arrays.asList(merged.toArray()));
        System.out.println();
        merged=ExerciseMethods.mergeUnsortedIntoSorted(firstList,second_1);
        System.out.println("Merge list 1 sorted " + Arrays.asList(firstList.toArray())+ "and list 2 unsorted" +Arrays.asList(second_1.toArray())
            	+ "result is "+Arrays.asList(merged.toArray()));
        System.out.println();
    }

  public static void main(String[] args) {
    List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(
        new Integer[] {1, 3, 6, 9, 13}));
    List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(
        new Integer[] {2, 3, 4, 7, 10, 11, 14}));
    //1 2 3 3 4 6 7 9 10 11 13 14
    List<Integer> merged = ExerciseMethods.mergeSortedLists(firstList, secondList);
    System.out.println("Merging of " + Arrays.toString(firstList.toArray()) + " and "
        + Arrays.toString(secondList.toArray()) + " gives " + Arrays.toString(merged.toArray()));
    System.out.println();
    // TODO: Call test methods.
    testSort();
    testMedian();
    testMean();
 
      
     
    
    
  }
}
