public class MinPriorityQueueUsingBST {

    private Node root;

    private static class Node {
        private int key;
        private Node left, right, p;
        private int size;
        private Node min; // to store the min node

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }
    }

    public MinPriorityQueueUsingBST() {
        root = null;
    }

  
    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    private void updateMinNode(Node z) {

        // WRITE YOUR CODE HERE (~8 Lines)
	

		// END OF YOUR CODE HERE


    }

 
 

  
    private void transplant(Node u, Node v) {

        // WRITE YOUR CODE HERE (~8 Lines)
	

		// END OF YOUR CODE HERE
    

    }


 
    public Node extractMinEfficient(Node z) {

        // WRITE YOUR CODE HERE (~4 Lines)
	

		// END OF YOUR CODE HERE

    }

}
