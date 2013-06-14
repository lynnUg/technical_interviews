import java.util.*;
public class Permutate
	
	{
		public static void main(String [] arg)
			{
				String chars="abc";
				//Pattern("",chars);
				//System.out.println("here".substring(1));
				String newString="bc".substring(0,1)+"bc".substring(1+1);
				System.out.println(newString);
				//System.out.println()

			} 
		public static void Pattern(String st, String chars )
			{
				if(chars.length() <=1) System.out.println(st+chars);
				else
				{
					for(int i=0 ;i<chars.length();i++)
						{
							String newString=chars.substring(0,i)+chars.substring(i+1);
							//System.out.println("here");
							//System.out.println(newString);
							System.out.println(st);
							Pattern(st+chars.charAt(i),newString);
						}
				}

			}
	}