import java.util.*;
import java.lang.*;

public class Exercise_5
	{
		 public static void main(String [] args)
			{
				int [][] a={{1,2,3},{4,5,6},{7,8,9}};
				//System.out.println(a[0].length);
				//rotate(a);
				List<Integer> numbers= new ArrayList<Integer> (Arrays.asList(new Integer[] {1,2,3,4,5}));
				Find_pair(numbers,5);
				System.out.println(longest_sub("bbbb"));


			}
		public static int[][] rotate (int [][] the_matrix)
			{
				/*for(int i=0;i<the_matrix.length;i++)
					{
						for(int j=0;j<the_matrix[i].length;j++)
								{
									System.out.print(the_matrix[i][j]+" ");
									
								}
								System.out.println();
					}
					System.out.println();*/
				for(int i=0;i<the_matrix.length;i++)
					{
						for(int j=i+1;j<the_matrix[i].length;j++)
								{
									//System.out.print(the_matrix[i][j]+" ");
									the_matrix[i][j]=the_matrix[i][j]+the_matrix[j][i];
									the_matrix[j][i]=the_matrix[i][j]-the_matrix[j][i];
									the_matrix[i][j]=the_matrix[i][j]-the_matrix[j][i];

								}
								//System.out.println();
					}
					/*for(int i=0;i<the_matrix.length;i++)
					{
						for(int j=0;j<the_matrix[i].length;j++)
								{
									System.out.print(the_matrix[i][j]+" ");
									
								}
								System.out.println();
					}*/
					for(int i=0;i<the_matrix.length;i++)
					{
						for(int j=0;j<the_matrix[i].length/2;j++)
						{
							the_matrix[i][j]=the_matrix[i][j]+the_matrix[i][the_matrix.length-1-j];
							the_matrix[i][the_matrix.length-1-j]=the_matrix[i][j]-the_matrix[i][the_matrix.length-1-j];
							the_matrix[i][j]=the_matrix[i][j]-the_matrix[i][the_matrix.length-1-j];
						}
					}
					for(int i=0;i<the_matrix.length;i++)
					{
						for(int j=0;j<the_matrix[i].length;j++)
								{
									System.out.print(the_matrix[i][j]+" ");
									
								}
								System.out.println();
					}
					
				return the_matrix;


			}
		  public static void Find_pair(List<Integer> numbers,int k)
		  {
		  	Map<Integer ,Integer> pair = new HashMap<Integer,Integer>();
		  	ListIterator<Integer> numbers_iter= numbers.listIterator();
		  	int i=0;
		  	while(numbers_iter.hasNext())
		  	{
		  		pair.put(numbers_iter.next(),i);
		  		i++;
		  	}
		  	ListIterator<Integer> numbers_it= numbers.listIterator();
		  	while(numbers_it.hasNext())
		  	{
		  		int element= numbers_it.next();
		  		//System.out.println(element);
		  		if(pair.containsKey(k-element))
		  		{
		  			System.out.println(k-element + " "+ element );
		  		}
		  		
		  	}

		  }
		  public static int longest_sub(String word)
		  	{
		  		HashSet<Character> the_set=new HashSet<Character>();
		  		int index=0;
		  		int max=0;
		  		//while ()
		  		for(int i=0 ;i<word.length();i++)
		  			{
		  				if(the_set.contains(word.charAt(i)))
		  				{
		  					max=Math.max(max,i-index);

		  					while(word.charAt(i)!=word.charAt(index))
		  					{
		  						the_set.remove(word.charAt(index));
		  						index++;
		  					}
		  					index++;

		  				}
		  				else
		  				{
		  					the_set.add(word.charAt(i));
		  				}
		  			}
		  		return max;
		  	}


	}