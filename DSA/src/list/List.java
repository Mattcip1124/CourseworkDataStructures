package list;

public interface List<E> {

	E get(int ndx);
	
	E set(int ndx, E value);
	
	void add(E value);
	
	void add(int ndx, E value);
	
	E remove(int ndx);
	
	int size();
	
	void clear();
	
	boolean isEmpty();
	
	int indexOf(Object obj);
	
	boolean contains(Object obj);
	
	boolean remove(Object obj);
	
	Iterator<E> iterator();
	
	ListIterator<E> listIterator();
	
	ListIterator<E> listIterator(int start);
	
	boolean equals(Object obj);
}
