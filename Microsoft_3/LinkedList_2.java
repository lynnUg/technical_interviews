public class LinkedList_2
{
	Link_Node head;
    int size;
    public LinkedList_2()
    {};
	
	public boolean Addfront(int data)
	{
		Link_Node newLink_Node=new Link_Node (data);
		if(head==null)
		{
			head=newLink_Node;
		}
		else
		{
			newLink_Node.next=head;
			head=newLink_Node;
		}
		size++;
		return true;
	}
	public boolean Add(int data)
		{

		 Link_Node current=head;
		 if(current==null)
		 {
		   return Addfront(data);

		 }
         Link_Node newLink_Node=new Link_Node(data);
		 while(current.next!=null)
		 {
		    current=current.next;
		 }
		 current.next=newLink_Node;
		 size++;
  			return true;

		}
	public Link_Node Reverse(Link_Node start)
	 {
	 Link_Node current=start;
	 Link_Node next_node=null;
	 Link_Node prev=null;
	  while(current!=null)
	  {
	    next_node=current.next;
	    current.next=prev;
	    if(next_node==null) break;
	    prev=current;
	    current=next_node;
	  }
	  start=current;
	  return start;
	 }
    public void SwapPair(Link_Node start)
         {
	     
	     Link_Node tmp=null;
	     Link_Node next=null;
             Link_Node cur = head;
             head = cur.next;
            while(cur!=null && cur.next!=null)
            {
	      System.out.println("current "+cur.data);
              next = cur.next;
	      // System.out.println("next "+next.data +" next next "+next.next.data);
              cur.next = next.next;
	      tmp = cur.next;
              next.next = cur;
              if(tmp!=null && tmp.next!=null)
		  {
                System.out.println(cur.data);
		System.out.println("before "+cur.next.data);
		  cur.next = cur.next.next;
	         System.out.println(cur.next.data);
		  }
               cur = tmp;       
	      
             }
         
	     
	     
         }
        
	public String toString()
	{
		String result="";
		Link_Node current=head;

		while(current!=null)
		{
			result+=" "+current.data;
			current=current.next;
		}
	return result;
	}
	 

}