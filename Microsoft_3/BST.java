import java.util.*;
import java.lang.*;
public class BST
{
	Node root;
	int size;
	private static class Node
	{
	  Node left;
	  Node right;
	  int data;
	  Node(int data)
	  {
	    this.data=data;
	    this.left=null;
	    this.right=null;
	  }
	}
       public BST()
       {}
	public void insert(int data)
	{
	   root=insert(root,data);
	}
	public Node insert(Node node,int data)
	{
	   if(node==null)
	   {
	      node=new Node(data);
	      size++;
	   }
	   else if(data>node.data)
	   {
	     node.right=insert(node.right,data);
	   }
	   else
	   {
	      node.left=insert(node.left,data);
	   }
	   return node;
	}
	public static void inorderTraversal(Node node)
	{
	  if(node!=null)
	   {
	     inorderTraversal(node.left);
	     System.out.println(node.data);
	     inorderTraversal(node.right);
	   }
	}
	public Node toLink(Node root)
	{
            if(root==null)
                 return null;
            Node leftTree=toLink(root.left);
            Node rightTree=toLink(root.right);
       
            if(leftTree!=null)
              {
                while(leftTree.right!=null)
                 {
                      leftTree=leftTree.right;
                 }
                leftTree.right=root;
              }
            root.left=leftTree;

           if(rightTree!=null)
           {
               while(rightTree.left!=null)
                {
                    rightTree=rightTree.left;
                }
              rightTree.left=root;
           }

            root.right=rightTree;
            return root;


	}
	public  void TreePrint(Node root)
	{
	  Queue <Node>Tree=new LinkedList<Node>();
	  Tree.offer(root);
	  while(!Tree.isEmpty())
	   {
	     Node node=Tree.poll();
	     if(node.left!=null)
	     {
	         Tree.offer(node.left);
	         System.out.print(node.left.data+" ");
	     }
	     if(node.right!=null)
	     {
	           Tree.offer(node.right);
	           System.out.print(node.right.data+" ");
	     }
	     System.out.println();
	   }
	}
	public  int isCorrectBST(Node node,Node prev,List<Node> nodes)
	{
		if(root!=null)
		{
			int x= isCorrectBST(node.left, prev,nodes);
			if(prev!=null&&root.data<prev.data)
			{
				nodes.add(prev);
				nodes.add(root);
				x++;
			}
			prev=root;
			int y=isCorrectBST(node.right,prev,nodes);
			return x+y;

		}
		return 0;
	}
	public  boolean isBalanced(Node root)
	{
		 if(root!=null)
		 {
		 	boolean x=isBalanced(root.left);
		 	x=Math.abs(height(root.left)-height(root.right))>1?false:true;
		 	boolean y=isBalanced(root.right);
			return x&&y;
		 }
		 return true;
	}
	public  int height(Node node)
	{
		if(node==null)
			return 0;
		else
		 return 1+Math.max(height(node.right),height(node.left));
	}
    	public static void main(String [] args)
	{
		BST tree=new BST();
		int [] the_array={1,2,3,4,5};
		LinkedList_2 the_link=new LinkedList_2();

		for(int x:the_array)
			the_link.Add(x);
		Link_Node current=the_link.head;
		while(the_link.next!=null)
		{

			System.out.println(the_link.data);

		}
		//Node node =LinktoTree(the_link.head,0,4);

	        //	 tree.insert(x);
               //tree.TreePrint(tree.root);
	       //tree.height(tree.root);  
	      
	       // BST tree2=new BST();
	       // tree2.
	       // System.out.println(node.data);
	       // System.out.println(node.left.left.data);
	       //  System.out.println(node.right.right.data);
		   Node node =CreateTree(the_array,0,4);
	      
	       
	       Queue<Node> the_print=new LinkedList<Node>();
		   the_print.offer(node);
	       while(!the_print.isEmpty())
		   {
		       Node current=the_print.poll();
		       
		       if(current.left!=null)
			   {
			       System.out.print("the left" +current.left.data +" " );
			       the_print.offer(current.left);
			   }
		       if(current.right!=null)
			   {
			       System.out.print("the right"+ current.right.data +" " );
			        the_print.offer(current.right);
			   }
		       System.out.println();
		   }
	}
       public static Node CreateTree(int [] arr, int low ,int high)
        {
	    if(low>high)
         	return null;
	    int mid= low + ((high-low)/2);
	    // System.out.println("start"+low +"arr[mid]);
	    Node node =new Node (arr[mid]);
	    node.left=CreateTree(arr,low,mid-1);
	    node.right=CreateTree(arr,mid+1,high);
	    return node;
	    }
    public static Node LinktoTree(Link_Node head,int low ,int high)
        {
            if(low>high)
		return null;
	    int mid=low+( (high-low)/2);
	    Node leftChild=LinktoTree(head,low,mid-1);
	    Node parent=new Node(head.data);
	    parent.left=leftChild;
	    head=head.next;
	    parent.right=LinktoTree(head,mid+1,high);
	    return parent;
        }
}
