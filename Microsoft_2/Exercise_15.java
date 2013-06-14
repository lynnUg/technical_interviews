import java.util.*;
import java.lang.*;
import java.io.*;
 public class Exercise_15
 {
   public static void main(String [] args)
   {
   		//int a =Integer.parseInt("1");
   		String[] theword={"a","1","b","2","c","3","d","4"};//"a1b2c3d4";
   		String [] new_pos={"a","b","c","d","1","2","3","4"};
   		
   		Organize(theword, new_pos);
   		System.out.println(Arrays.toString(theword));
   		
   }

   public static void Organize(String [] theword_1 ,String [] new_pos_1)
   {
   	//String theword_1=StringUtils.join(theword,",");
   	String theword="";
   	String new_pos="";
   	for(String letter:theword_1)
   	{
   		theword+=letter;
   	}
   	for(String letter:new_pos_1)
   	{
   		new_pos+=letter;
   	}
   	//System.out.println(theword_1);

   	char temp=0;
   	char end_String=0;
   	char start_String=0;
   	int String_pos=0;
    int Int_pos=0;
   	for(int x=0 ; x<new_pos.length();x++)
   	{
   		if(new_pos.charAt(x)<temp)
   		{
   		 //System.out.println(x);
   		 Int_pos=x;
   		 start_String=new_pos.charAt(0);
         String_pos=x-1;
         end_String=new_pos.charAt(x-1);
         
         break;
   		}
   		 temp= new_pos.charAt(x);
   	}
   	//System.out.println(String_pos + " " +Int_pos);
   	//System.out.println(binary_search('1',new_pos,4,7));
   	for(int i=0;i<theword_1.length;i++)
   	 {
   	 	int pos=0;

   	 	char a=theword_1[i].charAt(0);

        if(a<=end_String&&a>=start_String)
        {
        	//System.out.println("String " +end_String+ " "+start_;
        	pos=binary_search(a,new_pos,0,String_pos);
        }
        else
        {
        	//System.out.println("int"+ (int)(a));
        	pos=binary_search(a,new_pos,Int_pos,new_pos.length()-1);


        }
       
   	 	if(i!=pos)
   	 	{
   	 		//System.out.println(pos); 
          String temp_2=theword_1[i];
          theword_1[i]=theword_1[pos];
          theword_1[pos]=temp_2;

   	 		//swap(i,new_pos,theword);

   	 	}
        //System.out.println(Arrays.toString(theword_1));
   	 	

   	 }

   }
   public static int binary_search(char a,String word,int start ,int end)
   {

   	int lo=start;
   	int hi=end;
   	int mid=0;
   	while(lo<=hi)
   	{ 

   		mid=lo+((hi-lo)/2);
   		//System.out.println(mid);
   		//System.out.println(lo);
   		if(a==word.charAt(mid))
   		{
   			return mid;
   		}
   		else if(a>word.charAt(mid))
   		{
   			lo=mid+1;
   		}
   		else
   		{
   			hi=mid-1;
   		}

   	}
   	return -1;
   }
   //public static 

 }