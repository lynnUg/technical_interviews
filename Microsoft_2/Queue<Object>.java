public class Queue
	{
	  Stack <Object> inbox = new Stack <Object> ();
	  Stack <Object> outbox = new Stack <Object> ();

	  public void queue(Object item)
	  	{
	  	inbox.push(item);
	  	}
	  public Object dequeue()
	  	{
	  	  if(outbox.isEmpty())
	  	  	{
	  	  	   while(!inbox.isEmpty())
	  	  	   	{
                  outbux.push(inbox.pop());
	  	  	   	}
	  	  	}
	  	  	return outbox.pop();
	  	}
	}