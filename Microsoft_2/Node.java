public class Node<T> implements Comparable <Node<T>>
	{
		Node<T> next;
		T data;
		public Node(T _data)
			{
				next=null;
				data= _data;
			}
		public T getData()
			{
				return data;
			}
		public void setData(T _data)
			{
				data= _data;
			}
		public Node<T> getNext()
			{
				return next;
			}
		public void setNext(Node<T> _next)
		 	{
		 		next=_next;
		 	}
		 public int compareTo(Node<T> element)
		 {
		 	//int i= this.data - element.data;
		 	return this.data.toString().compareTo(element.data.toString());
		 }

	}