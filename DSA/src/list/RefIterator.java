package list;

/**
 * An Iterator for LinkedLists.
 * 
 * @author Matthew Cipriotti
 *
 */
class RefIterator<E> implements Iterator<E> {
	
	LinkedList<E> list;
	Node<E> cursor;			//Ref to last node obtained by a call to next()
	
	/**
	 * Constructor for RefIterator objects.
	 * @param list The list to be iterated
	 */
	RefIterator(LinkedList<E> list) {
		this.list = list;
		cursor = list.head;
	}
	
	/**
	 * Method that returns true if there are more values.
	 * @return True if there are more values.
	 */
	public boolean hasNext() {
		return cursor.next != list.tail;
	}
	
	/**
	 * Method that returns the next value.
	 * @return The next value
	 * Pre: hasNext() is true
	 */
	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}
	
	/**
	 * Remove the last value obtained by a call to next()
	 * Pre: next() was called at least once since the last call to remove()
	 */
	public void remove() {
		cursor.next.prev = cursor.prev;
		cursor.prev.next = cursor.next;
		list.size --;
	}
}
