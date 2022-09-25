package set;

import hash.*;
import list.*;

/**
 * An implementation of Set, using HashTable. Client must have equals(Object)
 * and hashCode() which agree.
 * 
 * @author Matthew Cipriotti
 *
 */
public class HashSet<E> implements Set<E> {

	HashTable<E> table = new HashTable<E>();
	
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}
	
	public boolean add(E value) {
		if(contains(value))
			return false;
		table.put(value);
		return true;
	}
	
	public boolean remove(Object obj) {
		return table.remove(obj);
	}
	
	public Iterator<E> iterator() {
		return table.iterator();
	}
	
	public int size() {
		return table.size();
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public void clear() {
		table.clear();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Set))
			return false;
		Set<E> s = (Set<E>) obj;
		if(s.size() != this.size())
			return false;
		Iterator<E> it = this.iterator();
		while(it.hasNext())
			if(!(s.contains(it.next())))
				return false;
		return true;
	}
	
	public Set<E> intersection(Set<E> other) {
		Iterator<E> it = other.iterator();
		Set<E> inter = new HashSet<E>();
		E test;
		while(it.hasNext()) {
			test = it.next();
			if(this.contains(test))
				inter.add(test);
		}
		return inter;
	}
	
	public Set<E> union(Set<E> otherSet) {
		Iterator<E> it = otherSet.iterator();
		Set<E> union = new HashSet<E>();
		union = this;
		E test;
		while(it.hasNext()) {
			test = it.next();
			if(!union.contains(test))
				union.add(test);
		}
		return union;
	}
	
	public String toString() {
		return table.toString();
	}
}