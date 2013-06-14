import java.util.*;
import java.lang.*;
public class LCP_2
       {
	   
             public static void main  (String [] args)
	     	    {
                        String [] words={"ab","abpt","abss"};
                        //System.out.println(the_LCP(words));  
			//System.out.println("here "+the_LRS("abbbcccc")); 
			//System.out.println(bin(8));
                        //System.out.println(dec("1001"));
			//System.out.println((int)'A');
		       	System.out.println(hex2dec("2AE"));
			System.out.println(Swap("10101011010101"));
                        int [][] matrix={{1,2,3,4},{5,6,7,8} ,{9,10,11,12},{13,14,15,16}};
                        System.out.println("1,2,3,4");
			System.out.println("5,6,7,8");
			System.out.println("9,10,11,12");
			System.out.println("13,14,15,16");
			int the_size=matrix.length;
			String a="abcrfghwetf";
			String b="abcfghwwetxyab";
			//Character [] the_array1=a.toCharArray();
			//Character [] the_array2=b.toCharArray();
			List <Character> the_list1=new ArrayList<Character>(Arrays.asList(new Character[] {'a','b','c','r','f','g','h','w','e','t','f'}));
			List <Character> the_list2=new ArrayList<Character>(Arrays.asList(new Character[] {'a','b','c','f','g','h','w','w','e','t','x','y','a','b'}));
			System.out.println(LS(the_list1,the_list2));
			//System.out.println(LS("abcrfghwetf","abcfghwwetxyab"));
			//Spiral(matrix,the_size,the_size);
			System.out.println(Arrays.toString(sort(new int[]{1,2,0,4,0,0,8})));
		        permute("","abc");
			System.out.println("hello".substring(1,4));
			System.out.println(Palind("civil"));
			System.out.println("bin3 "+bin3(7));
			System.out.println(reverse("hello"));
		    }
            public static String the_LCP(String [] words)
	    	   {
                            String prefix="";
                           if(words.length>=1)
			   prefix=words[0];
                         for(int i=0; i<words.length ;i++)
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
		       
		       List <String> suffix=new ArrayList<String>();
		       for(int i=0;i<word.length();i++)
			   {
                              
                               suffix.add(word.substring(i,word.length()));
                           }
		       Collections.sort(suffix);
                       String prefix="";
		       String lrs="";
                       if(suffix.size()>=1)
			   prefix=suffix.get(0);
                       for(int i=1;i<word.length();i++)
			   {
			       String x=suffix.get(i);
			       
			       System.out.println(prefix+ " x " +x);
                               int j=0;
			       for(;j<Math.min(prefix.length(),x.length());j++)
						{
						    
						    if(prefix.charAt(j)!=x.charAt(j))
							{
							    //System.out.println("j not "+prefix.charAt(j));
							break;
                                                        }
						    //System.out.println("the_prefix "+ prefix);
						    //System.out.println("here2");
						  
                                                }
			       prefix=prefix.substring(0,j);
			       if(prefix.length()>lrs.length())
				   lrs=prefix;
                               prefix=x;
                               
                           }
		       //return prefix;
                       return lrs;
                   }
           public static String bin(int n)
	   {
	       String output="";
	       while(n>1)
		   {
		       
		       output=n%2+output;
		       //if(n>1)
                       n=n/2;
                   }
	       return 1+output;
            }
           public static int dec(String bin)
           {
	       int output=0;
	       for(int i=bin.length()-1;i>=0;i--)
		   {
		       if(bin.charAt(i)=='1')
			   output+=Math.pow(2,bin.length()-1-i);
		   }
               return output;
	   }
	   public static int hex2dec(String str)
	         {
		     
                     String output="";
		     for(int i=0;i<str.length();i++)
			 {
			     if((int)str.charAt(i)<=57)
				 {
				     String s=  bin(str.charAt(i)-'0');
				     for(int j=s.length();j<4;j++)
					 s="0"+s;
				     //output+=bin(str.charAt(i)-'0');
				     output+=s;
				 }
			     
                             else
				 output+=bin((str.charAt(i)-'A')+10);
                         }
		     System.out.println(output);
		     return dec(output);
		 }
	   public static String Swap(String s)
	   {
	       char [] the_array =s.toCharArray();
	       char temp='0';
	       for(int i=0;i<s.length()-2;i+=2)
		   {
		       temp=the_array[i];
		       the_array[i]=the_array[i+1];
                       the_array[i+1]=temp;
		   }
	       return new String(the_array);
            }
	   public static void Spiral(int [][] matrix,int xsize,int ysize)
	   {
	       int l=0; int k=0;
	       ysize-=1 ;xsize-=1;
	        while(l<=ysize&&k<=xsize)
	       {
		       for(int i=l;i<=xsize;i++)
			   System.out.print(matrix[k][i]+" ");
		         k++;
			 //System.out.println(" here_1");
		        for(int i=k;i<=ysize;i++)
		       	   System.out.print(matrix[i][ysize]+" ");
		       ysize--;
		       //System.out.println(" here2");
		       for(int i=ysize;i>=l;i--)
		       	   System.out.print(matrix[xsize][i]+" ");
		       // System.out.println(" here3");
                       xsize--;
		       for(int i=xsize;i>=k;i--)
		       	   System.out.print(matrix[i][l]+" " );
		       l++;
		       //System.out.println(" here4");
		       
		  }
		System.out.println();
	   }
	   public static String LCS(String a , String b)
	       {
		   
		   if(a.length()==0 || b.length()==0)
		       return"";
		   else if(a.charAt(a.length()-1)==b.charAt(b.length()-1))
		       return LCS(a.substring(0,a.length()-1),b.substring(0,b.length()-1))+a.charAt(a.length()-1);
				   else
				       {
					   //String x=a.substring(a.length()-1,a.length());
					   //String y=b.substring(b.length()-1,b.length());
					   //return LCS(x,y);
					   String x= LCS (a,b.substring(0,b.length()-1));
					   String y= LCS (a.substring(0,a.length()-1),b);
					   return x.length()>y.length() ? x:y;
				       }
               }
	   public static String LS(List<Character> a ,List<Character>b)
	      {
		  String the_ls="";
		  String x="";
		  int index=0;
		  ListIterator <Character> a_It=a.listIterator();
		  ListIterator <Character> b_It=b.listIterator();
		  while(a_It.hasNext()&&b_It.hasNext())
		      {
			  char A=a_It.next();
			  char B=b_It.next();
			  if(A!=B)
			      {
				  if(x.length()>the_ls.length())
				      the_ls=x;
				  b_It.previous();
				  x="";
			      }
			  else
			      {
				  x+=A;
			      }
		      }
		 
		  return the_ls;
	      }
	   public static int [] sort(int[] the_array)
	        {
		    int temp=0;
		    int pivot=0;
		    int high=the_array.length-1;
		    int low=0;
		    while(pivot<high)
			{
			    if(the_array[pivot]==0)
				{
				    temp=the_array[pivot];
				    the_array[pivot]=the_array[high];
				    the_array[high]=temp;
				    high--;
				}
			    else
				{
				    temp=the_array[pivot];
				    the_array[pivot]=the_array[low];
				    the_array[low]=temp;
				    low++;
				    pivot++;
				}
			    
			}
		    return the_array;

		}
	   public static void permute (String other, String word)
	       {
		   if(word.length()<=1)
		       System.out.println(other+" "+word);
		   else
		       {
			   for(int i=0;i<word.length();i++)
			       {
				   String newString =word.substring(0,i)+word.substring(i+1);
				   permute(other+word.charAt(i),newString);
			       }
		       }   

               }
	   public static boolean Palind(String word)
	          {
		      if(word.length()==1)
			  return true;
			  else
			      return (word.charAt(0)==word.charAt(word.length()-1))&&Palind(word.substring(1,word.length()-1));
                  }
	   public static String bin2(int n)
	       {
		   if(n<=1)
		       return ""+n;

		   String A= bin2(n/2);
		   A+=n%2;
		   return A;
               }
	    public static String bin3(int n)
	       {
		   if(n<=1)
		       return ""+n;
		   return bin3(n/2)+n%2;
               }
	   public static String reverse (String word)
	   {
	       if(word.length()<=1)
		   return word;
	       else 
		   return reverse(word.substring(1))+word.charAt(0);
		   
	   }
	   /* public static String last(String sentence,int n)
	   {
	       if(n==10)
		   return "";
	       else 
		   
		   if(sentence.substring(word.length-2,word.length)=="\n")
                    n++;
                    else
			sentence
		   return 
		   }*/
	   
       }
