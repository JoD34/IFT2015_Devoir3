import java.util.Random;

// A Treap Node
class TreapNode
{
	int data;
	int priority;
	TreapNode left, right;

	// constructor
	TreapNode(int data)
	{
		this.data = data;
		this.priority = new Random().nextInt(100);
		this.left = this.right = null;
	}
}

class Treap
{
	
	public static TreapNode rotateLeft(TreapNode root)
	{
		TreapNode R = root.right;
		TreapNode X = root.right.left;

		// rotate
		R.left = root;
		root.right = X;

		// set a new root
		return R;
	}


	public static TreapNode rotateRight(TreapNode root)
	{
		TreapNode L = root.left;
		TreapNode Y = root.left.right;

		// rotate
		L.right = root;
		root.left = Y;

		// set a new root
		return L;
	}

	
	public static TreapNode insertNode(TreapNode root, int data)
	{
		
		if (root == null) {
			// WRITE YOUR CODE HERE (~1 Lines)
			
			// END OF YOUR CODE HERE
		}

		
		if (data < root.data)
		{   
			// WRITE YOUR CODE HERE (~7 Lines)
			

		// END OF YOUR CODE HERE

		return root;
	}

	
	public static boolean searchNode(TreapNode root, int key)
	{
		// WRITE YOUR CODE HERE (~7 Lines)

		// END OF YOUR CODE HERE
	}

	
	public static TreapNode deleteNode(TreapNode root, int key)
	{
		// WRITE YOUR CODE HERE (~18 Lines)

		// END OF YOUR CODE HERE

		

		return root;
	}

	

}