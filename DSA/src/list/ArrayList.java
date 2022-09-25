package list;
/**
 * 
 * @author Matthew Cipriotti
 * @date 09/09/19
 */
public class ArrayList<E> implements List<E> {
	
	E [] values;
	int size = 0;
	
	/**
	 * Constructor for ArrayList Objects.
	 */
	public ArrayList() {
		this(10);
	}
	
	/**
	 * Constructor for ArrayList Objects.
	 * 
	 * @param cap The initial capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int cap) {
		values = (E[]) new Object[cap];
	}
	
	/**
	 * Constructor for ArrayList Objects.
	 * 
	 * @param value A value to be added to the start of the list.
	 */
	public ArrayList(E value) {
		add(value);
	}
	
	/**
	 * Method to get a value at an index.
	 * @param ndx The given index
	 * @return the value
	 */
	public E get(int ndx) {
		return values[ndx];
	}
	
	/**
	 * Method that sets a value at an index.
	 * @param ndx The index
	 * @param value The value to set
	 * @return The old value.
	 */
	public E set(int ndx, E value) {
		E result = values[ndx];
		values[ndx] = value;
		return result;
	}
	
	/**
	 * Method that adds a value to the end of the list.
	 * @param value The value to add
	 */
	public void add(E value) {
		add(size, value);
	}
	
	/**
	 * Method that adds a value at the index.
	 * @param ndx The given index
	 * @param value The value to add
	 */
	public void add(int ndx, E value) {
		if(values.length == size)
			alloc();
		for(int i = size; i > ndx; i--)
			values[i] = values[i-1];
		size++;
		values[ndx] = value;
		}
	
	/**
	 * Method to allocate new list space.
	 */
	private void alloc() {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[2 * values.length];
		for(int i = 0; i < values.length; i++)
			temp[i] = values[i];
		values = temp;
	}
	
	/**
	 * Method that removes a value at an index.
	 * @param ndx The given index
	 * @return The removed value.
	 */
	public E remove(int ndx) {
		E result = values[ndx];
		for(int i = ndx; i < size-1; i++)
			values[i] = values[i+1];
		size--;
		return result;
	}
	
	/**
	 * Method that returns the size of this list.
	 * @return The size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Method that clears the list
	 */
	public void clear() {
		size = 0;
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
	 * Method that returns the first occurrence of the given object.
	 * @param obj The Object to check
	 * @return int The position.
	 */
	public int indexOf(Object obj) {
		for(int i = 0; i < size; i++) {
			if(values[i].equals(obj))
				return i;
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
		String list = "[" + values[0];
		for(int i = 1; i < size; i++) {
			E temp = values[i];
			list = list + "," + temp;
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
		remove(rendx);
		return true;
	}
	
	/**
	 * Method that creates an iterator for this list.
	 * @return an iterator for this list.
	 */
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}
	
	/**
	 * Method that creates a list iterator for this list.
	 */
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E>(this);
	}
	
	/**
	 * Method that creates a list iterator for this list.
	 * 
	 * @param start A starting position.
	 */
	public ListIterator<E> listIterator(int start) {
		return new ArrayListIterator<E>(start, this);
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
