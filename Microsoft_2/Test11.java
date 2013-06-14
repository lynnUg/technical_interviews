//Shift all elements of a circular array by k bytes, using no extra memory.
public class Test11
	{
		public static void main(String [] args)
			{
				int [] array_int={1,2,3,4,5,6};
				shift(2,array_int);
				for(int a: array_int)
				{
					System.out.println(a);
				}
			}
		public static void shift(int k, int [] a)
			{
				int p=1; 
				int temp=0;
				 /* while(p<=k)
				   {
						for(int i =1 ;i<a.length;i++) 
						{
							temp=a[0];
							a[0]=a[i];
							a[i]=temp;
						}
						p++;

					}*/
				while(p<=k)
				   {
						for(int i =1 ;i<a.length;i++) 
						{
							//temp=a[0];
							a[0]=a[i]+a[0];
							a[i]=a[0]-a[i];
							a[0]=a[0]-a[i];
						}
						p++;

					}

			}
	}