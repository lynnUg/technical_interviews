import java.util.*;
public class the_run
	{
		public static void main(String [] args)
		{
			int [] the_array={3, 25, 5 ,8 ,10 ,15, 20, 7,12};
			//int [] the_array={3, 5 ,8 ,7, 10 ,15, 20, 25};

			BST the_tree= new BST();
			for(int a : the_array)
			{
				the_tree.insert(a);
				
			}
			the_tree.inorderTraversal(the_tree.root);
			/*Queue<Node> BFS =new LinkedList<Node> ();

			BFS.offer(the_tree.root);
			System.out.println(the_tree.root.getKey());

			while(!BFS.isEmpty())
			{
			    Node current=BFS.poll();
			    //System.out.println("parent "+current.getKey());
				if(current.getLeftChild()!=null)
				{
                    System.out.print("left "+current.getLeftChild().getKey()+" ");
					BFS.offer(current.getLeftChild());
				}
				if(current.getRightChild()!=null)
				{
					System.out.print("right "+current.getRightChild().getKey());
					BFS.offer(current.getRightChild());
				}
			   System.out.println();
			}*/

		}
	}