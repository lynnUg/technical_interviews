public class KnuthMorrisPratt {
	public int[] prekmp(String pattern) 
	{
		int[] next = new int[pattern.length()];
		int i=0, j=-1;
		next[0]=-1;
		//System.out.println(pattern.length());
		while (i <pattern.length()-1)	
		{
			while (j>=0 && pattern.charAt(i)!=pattern.charAt(j))
				{
					
					j = next[j];
					
				}
				
			i++; 
			j++;
			next[i] = j;
			
		}

		return next;
	}
	
	public int kmp(String text, String pattern) {
		int[] next = prekmp(pattern);
		int i=0, j=0;
		//System.out.println(text.length());
		while (i <text.length()-1)	
		{		
			 while (j>=0 && text.charAt(i)!=pattern.charAt(j))
			 		{
			 			
			 			j = next[j]; 
			 			System.out.println("here_2");
			 			System.out.println(j);
			 		}
			System.out.println(j);
			i++; j++;
			System.out.println(j);
			System.out.println("here");
			if (j==pattern.length()) 
				{
					//System.out.println(i);
					return i-pattern.length();
				}
				
		}
		/*System.out.println("start");
		for(int x : next)
			{
				System.out.println(x);
			}*/
		return -1;
	}

}

