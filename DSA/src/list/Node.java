package list;

/**
 * Store a value and a ref to next and previous node in a List.
 * 
 * @author Matthew Cipriotti
 */
public class Node<E> {
	
	E value;
	Node<E> next;
	Node<E> prev;
	
	/**
	 * Constructor for Node objects.
	 * 
	 * @param v The value stored in the node.
	 * @param n the ref to the next node in the list.
	 * @param p The ref to the pevious node in the list.
	 */
	Node(E v, Node<E> n, Node<E> p) {
		value = v;
		next = n;
		prev = p;
	}
}
