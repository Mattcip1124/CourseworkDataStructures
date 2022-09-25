package list;

/**
 * A list using refs.
 * 
 * @author Matthew Cipriotti
 *
 */
public class LinkedList<E> implements List<E> {
	
	E value;
	int size = 0;
	private Node<E> ref;
	Node<E> head = new Node<E>(null, null, null);
	Node<E> tail = new Node<E>(null, null, head);
	
	/**
	 * Constructor for LinkedList objects.
	 */
	public LinkedList() {
		
		head.next = tail;
	}
	
	/**
	 * Constructor for LinkedList objects.
	 * 
	 * @param value A value to be added to the start of the List.
	 */
	public LinkedList(E value) {
		head.next = tail;
		add(value);
	}
	
	/**
	 * Method that adds a value and new node to the end of the list.
	 * 
	 * @param value The value to be added.
	 */
	public void add(E value) {
		
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}
	
	/**
	 * Helper method that sets and returns the field ref for use.
	 * 
	 * @param ndx The index of the reference.
	 * @return The new node at ref.
	 */
	private Node<E> setRef(int ndx) {
		if(ndx <= size/2) {
			ref = head.next;
			for(int i = 0; i < ndx; i++)
				ref = ref.next;
		}
		if(ndx > size/2) {
			ref = tail.prev;
			for(int i = size-1; i > ndx; i--)
				ref = ref.prev;
		}
		return ref;
	}
	
	/**
	 * Method that adds a new node at a given index.
	 * 
	 * @param ndx The index to add the node.
	 * @param value The value contained within the node.
	 */
	public void add(int ndx, E value) {
		
		setRef(ndx);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		
		ref.prev.next = temp;
		ref.prev = temp;
		size++;
	}
	
	/**
	 * Returns the stored value at a given index.
	 * 
	 * @param ndx The given index.
	 * @return The value found.
	 */
	public E get(int ndx) {
		
		setRef(ndx);
		return ref.value;
	}
	
	/**
	 * Method that sets the value of a node at a given index.
	 * 
	 * @param value The value being set.
	 * @return The new set value.
	 */
	public E set(int ndx, E value) {
		
		setRef(ndx);
		E result = ref.value;
		ref.value = value;
		return result;
	}
	
	/**
	 * Method that removes a node at a given index.
	 * 
	 * @param ndx The given index.
	 * @return The value removed.
	 */
	public E remove(int ndx) {
		
		setRef(ndx);
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return ref.value;
	}
	
	/**
	 * Method that returns the size of the list.
	 * 
	 * @return The size of the list.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Method that checks if the list is empty.
	 * @return If the list is empty or not.
	 */
	public boolean isEmpty() {
		boolean x = false;
		if(size == 0)
			x = true;
		return x;
	}
	
	/**
	 * Method that clears the list
	 */
	public void clear() {
		
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	/**
	 * Method that returns the first occurrence of the given object.
	 * @param obj The Object to check
	 * @return The position.
	 */
	public int indexOf(Object obj) {
		setRef(0);
		for(int i = 0; i < size; i++) {
			if(ref.value.equals(obj))
				return i;
			ref = ref.next;
			}
		return -1;
	}
	
	/**
	 * Method that checks if a value is in the list.
	 * @param obj The value to check.
	 * @return Whether the value is in the list.
	 */
	public boolean contains(Object obj) {
		boolean cont = false;
		int ndxof = indexOf(obj);
		if(ndxof != -1)
			cont = true;
		return cont;
	}
	
	/**
	 * Method that prints a String representation of the list.
	 * @return A String representation of the list.
	 */
	public String toString() {
		if(isEmpty()) 
			return "[]";
		String list = "[" + setRef(0).value;
		ref = ref.next;
		for(int i = 1; i < size; i++) {
			E temp =  ref.value;
			list = list + "," + temp;
			ref = ref.next;
			}
		
		return list + "]";
	}
	
	/**
	 * Method that removes the first occurrence of the given object.
	 * @param obj The object to be removed
	 * @return Whether the object was removed
	 */
	public boolean remove(Object obj) {
		
		int rendx = indexOf(obj);
		if(rendx == -1)
			return false;
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return true;
	}
	
	/**
	 * Method that creates an iterator for this list.
	 * @return an iterator for this list.
	 */
	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}
	
	/**
	 * Method that creates a list iterator for this list.
	 */
	public ListIterator < E> listIterator ( ) {
		return new RefListIterator < E> (this);
	}
	
	/**
	 * Method that creates a list iterator for this list.
	 * 
	 * @param start A starting position.
	 */
	public ListIterator < E> listIterator (int start) {
		return new RefListIterator < E> (start, this);
	}
	
	/**
	 * Method that compares to Lists and returns if they are equal.
	 * 
	 * @return true only if the given parameter list is equal to this list.
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof List))
			return false;
		@SuppressWarnings("unchecked")
		List<E> temp = (List<E>) obj;
		if(this.size() != temp.size())
			return false;
		Iterator<E> it = this.iterator();
		Iterator<E> itty = temp.iterator();
		while(it.hasNext()) {
			E val = it.next();
			E val2 = itty.next();
			if(!(val.equals(val2)))
				return false;
		}
		return true;	
	}
}
