public class Exercise_17
	{
		public static void main(String [] args)
		{
			int [] a = {-1,1,2,3,4,5,-2,20,30};
			Max_subarray(a);


		}
		public static int Max_subarray(int [] the_array)
		{
			int max_at_this_point=0;
			int max_so_far=0;
			int iterator=1;
			int size=0;
			int index=0;
			int size_max=0;
			for(int item: the_array)
			{
				max_at_this_point+=item;
				//max_at_this_point=Math.max(0, max_at_this_point);
				if(max_at_this_point>0)
				{
					size=Math.max(0,iterator-index);
				}
				else
				{
					max_at_this_point=0;
                    index=iterator;
				}
				max_so_far=Math.max(max_so_far,max_at_this_point);
				size_max=max_so_far>max_at_this_point ? size_max : size;
				iterator++;


			}
			System.out.println(max_so_far);
			System.out.println(size_max);
			return max_so_far;
		}
		public static void Max_subarray2(int [] the_array)
		{

			int sum_at_this_point=0;
			int max_so_far=0;
			int size=0;
			int iterator=0;
			int index=0;
			for(int item :the_array)
			{
				sum_at_this_point+=item;
				if(sum_at_this_point==0)
				{
				  System.out.println("here");
                  size=Math.max(0,iterator-index);

				}
				iterator++;

			}
		 System.out.println(size);
		}
	}