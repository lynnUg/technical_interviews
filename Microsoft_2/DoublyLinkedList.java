public class DoublyLinkedList
{
	DoublyLinkedNode head;
	DoublyLinkedNode tail;
	int size;
	public DoublyLinkedList()
	{

	}
        
	public void insertAfter(DoublyLinkedNode node,DoublyLinkedNode newNode)
	{
		newNode.prev=node;
		newNode.next=node.next;
		if (node.next==null)
		{
			tail=newNode;
		}
		else
		{
			node.next.prev=newNode;
		}
		node.next=newNode;
	}
	public void insertBefore(DoublyLinkedNode node,DoublyLinkedNode newNode)
	{
		newNode.prev=node.prev;
		newNode.next=node;
		if(node.prev==null)
		{
			head=newNode;
		}
		else
		{
			node.prev.next=newNode;

		}
		node.prev=newNode;
	}
	public void insertFront(DoublyLinkedNode newNode)
	{
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			insertBefore(head,newNode);
		}
	}
	public void insertEnd(DoublyLinkedNode newNode)
	{
		if(tail==null)
		{
			insertFront(newNode);

		}
		else
		{
			insertAfter(tail,newNode);
		}
	}
	public void remove(DoublyLinkedNode node)
	{
		if(node.prev==null)
		{
			head=node.next;

		}
		else
		{
			node.prev.next=node.next;
		}

		if(node.next==null)
		{
			tail=node.prev;
		}
		else
		{
			node.next.prev=node.prev;
		}
	}
	public void removeFront()
	{
		if(head!=null)
		{
			remove(head);
		}
	}
	public void removeBack()
	{
		if(tail!=null)
		{
			remove(tail);
		}
	}
	public DoublyLinkedNode get(Object data)
	{
	    /*  DoublyLinkedNode current=head;
          while(current.next!=null)
          {
          	if(current.data.compare(data))
          	{
          		return current;
          	}
		}*/
       return null;
	}
	public DoublyLinkedNode sort012(DoublyLinkedNode start,DoublyLinkedNode end)
	{
		DoublyLinkedNode lo=start;
		DoublyLinkedNode hi=end;
	        DoublyLinkedNode pivot=start;
		
        String low="0";
        String high="2";

		while(pivot.prev!=hi.next || pivot!=hi)
		{
		    if(pivot.data.toString()==low)
			{
			  String temp=lo.data.toString();
			  lo.data=pivot.data;
			  pivot.data=temp;
			  lo=lo.next;
			  pivot=pivot.next;

			}
		    else if(pivot.data.toString()==high)
			{
			    String temp= hi.data.toString();
				hi.data=pivot.data;
				pivot.data=temp;
				hi=hi.prev;

			}
			else
			{
				pivot=pivot.next;

			}

		}
	 return start;
	}
  public void Swap(DoublyLinkedNode toStartFrom, DoublyLinkedNode b)
 {
     Boolean NextToEachOther = (toStartFrom.next == b);
        if(toStartFrom.prev != null)
	    {
		toStartFrom.prev.next = b;
	     }
	else
	    {
		head=b;
            }
       	if(toStartFrom.next != b) // Equivalent to NextToEachOther
	    {
		toStartFrom.next.prev = b;
	    }
	if(b.next != null)
	    {
		b.next.prev = toStartFrom;
	    }
	else
	    {
                tail= toStartFrom;
            }
	if(b.prev != toStartFrom)  // Equivalent to NextToEachOther
	    {
		b.prev.next = toStartFrom;
	      }
       
        DoublyLinkedNode temp=toStartFrom.next;
        toStartFrom.next = b.next;
        DoublyLinkedNode temp2=b.prev;
        b.prev = toStartFrom.prev;
        if (NextToEachOther) {
	    
            toStartFrom.prev = b;
            b.next = toStartFrom;
        } else {
	   
            toStartFrom.prev = temp2;
            b.next = temp;
        }
    }
    public static void main(String [] args)
       {  
	   DoublyLinkedList list = new DoublyLinkedList( );
    DoublyLinkedNode nodeA = new DoublyLinkedNode( "A" );
    DoublyLinkedNode nodeB = new DoublyLinkedNode( "B" );
    DoublyLinkedNode nodeC = new DoublyLinkedNode( "C" );
    DoublyLinkedNode nodeD = new DoublyLinkedNode( "D" );
    DoublyLinkedNode nodeE = new DoublyLinkedNode( "E" );
 
 
 
    list.insertFront( nodeA );
    list.insertEnd( nodeB );
    list.insertEnd( nodeC );
    list.insertEnd( nodeD );
    list.insertEnd( nodeE );
    //System.out.println(nodeA.next.data);
for( DoublyLinkedNode cursor = list.head; cursor != null; cursor = cursor.next ) 
{
	System.out.println( cursor.data ); // Prints out: A B C
    }
System.out.println();
     list.Swap(nodeA,nodeC);
    // Print the doubly-linked list by traversing forward.
    //

    for( DoublyLinkedNode cursor = list.head; cursor != null; cursor = cursor.next ) {
	System.out.println( cursor.data ); // Prints out: A B C
    }
        }
}