public class Stack 
	{
	  Queue <Integer> inbox = new Linkedlist<Integer>();
	  Queue <Integer> outbox =new Linkedlist<Integer>();
	  public void push(Integer item)
	  	{
	  	   inbox.offer(item);
	  	}
	  public Integer pop()
	    {
	    	if(outbox.isEmpty())
	    		{
	    			while(!inbox.isEmpty())
	    				{
	    					outbox.(inbox.poll());
	    				}
	    		}
	    	return outbox.poll();
	    }
	}