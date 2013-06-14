import java.util.*;
import java.lang.*;
import java.io.*;
public class Test
       {
         public static void main (String [] args)
	 	{
		    //permute("","abc");
                    //System.out.println(reverse("hello"));
		    //System.out.println(Palind("civics"));
		    // System.out.println(bin(7));
		    // String [] words= {"abaa","abba","abbab","abbabb"};
		    // System.out.println(LCP(words));
		    //System.out.println(the_LRS("helllo"));
		    // int [] numbers ={-1,-2,-7,8,5,6,-8,-9};
		    //System.out.println(FindMax(numbers));
		    //System.out.println(MaxSub(numbers));
		    int [] numbers={1,2,3,4,5,6};
		    System.out.println(binarySearch(numbers ,6));
		    List <Integer> first= new ArrayList<Integer> (Arrays.asList(new Integer[]{1,2,3,4,5}));
		    List <Integer> second= new ArrayList<Integer> (Arrays.asList(new Integer[]{1,2,3,4,5}));
		    List <Integer> merged=merge(first,second);
		    System.out.println(Arrays.toString(merged.toArray()));
		    int [][] the_array={{1,2,3},{4,5,6},{7,8,9}};
		    Rotate(the_array);
		    System.out.println(isSubstring("achart","cl"));
		    String word="helzo";
		    //System.out.println(word.substring(1,3));
		    //System.out.println(word.substring(3));
		    Sequence("abcefgabczhgabc","abc");
		     int n=128;
		     //n=n>>7;
                     n=n&1;
		      //n=n>>2;
		      //System.out.println(n);
		     System.out.println(toHex(9));
		     sumFile("test.txt");

		}
	public static void permute (String other,String word)
	       {
                       if(word.length()<=1)
                           System.out.println(other+" " +word);
			else
			{
			    for(int i=0;i<word.length();i++)
			    	    {
                                        String newWord=word.substring(0,i)+word.substring(i+1);
					permute(other+word.charAt(i),newWord);
			            }	
			}
               }
           public static String reverse(String word)
	   {
	       if(word.length()<=1)
		   return word;
	       else
		   return reverse(word.substring(1))+word.charAt(0);
           }
           public static boolean Palind(String word)
	       {
		   if(word.length()<=1)
		       return true;
		   else
		       return (word.charAt(0)==word.charAt(word.length()-1))&&Palind(word.substring(1,word.length()-1));
               }
	   public static String bin(int n)
	   {
	       if(n<=1)
		   return ""+n;
	       else
		   return bin(n/2)+n%2;
	   }
	   public static String LCP(String [] words)
	   {
	       String prefix="";
	       if(words.length>=1)
		   prefix=words[0];
	       for(int i=0;i<words.length;i++)
		   {
                       int j=0;
                       for(;j<Math.min(prefix.length(),words[i].length());j++)
			   {
			       if(prefix.charAt(j)!=words[i].charAt(j))
				   break;
                           }
		       prefix=prefix.substring(0,j);
		   }
	       return prefix;
	   }
	   public static String the_LRS(String word)
           {
	       String [] words=new String[word.length()];
	       for(int i=0;i<words.length;i++)
		   words[i]=word.substring(i,word.length());
	       Arrays.sort(words);
	       String prefix="";
	       String lrs="";
	       if(words.length>=1)
		   prefix=words[0];
	       for(int i=words.length-1;i>=0;i--)
		   {
		       System.out.println(words[i]);
		       int j=0;
		       for(;j<Math.min(prefix.length(),words[i].length());j++)
			   {
			       if(prefix.charAt(j)!=words[i].charAt(j))
				   break;
			   }
		       prefix=prefix.substring(0,j);
		       if(prefix.length()>lrs.length())
			   lrs=prefix;
		       prefix=words[i];
		   }
	       return lrs;
           }
	   public static int FindMax(int [] numbers)
	      {
                  int max=0;
		  int max2=0;
		  for(int i=0;i<numbers.length;i++)
		      {
			  if(numbers[i]>max)
			      {
				  max2=max;
			          max=numbers[i];
                              
                              }
			  else if(numbers[i]>max2)
			      max2=numbers[i];
			  
		       }
		  return max2;
	      }
           public static int MaxSub(int [] numbers)
	      {
		  int MaxatPoint=0;
                  int MaxOverall=0;
		  //int sum=0;
                  for(int i=0;i<numbers.length;i++)
		      {
			  //MaxatPoint+=numbers[i];
			  MaxatPoint=Math.max(0,MaxatPoint+numbers[i]);
			  MaxOverall=Math.max(MaxatPoint,MaxOverall);
		      }
		  return MaxOverall;
              }
	   public static int binarySearch(int [] numbers,int item)
	          {
		      int low=0;
		      int high=numbers.length-1;
		      int mid=0;
                      while(low<=high)
			  {
			      mid=low+((high-low)/2);
			      if (numbers[mid]==item)
				  return mid;
                              else if(item>numbers[mid])
				  low=mid+1;
			      else
				  high=mid-1;
			  }
		      return 0;
		      
                  }
           public static<E extends Comparable<E>> List<E> merge(List<E> first,List<E> second  )
                 {
                    List<E> result =new ArrayList<E>();
		    ListIterator<E>  firstIterator =first.listIterator();
		    ListIterator<E> secondIterator=second.listIterator();
		    while(firstIterator.hasNext()&&secondIterator.hasNext())
			{
                         E firstElement =firstIterator.next();
			 E secondElement=secondIterator.next();
			 if(firstElement.compareTo(secondElement)<=0)
				{
                                   result.add(firstElement);
				   secondIterator.previous();
				}
			  else
				{
				result.add(secondElement);
				firstIterator.previous();
				}
                        }
		     ListIterator remainingIterator = firstIterator.hasNext()?firstIterator :secondIterator;
                     List<E> remaininglist =firstIterator.hasNext()? first :second;
		     result.addAll(remaininglist.subList(remainingIterator.nextIndex(),remaininglist.size()));
			return result;
                  }
	   public static void Rotate(int [][] the_array)
	          {
                      int l=0;
		      int k=0;
		      int xsize=the_array.length-1;
		      int ysize=the_array[0].length-1;
		      System.out.println(xsize+" " +ysize);
		      while(l<=xsize&&k<=ysize)
			  {
			      for(int i=l;i<=xsize;i++)
				  System.out.println(the_array[k][i]+" ");
			      k++;
			      for(int i =k;i<=ysize;i++)
				  System.out.println(the_array[i][ysize]+" ");
			      ysize--;
			      for(int i=ysize;i>=l;i--)
				  System.out.println(the_array[xsize][i]+" ");
			      xsize--;
			      for(int i=xsize;i>=k;i--)
				  System.out.println(the_array[i][l]+" ");
			      l++;
                          }
                  }
	   public static boolean isSubstring(String first,String second)
	   {
	       boolean truth=true;
               for(int i=0;i<first.length();i++)
		   {
		       for(int j=0 ;j<second.length() && i+j <first.length();j++)
			   {
			       if(first.charAt(i+j)!=second.charAt(j))
				   {  
				   truth=false;
				   break;
				   }
			       if(truth)
				   return truth;
			       
			   }
		   }
	       return false;
	   }
	   public static String Sequence(String word,String pattern)
	   {
	      
	       int index=0;
	       int j=0;
	       int i=0;
	       while(i<=word.length())
		   {
		    
		       if(i<word.length()&&j<pattern.length() &&word.charAt(i)==pattern.charAt(j))
			   {

			       if(j==0)
				   index=i;
			       j++;
			   }
		       else
			   {
			      
			       if(word.substring(index,i).equals(pattern))
				  {
				     
				      word=word.substring(0,index)+"X"+word.substring(i);
				      
				      j=0;
				     
                                  }
			       
			 }   
		       i++;
                   }
	   //System.out.println(word);
	       return word;
	   }
	   public static int Fib(int n)
	   {
	       return n<=1 ? n:Fib(n-1)+Fib(n-2);
	   }
           public static void sumFile ( String name )
             {
              try {
                    int total = 0;
                    BufferedReader in = new BufferedReader ( new FileReader ( name ));
                     for ( String s = in.readLine(); s != null; s = in.readLine() ) 
                        {
                             total += Integer.parseInt ( s );
                        }
                       System.out.println ( total );
                      in.close();
                 }
               catch ( Exception xc )
                {
                  xc.printStackTrace();
               }
           }
	 public static String toHex ( int c )
          {
                 String s = Integer.toHexString ( c );
                 return ( s.length() == 1 ) ? "0" + s : s;
          }
        
       }
