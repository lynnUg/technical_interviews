import java.util.*;
import java.lang.*;
public class Solution_3
       	     {
	     private Map<Character, String>map;
	     public List<String> Comb(String digits)
	     	    {
		      setUp();
		      List<String> solutions =new ArrayList<String>();
		      recurse(digits,0,new String(),solutions);
		      return solutions;
	    	    }
	    public void recurse(String digits, int start,String sol, List<String> solutions)
	    	   {
			if(sol.length()>digits.length())
				return;
			else if(sol.length()==digits.length())
			solutions.add(sol);
			else
			{
					String letters=map.get(digits.charAt(start));
					for(int j=0;j<letters.length();j++)
					  recurse(digits,start+1,sol+letters.charAt(j),solutions);
			}
		   }
		public void setUp()
		       {
			       map=new HashMap<Character, String>();
				map.put('1',"");
				map.put('2' ,"abc");
				map.put('3',"def");
				map.put('4' ,"ghi");
				map.put('5',"jkl");
				map.put('6',"mno");
				map.put('7',"pqrs");
				map.put('8',"tuv");
				map.put('9',"wxyz");
				map.put('0'," ");
		       }
		 public static void main(String [] args)
		 {
		     Solution_3 the_soln=new Solution_3();
		     System.out.println( Arrays.toString(the_soln.Comb("23").toArray()));
		 }

	     }