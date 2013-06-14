import java.util.*;
import java.lang.*;
public class BST
{
    private Node root ;
    private int size;
	private static class Node
		{
			Node left ,right;
			int data;
			Node(int data)
			{
			   this.data=data;
			   this.left=null;
			   this.right=null;
			}


		}
	public void insert(int data)
		{
		 root=insert(root,data);
		}
	public Node insert(Node node,int data)
		{
		    if(node== null)
			{
			    node=new Node(data);
			    size++;
			}
		    else if(data> node.data)
			{
			    node.right=insert(node.right,data);
			}
		    else
			{
			    node.left=insert(node.left, data);
			}
		    return node;

		}
    public void inorderTraversal(Node node)
            {
		if(node!=null)
		    {
			inorderTraversal(node.left);
			System.out.println(node.data);
			inorderTraversal(node.right);
		    }
            }
    public Node toLinkList(Node start)
            {
		if(start==null)
		    return null;
		Node leftTree =toLinkList(start.left);
		Node rightTree=toLinkList(start.right);
      
		if(leftTree!=null)
		    {
			while(leftTree.right!=null)
			    {
				leftTree=leftTree.right;
			    }
			leftTree.right=start;
		    }
		    	start.left=leftTree;
		if(rightTree!=null)
		    {
			while(rightTree.left!=null)
			    {
				rightTree=rightTree.left;
			    }
			rightTree.left=start;
		    }
			start.right=rightTree;
		return start;
	    }
    public void TreePrint()
            {
		Queue<Node> nodes= new LinkedList<Node>();
		//Node current=root;
		System.out.println(root.data);
		nodes.offer(root);
		while(!nodes.isEmpty())
		    {
			Node current=nodes.poll();
			if(current.left!=null)
			    {
				nodes.offer(current.left);
				System.out.print("left "+current.left.data+" " );
			    }
			if(current.right!=null)
			    {
				nodes.offer(current.right);
                               	System.out.print("right "+current.right.data+" " );
			    }
			System.out.println();

			
		    }
		
		
	    }
    public boolean isBST(Node start)
           {
	       if(start==null)
		   return true;
	       if(start.left!=null && maxValue(start.left)>start.data)
		   return false;
	       if(start.right!=null&& minValue(start.right)<start.data)
		   return false;
	       if(!isBST(start.left) || !isBST(start.right))
		   return false;
	       return true;
	   }
    public int maxValue(Node other)
            {
		if(other!=null)
		    while(other.right!=null)
			other=other.right;
		return other.data;
	    }
   public int minValue(Node other)
            {
		if(other!=null)
		    while(other.left!=null)
			other=other.left;
		return other.data;
	    }
    public int isCorrectBST(Node start,Node prev,List<Node> nodes)
    {

	if(start!=null)
	    {
		
		int x=isCorrectBST(start.left,prev,nodes);
		//System.out.println("root" +start.data);
		if(prev!=null && start.data<prev.data)
		    {
			
			nodes.add(prev);
			nodes.add(start);
			//System.out.println("prev "+prev.data +"error "+start.data);
			x++;
		    }
		prev=start;
	      	int y=isCorrectBST(start.right,prev,nodes);
		return x+y;
	    }
	return 0;
    }
    public boolean isBalancedtree(Node start)
    {
	if(start!=null)
	    {
		boolean x=isBalancedtree(start.left);
		x=height(start.left)-height(start.right)>1?false:true;
		boolean y=isBalancedtree(start.right);
		return x&&y;
	    }
	return true;
    }
    public void Swapdata(Node first,Node second)
    {
	int temp=first.data;
	first.data=second.data;
	second.data=temp;
    }
    public void isCorrect(Node start)
        {
	    Node prev=null;
	    boolean answer=true;
	    List <Node> nodes=new ArrayList<Node>();
	    int z=isCorrectBST(start,prev,nodes);
	    System.out.println(z);
	    //for(Node Z:nodes)
		//	System.out.println(Z.data);
	    if(nodes.size()==2)
		{
		    Swapdata(nodes.get(0),nodes.get(1));   
		}
	    else if(nodes.size()==4)
		{
		     Swapdata(nodes.get(0),nodes.get(3));
		}
	}
    public int height(Node start)
      {
	  if(start==null)
	      return 0;
	  else
	      return 1+Math.max(height(start.right),height(start.left));
      }
    public static void main (String [] args)
            {
	    

		
			int [] the_array={25, 5, 3 ,8 ,10 ,15, 20, 7,12};
		BST the_tree=new BST();
		for(int item: the_array)
		    {
			 	the_tree.insert(item);

	            }
		//the_tree.isCorrect(the_tree.root);
		System.out.println(the_tree.isBalancedtree(the_tree.root));
		// the_tree.inorderTraversal(the_tree.root);
		//System.out.println();
		 //the_tree.TreePrint();
		//System.out.println(the_tree.isBST(the_tree.root));
		Node root=the_tree.toLinkList(the_tree.root);
		 System.out.println("here "+root.data);
		     while(root.left!=null)
		 {
			System.out.println(root.data);
		    root=root.left;
			
		 }
		 System.out.println("here");
		    while(root.right!=null)
		 {
			System.out.println(root.data);
		    root=root.right;
			
		 }
			//System.out.println();
			// System.out.println("here "+root.data);
			
		/*BST the_tree=new BST();
		the_tree.root=new Node(6);
		the_tree.root.left = new Node(10);
		the_tree.root.right = new Node(2);
		the_tree.root.left.left  = new Node(1);
		the_tree.root.left.right = new Node(3);
		the_tree.root.right.right = new Node(12);
		the_tree.root.right.left = new Node(7);
		the_tree.inorderTraversal(the_tree.root);
		the_tree.isCorrect(the_tree.root);
		System.out.println();
		//the_tree.TreePrint();
		//the_tree.inorderTraversal(the_tree.root);
		System.out.println();
		//	the_tree.TreePrint(); 
		System.out.println(the_tree.height(the_tree.root));
		System.out.println(the_tree.isBalancedtree(the_tree.root));*/
	    }



}