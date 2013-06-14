public Node reverse(Node start)
{
	Node start_2= clone(start);
	Node current=start_2;

	Node next =null;
	Node prev=null;

	while(current!=null)
	{
		next=current.getNext();
		current.setNext(prev);
		if(current.getNext()!=null)
		{
			break;
		}
		prev=current;
		current=next;
	}


}
public boolean Find_Cycle(Node start)
{
	Node start_2=clone(start);
	//Node current=start_2;

	Node slow=start_2;
	Node fast=start_2;

	while(fast.getNext()!=null&&slow.getNext()!=null)
	{
		slow=slow.getNext();
		fast=fast.getNext().getNext();
		if(fast==slow)
		{
			return true;
		}
	}
	return false;
}
public int[] Compact(int[] the_array)
{
	HashSet<Integer> the_set=new HashSet<Integer>();
	for(int item: the_array )
	{
 		if(!the_set.contains(item))
 		{
 			the_set.add(item);


 		}
	}
	int [] new_array=new int [the_set.size()];
    int i=-1; 
	for(int a :the_set)
	{
		new_array[i++]=a;

	}
	return new_array;
}