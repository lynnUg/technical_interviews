public class Test12
	{
		public static void main(String [] args)
		{
			//System.out.println(Reverse("this a test"));
			String sentence=Reverse("this a test");
			String word="";
			String new_sent="";
			//System.out.println(sentence);
			for(int i=0;i<sentence.length();i++)
			{

				if(sentence.charAt(i)==' ')
				{
					System.out.println(word);
					new_sent+=Reverse(word)+" ";
					word="";

				}
				else
				{
					//System.out.println(word);
					word=word+sentence.charAt(i);
				}
			}
			new_sent+=Reverse(word);
			System.out.println(new_sent);
		}
		public static String Reverse (String sentence)
		{
			String new_word="";
				for (int i=sentence.length()-1;i>=0; i--)
						{
							new_word=new_word+sentence.charAt(i);
						}
				return new_word;
		}
	}