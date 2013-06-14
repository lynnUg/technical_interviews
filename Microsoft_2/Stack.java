import java.util.*;
import java.io.*;
public class Stack 
	{
	  Queue <Integer> inbox = new LinkedList<Integer>();
	  Queue <Integer> outbox =new LinkedList<Integer>();
	  public void push(Integer item)
	  	{
	  	   System.out.println(item);
	  	   inbox.offer(item);
	  	}
	  public Integer pop()
	    {
	    	if(outbox.isEmpty())
	    		{
	    			while(!inbox.isEmpty())
	    				{
	    					outbox.offer(inbox.poll());
	    				}
	    		}
	    	return outbox.poll();
	    }
	}