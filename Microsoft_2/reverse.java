import java.util.*;
import java.io.*;
public class reverse
	{
		public static void main(String[]args)
			{
               System.out.println(result("hello"));
              // System.out.println(result_2("hellow"));
			//	System.out.println(result_3("hello world"));

			}
		public static String result_3(String sentence )
		 	{
		 		String [] words= sentence.split(" ");
		 		int i=0;
		 		sentence="";
		 		for(String word : words)
		 		{
		 			words[i]=result_2(word);
		 			if(i==0)
		 				{
		 					sentence=words[i];
		 				}
		 			else
		 				{
		 					
		 					sentence= sentence+" "+words[i];
		 				}
		 			
		 			//System.out.println(words[i]);
		 			i++;


		 		}
 
		 		//System.out.println(words[0]);
          
		 		return sentence;
		 	}
		public static String result(String word)
			{
				String new_word="";
				for (int i=word.length()-1;i>=0; i--)
						{
							new_word=new_word+word.charAt(i);
						}
				return new_word;
			}
		public static String result_2(String word)
			{
				int split = word.length()/2;
				int x= word.length()-1;
				char[] c = word.toCharArray();
				for(int i=0; i<split; i++)
				 {
				 	char y=c[i];
				 	//char z=word.charAt(x);
                    c[i]=c[x];
                    c[x]=y;
				 	i++;
				 	x--;

				 }
				return new String(c);
			}
	}