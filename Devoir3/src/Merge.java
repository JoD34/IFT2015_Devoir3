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

class Merge {
	/**
	 * Fusionner 'k' liste(s) chaînée(s) par l'entremise d'un monceau minimum.
	 *
	 * @param lists list contenant des noeuds à classer.
	 * @return (Node) premier noeud de la list nouvellement fusionnée.
	 */
	public static Node mergeKLists(Node[] lists) {
		// Initialisation des variables
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a).data));
		Node head = null, last = null;

		// Ajouter les premiers éléments des listes chaînées au monceau
		for (Node i : lists) if(i!=null) pq.offer(i);

		// Initier le premier noeud de la liste fusionnée.
		if (!pq.isEmpty()) {
			head = last = pq.poll();
			if(last.next != null) pq.offer(last.next);
		}

		//Ajouter les noeuds subséquents
		while (!pq.isEmpty()) {
			last.next = pq.poll();
			if (last.next.next!=null) pq.offer(last.next.next);
			last = last.next;
		}
		return head;
	}
}