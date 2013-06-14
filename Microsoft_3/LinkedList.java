public class LinkedList
{
	private Node head;
	private int size;

	private static class Node
	{
		Object data;
		Node next;
	        Node(Object data)
	 	{

	 	this.data=data;
	 	this.next=null;
	 	}


	}
	public boolean Addfront(Object data)
	{
		Node newNode=new Node (data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
		size++;
		return true;
	}
	public boolean Add(Object data)
		{

		 Node current=head;
		 if(current==null)
		 {
		   return Addfront(data);

		 }
         Node newNode=new Node(data);
		 while(current.next!=null)
		 {
		    current=current.next;
		 }
		 current.next=newNode;
		 size++;
  			return true;

		}
	public Node Reverse(Node start)
	 {
	 Node current=start;
	 Node next_node=null;
	 Node prev=null;
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
    public void SwapPair(Node start)
         {
	     
	     Node tmp=null;
	     Node next=null;
             Node cur = head;
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
       public 
        
	public String toString()
	{
		String result="";
		Node current=head;

		while(current!=null)
		{
			result+=" "+current.data.toString();
			current=current.next;
		}
	return result;
	}
	 public static void main(String[] args)
	 {
	 	System.out.println("here");
	 	int [] a= {1,2,3,4};
	 	LinkedList why =new LinkedList();
	 	for(int z:a)
	 	{
	 		why.Add(z);

	 	}
	 	//why.head=why.Reverse(why.head);
	 	//why.Reverse(why.head);
	 	System.out.println(why);
                why.SwapPair(why.head);
                System.out.println(why);
	 }
    /*tempnode=currentnode;
currentnoce=currentnode->next;
while(currentnode->next!=null)
{
     tempnode->next=currentnode->next;
     currentnode->next=tempnode;
    currentnode=tempnode->next->next;
    tempnode=tempnode->next;

}
    */   

}