package set;

import list.*;

/**
 * Collection with no duplicates, and no required ordering.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface Set<E> {

	/**
	 * @return true iff given value is in this set
	 */
	boolean contains(Object obj);
	
	/**
	 * Add given value to this Set, if not already in this Set.
	 * @return true if it was added
	 */
	boolean add(E value);
	
	/**
	 * Remove given obj from this Set, if possible.
	 * @return true iff it was removed
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator for this Set
	 */
	Iterator<E> iterator();
	
	/**
	 * @return the size of this Set.
	 */
	int size();
	
	/**
	 * @return true iff this Set is empty.
	 */
	boolean isEmpty();
	
	/**
	 * clear this Set.
	 */
	void clear();
	
	/**
	 * @return true iff obj is a Set which contains the same value as this Set,
	 *  and only those values which are in this Set.
	 */
	boolean equals(Object obj);
	
    /** @return the Set which is the intersection of this Set with the other Set */
    Set<E>  intersection(Set<E> other);
    
    /** @return the Set which is the union of this Set with otherSet  */
    Set < E>  union(Set < E> otherSet);
}
