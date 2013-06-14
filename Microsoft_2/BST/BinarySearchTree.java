public class BinarySearchTree {
 
    /** Root node of the binary search tree. */
    private Node root;
 
    /** Size of the binary search tree */
    private int size = 0;
 
    /** Internal static class for storing the nodes. */
    private static class Node {
        Node left, right;
        int data;
 
        Node( int data ) {
            this.data = data;
        }
 
        @Override
        public String toString( ) {
            return "" + data;
        }
    }
 
    /**
     * Inserts a new node that has the specified data. The insert starts from
     * the root of the tree and goes all the way down until it finds a spot to
     * place the new node.
     */
    public void insert( int data ) {
        root = insert( root, data );
    }
 
    /**
     * Inserts a new node that has the specified data. The insert starts from
     * the specified node of the tree and goes all the way down until it finds 
     * a spot to place the new node.
     */
    public Node insert( Node node, int data ) {
        if( node == null ) {
            // Found a spot to insert new node.
            node = new Node( data );
            size++;
        } else if( data < node.data ) {
            // Insert in left subtree
            node.left = insert( node.left, data );
        } else {
            // Insert right subtree.
            node.right = insert( node.right, data );
        }
        // Done!
        return node;
    }
 
    /** 
     * Returns the median value from the tree. If the tree is odd-sized then 
     * the average of the two middle values is returned.
     */
    public double median( ) {
 
        int count = 0;
        int median = 0;
        boolean even = size % 2 == 0 ? true : false;
 
        Node node = root;
        java.util.Stack<Node> stack = new java.util.Stack<Node>( );
        while( ! stack.isEmpty( ) || node != null ) {
            if( node != null ) {
                stack.push( node );
                node = node.left;
            } else {
                node = stack.pop( );
 
                if( even && count == ( size / 2 ) - 1 ) {
                    median = node.data;
                } else if( count == size / 2 ) {
                    median += node.data;
                    break;
                }
 
                count++;                
                node = node.right;
            }
        }
 
        return even ? median / 2.0 : median; 
    }
 
    /** Test Method */
    public static void main( String[ ] args ) {
 
        BinarySearchTree bst = new BinarySearchTree( );
        for( int i = 1; i <= 100; i++ ) {
            bst.insert( i );
 
            if( i == 11 ) { System.out.println( bst.median( ) ); }       // median = 6.0 
            else if( i == 50 ) { System.out.println( bst.median( ) ); }  // median = 25.5
            else if( i == 100 ) { System.out.println( bst.median( ) ); } // median = 50.5
        }
    }
}