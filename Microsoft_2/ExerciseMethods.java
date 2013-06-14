import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

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

  public static void main(String[] args) {
    List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(
    	new Integer[] {1, 3, 6, 9, 13}));
    List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(
    	new Integer[] {2, 3, 4, 7, 10, 11, 14}));
    List<Integer> merged = ExerciseMethods.mergeSortedLists(firstList, secondList);
    System.out.println("Merging of " + Arrays.toString(firstList.toArray()) + " and "
    	+ Arrays.toString(secondList.toArray()) + " gives " + Arrays.toString(merged.toArray()));
  }
}