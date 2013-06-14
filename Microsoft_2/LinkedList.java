public class LinkedList<T>
	{
		private Node<T> head;
		private int listCount;

		public LinkedList()
			{
				head=new Node<T>(null);
				listCount=0;
			}
		public void addBack(T data)
			{
				Node<T> temp = new Node<T>(data);
				Node<T> current = head;
				if(listCount>0)
				{
					
					while(current.getNext()!=null)
					{
						current=current.getNext();
					}
				    current.setNext(temp);
				   // System.out.println(current.getData());
				
				}
				else
				 {
				 	head=temp;
				 }

				listCount++;
			}
		public void addFront(T data )
		{
			            Node<T> temp =new Node<T>(data);
						temp.setNext(head);
						head=temp;
		}

		public void add(T data, int index)
			{
				
				if(index==0)
					{
						addFront(data);

					}
				else if(index>listCount)
					{
						addBack(data);

					}
				else
					{
						Node<T> temp =new Node<T>(data);
				       Node<T> current =head;

					for(int i=0;i<index-1&&current.getNext()!=null;i++)
						{
						current=current.getNext();
						System.out.println("here2life");
						}
				   
				   
					temp.setNext(current.getNext());
					current.setNext(temp);

				  }
				
			
					
					listCount++;
			}
		public void createLoop()
		 	{
		 		Node<T> current=head;

		 		while(current.getNext()!=null)
		 		{
		 			//System.out.println(current.getData());
		 			current=current.getNext();
		 		}
		 		//System.out.println(current.getData());
		 		current.setNext(head);
		 	}
		public Node<T> get(int index)
			{
				Node<T> current = head;
				for (int i =0; i<index-1;i++)
					{
						if(current.getNext()==null)
						{
							return null;
						}
						current=current.getNext();
						//System.out.println("here");
					}
				return current;
			}
		public boolean remove(int index)
			{
				if(index <0|| index >listCount)
					{
						return false;
					}
				if(index==0)
				{
					head=head.getNext();
					return true;
				}

				Node<T> current =head;
				for (int i= 0; i<index-1;i++)
					{
						if(current.getNext()==null)
						{
							return false;
						}
						current=current.getNext();
					}
					current.setNext((current.getNext()).getNext());
					listCount--;
					return true;

			}
		public void reverse()
		 	{
		 		Node<T> current=head;

		 		if (current == null||current.getNext() == null)  // first question

               {

               }
		 		else
		 		{
		 			Node<T> prev=null;
		 			Node<T> next=null;
		 			
		 			while(current!=null)
						{
							
							next=current.getNext();
							
							current.setNext(prev);
							
							if(next==null)
							{
								break;
							}
							prev=current;
							current=next;
							

							
							
						}
				//System.out.println(current.getNext().getNext().getData());
				     head=current;
				     //System.out.println(head.getData());

		 		}
		 			
				

		 	}

		 public Node<T> Reverse(Node<T> list)
		    {
		    	if (list == null) return null; // first question

                if (list.next == null) return list; // second question

                  // third question - in Lisp this is easy, but we don't have cons
                  // so we grab the second element (which will be the last after we reverse it)

                   Node<T> secondElem = list.getNext();

                 // bug fix - need to unlink list from the rest or you will get a cycle
                  list.next = null;
                  
                  Node<T> reverseRest = Reverse(secondElem);
                 
                  secondElem.setNext(list);

                  return reverseRest;
		    }
		public void Swap(int index1,int index2)
			{
				Node<T> temp=get(index1);
				Node<T> temp2=get(index2);
                remove(index1);
                remove(index2-1);

                add(temp2.getData(),index1);
                add(temp.getData(),index2);

             }
		public boolean loop()
		{
			Node<T> current=head;
			Node<T> faststart1;
			Node<T> faststart2;
			faststart1=faststart2=current.getNext();
			while(current!=null&&faststart1!=null&&faststart2!=null)
			{
				System.out.println(current.getData());
				if(current==faststart1||current==faststart2)
				{
					System.out.println(current.getData());
					return true;
				}
				current=current.getNext();
				faststart1=faststart2.getNext();
				faststart2=faststart1.getNext();

			}
			return false;
			
		}
		public boolean FindLoop(Node start)
		{
			Node slow=start;
			Node fast=start;
			//Node slow=Node fast=start;
			System.out.println("here");
			while(slow.getNext()!=null&&fast.getNext()!=null)
			{
				slow=slow.getNext();
				fast=fast.getNext().getNext();
				System.out.println(slow.getData());
				System.out.println(fast.getData());
				if(slow==fast)
				{
					return true;
				}
			}
			return false;


		}
		public int Find_mid(Node start)
			{
				Node slow=start;
				Node fast=start;
				int i=0; 
				while(slow.getNext()!=null&&fast.getNext()!=null)
					{
						slow=slow.getNext();
						fast=fast.getNext().getNext();
						i++;
					}
				return i;
			}
		public Node Find_head()
			{
				return head;
			}
		/*	public Node sort012(Node start)
		{
			//Node start cloned now Node start_2
			Node current=start2;
			int count_0=0;
			int count_1=0;
			int count_2=0;
			while(current.getNext()!=null)
			{
				if(current.getData==0)
				{
					count_0++;
				}
				else if(current.getData()==1)
				{
					count_1++;
				}
				else if(current.getData()==2)
				{
					count_2++;
				}

			}
			int count =0;
			while(count<count_0)
			{
				current.data=0;
				current=current.next;
				count++;

			}
			count=0;
			while(count<count_1)
			{
				current.data=1;
				current=current.next;
				count++;
			}
			count=0;
			while(count<count_2)
			{
				current.data=2;
				current=current.next;
				count++;
			}
			return start_2;

			}*/
	       public void SwapPair(Node start)
             {
		 Node current=start;
		 Node temp=current;
		 head=current=current.next;
              
	         //System.out.println(current.data);
	         while(current!=null)
		 {
		     //System.out.println(current.data + " temp " + current.next.data);
		     temp.next=current.next;
		     current.next=temp;
		     System.out.println(current.data + " temp " + current.next.data);
		     temp=temp.next;
		     current=temp.next;
		 }

	     //current=current.next;
	     // head=current;
             }
		public String toString()
				{
					String result="";
					Node<T> current =head;
					//System.out.println(current.getData());
					while(current!=null)
							{
								result= result +" "+ current.getData().toString();
								//System.out.println(current.getData().toString());
								//System.out.println(current.getNext().getData());
								current=current.getNext();
								
							}
					return result;
				}

		
	}