public class DoublyLinkedNode implements Comparable <DoublyLinkedNode>
	{
		Object data;
		DoublyLinkedNode prev;
		DoublyLinkedNode next;
		public DoublyLinkedNode()
		{
		    prev=null; 
                    next=null;

		}
		public DoublyLinkedNode(Object data, DoublyLinkedNode prev , DoublyLinkedNode next)
		{
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
		public DoublyLinkedNode(Object data)
		{
			this(data,null,null);
		}
                public int compareTo(DoublyLinkedNode node)
		{
		    return this.data.toString().compareTo(node.data.toString());
                }

	}
