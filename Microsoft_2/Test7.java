//Switch every pair of words in a string ("ab cd ef gh" becomes "cd ab gh ef")
import java.util.*;
import java.io.*;
public class Test7

	{
		public static void main(String []args)
		 {
             String sentence = "ab cd ef gh";
             String [] words= sentence.split(" ");
             int div_array= words.length/2;
             String temp="";
             int start=0;
             int end=words.length-1;
             /*for(int i=0; i<div_array;i++)
             {
               temp=words[start];
               words[start]=words[end];
               words[end]=temp;
               start++;
               end--;

             }*/
             for(int i=0; i<div_array;i++)
             {
               temp=words[start];
               words[start]=words[start+1];
               words[start+1]=temp;
               start+=2;
               //end--;

             }
             sentence=words[0];
             for(int i=1; i<words.length;i++)
             {
             	sentence+=" "+words[i];

             }
             System.out.println(sentence);
            //System.out.println(arrayToString(words));
		 }
	}