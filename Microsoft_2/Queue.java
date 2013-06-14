import java.util.*;
import java.io.*;
public class Queue
	{
	  Stack <Integer> inbox = new Stack <Integer> ();
	  Stack <Integer> outbox = new Stack <Integer> ();

	  public void queue(Integer item)
	  	{
	  	 //System.out.println(item);
	  	inbox.push(item);
	  	}
	  public Integer dequeue()
	  	{
	  	  if(outbox.isEmpty())
	  	  	{
	  	  	   while(!inbox.isEmpty())
	  	  	   	{
                  outbox.push(inbox.pop());
	  	  	   	}
	  	  	}
	  	  	return outbox.pop();
	  	}
	}