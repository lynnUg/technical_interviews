import java.util.*;
import java.io.*;
public class reverse2
	{
		public static void main (String [] args)
			{
				String hi = "hello";
				//System.out.println(hi.substring(hi.length()-1,hi.length()));
				String hi2="";
				System.out.println(hi.length());
				int track= hi.length();
				for (int i =0 ; i < track; i++)8
						{

							hi2+=hi.substring(hi.length()-1,hi.length());
							hi=hi.substring(0,hi.length()-1);
							
						}
				System.out.println(hi2);
			}
	}