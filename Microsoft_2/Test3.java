public List<Integer> merge (List<Integer> first , List <Integer> second)
{ 
   if(first.size()==0)
   {
     return second;

   }
   else if(second.size()==0)
   {
     return first;
   }
   else if(first.size()==0&&second.size()==0)
   {
    return null;
   }

   int a=0;
   int b=0;
   List <Integer> third =new ArrayList <Integer>
   while (a<first.size()||b<second.size())
     {
       if(first.get(a)<second.get(b))
       {
          third.add(first.get(a))
          a++;
       }
       else if(first.get(a)>second.get(b))
       {
          third.add(second.get(b))
          b++;
       }
       else
       {
         third.add(first.get(a))
         third.add(second.get(b))
          a++;
          b++;
       }

     }
     return third;
	
}
public String reverse (String word)
{
	String new_word="";
	int a =word.length();
	for (int i=0 ; i < a;i++)
		{
          new_word+= word.substring(word.length()-1,word.length());
          word=word.substring(0,word.length());
		}

}