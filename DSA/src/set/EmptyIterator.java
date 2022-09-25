package set;

import list.*;

class EmptyIterator<E> implements Iterator<E> {

	public boolean hasNext() {
		return false;
	}
	
	public E next() {
		return null;
	}
	
	public void remove() {
		return;
	}
}
