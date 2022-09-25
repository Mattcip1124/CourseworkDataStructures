package list;

/**
 * A List Iterator for LinkedLists.
 * 
 * @author Matthew Cipriotti
 *
 */
class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {
	
	//cursor is a reference to the last node obtained by a call to next() or previous().
	boolean forward = true;
	
	/**
	 * Constructor for RefListIterator objects.
	 * @param list The LinkedList to be iterated.
	 */
	RefListIterator(LinkedList<E> list) {
		super(list);
	}
	
	/**
	 * Constructor for RefListIterator objects.
	 * @start A starting position.
	 * @param list The LinkedList to be iterated.
	 */
	RefListIterator(int start, LinkedList<E> list) {
		super(list);
		for(int i = 0; i < start; i++)
			cursor = cursor.next;
	}
	
	/**
	 * Method that returns true if there are more values forward. Override from superclass.
	 * @return True if there are more values forward.
	 */
	public boolean hasNext() {
		if(list.isEmpty())
			return false;
		if(forward)
			return cursor.next != list.tail;
		return true;
	}
	
	/**
	 * Method that returns the next value. Override from superclass.
	 * @return The next value
	 * Pre: hasNext() is true
	 */
	public E next() {
		if(forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}
	
	/**
	 * Method that returns if there are move values backwards.
	 * @return True if there are more values backwards.
	 */
	public boolean hasPrevious() {
		if(!forward)
			return cursor.prev != list.head;
		return cursor != list.head;		//initial call to hasPrevious is false.
	}
	
	/**
	 * Method that returns the previous value.
	 * @return The previous value.
	 */
	public E previous() {
		if(!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}
	
	/**
	 * Remove the last value obtained by a call to next() or previous().
	 * Override from superclass.
	 * Pre: next() or previous() was called at least once since the last call to remove()
	 */
	public void remove() {
		super.remove();
		if(forward) {
			cursor = cursor.prev;
		}
		else {
			cursor = cursor.next;
		}
	}
	
	/**
	 * Method that inserts the given value just prior to the implicit cursor position
	 */
	public void add(E value) {
		if(forward) {
			Node<E> temp = new Node<E>(value, cursor.next, cursor);
			cursor.next.prev = temp;
			cursor.next = temp;
			next();
			
		}
		else {
				Node<E> temp = new Node<E>(value, cursor, cursor.prev);
				cursor.prev.next = temp;
				cursor.prev = temp;
				previous();
				forward = true;
		}
		list.size++;
	}
	
	/**
	 * Method that swaps the two values adjacent to the implicit cursor.
	 * Pre: hasNext() and hasPrevious() are both true.
	 */
	public void swap() {
		E temp = cursor.value;;
		cursor.value = cursor.next.value;
		cursor.next.value = temp;
	}
}
