//Reverse the order of words in a string ("ab cd ef gh" becomes "gh ef cd ab")
import java.util.*;
import java.io.*;
public class Test6
	{
		public static void main (String [] args)
		{
		  String sentence ="ab cd ef gh";
		  String [] sent_array=sentence.split(" ");
		  for(String a: sent_array)
		  		{
		  			System.out.println(a);
		  		}
		  	String new_sent=sent_array[sent_array.length-1];
          
		  for(int i=sent_array.length-2;i>=0;i--)
			{
              new_sent+=" "+sent_array[i];
			}
		 System.out.println(new_sent);
		}
	}