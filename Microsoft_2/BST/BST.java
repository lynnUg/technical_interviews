public class BST
	{
	  Node root;
	  public BST()
	  {
        //root=new Node(null,null,null);
        root=null;
	  }
	  public void insert(int key)
	  {
	  	insert(new Node(key,null,null));

	  }
	  public void insert(Node z)
	  {
	  	Node y=null;
	  	Node x=root;
	  	while(x!=null)
	  	{
	  		y=x;
	  		if(z.getKey()<x.getKey())
	  		{
	  			x=x.getLeftChild();
	  		}
	  		else
	  		{
	  			x=x.getRightChild();
	  		}
	  	}
	  	z.setParent(y);
	  	if(y==null)
	  	{
	  		root=z;
	  	}
	  	else if(z.getKey()<y.getKey())
	  	{
	  		y.setLeftChild(z);

	  	}
	  	else 
	  	{
	  		y.setRightChild(z);
	  	}
	  }

	  public void inorderTraversal(Node node)

	  {
	  	if(node!=null)
	  	{
	  		//System.out.println("here_1");
	  		inorderTraversal(node.getLeftChild());
	  		//System.out.println("here_2");
	  		System.out.println(node.getKey()+" ");
	  		inorderTraversal(node.getRightChild());
	  		//System.out.println("here_3");
	  	}
	  }


	}