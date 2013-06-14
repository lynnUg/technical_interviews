//Write a function that compares two strings and returns a third string containing only the letters that appear in both
import java.util.*;
import java.io.*;
public class Test8
	{
		public static void main (String [] args )
		{
          System.out.println(compare("bay","ball"));
		}
		public static String compare(String first , String second)
		{
			Map<Character, Integer> match= new HashMap<Character ,Integer> ();
			
			char[] char_array1 = first.toLowerCase().toCharArray();
    		char[] char_array2 = second.toLowerCase().toCharArray();

			for(char a: char_array1)
			{
				if(match.containsKey(a))
				{
					match.put(a,match.get(a)+1);

				}
				else
				{
				 	match.put(a,1);
				}				 
			}
			String the_new="";
			for(char a: char_array2)
			{
				if(match.containsKey(a))
				{
					if(match.get(a)==1)
					{
						the_new+=a;
						match.remove(a);
						

					}
					else
					{
						the_new+=a;
						match.put(a,match.get(a)-1);
					}
					

				}
							 
			}
			return the_new; 
		}
	}