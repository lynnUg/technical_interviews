public class Link
	{
		public static void main(String [] args)
			{

				int [] numbers= {1,2,4};
				//System.out.println(numbers.length);
				LinkedList list = new LinkedList();
				for(int i : numbers)
					{
						list.addBack(i);

					}
				list.SwapPair(list.Find_head());
                                System.out.println(list);
				//list.remove(1);
				//list.add(3,0);
                // System.out.println(list.loop());
				//list.createLoop();
				//System.out.println(list.createLoop());
				//System.out.println(list.FindLoop(list.Find_head()));

				//System.out.println(list.Find_mid(list.Find_head()));
				//system.out.println(

				//Find_mid()
				//Collections.sort(list);
				//System.out.println(list.get(2).getData());
				//list.Swap(1,4);
				//System.out.println("list");
				//System.out.println(list);
				//System.out.println(list.loop());
				//list.createLoop();
				//System.out.println(list.loop());
				//list.reverse();
				//System.out.println(list);
				//list.head=list.Reverse(list.head);
				//System.out.println(list.Reverse(list.head).getData());
           			//System.out.println(list);
				//System.out.println(list.reverse(list.head).getNext().getData());
				//System.out.println(list.reverse(list.head).getData());
			}
	}