public class MaxSubArray
	{
		public static void main(String []args)
			{
					String string = "6,-2,-3,10,3,-2,-1,-2";
                    String[] numbers = string.split(",");
                   int max_so_far = 0;
                   int max_ending_here = 0;
                  for (String num : numbers) 
                  {
                   int x = Integer.parseInt(num);
                    System.out.println(x);
                   max_ending_here = Math.max(0, max_ending_here + x);
                    System.out.println(max_ending_here);
                   max_so_far = Math.max(max_so_far, max_ending_here);
                    System.out.println(max_so_far);
                    System.out.println("here");
                  }
                  System.out.println(max_so_far);
			}
	}