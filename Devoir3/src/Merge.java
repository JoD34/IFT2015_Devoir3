import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// A Linked List Node
class Node
{
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

class Merge
{


	public static Node mergeKLists(Node[] lists)
	{
		
		PriorityQueue<Node> pq;
		pq = new PriorityQueue<>(Comparator.comparingInt(a -> ((Node) a).data));

		
		Node head = null, last = null;


		// WRITE YOUR CODE HERE (~10 Lines)
	

		// END OF YOUR CODE HERE


		return head;
	}
}