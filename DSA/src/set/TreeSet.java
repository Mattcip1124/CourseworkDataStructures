package set;

import tree.*;
import list.*;

/**
 * A Set, using a BinarySearchTree. Values are in natural order.
 * 
 * @author Matthew Cipriotti
 *
 */
public class TreeSet<E extends Comparable> implements Set<E> {

	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;
	
	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}
	
	public boolean add(E value) {
		if(contains(value))
			return false;
		tree = tree.add(value);
		size++;
		return true;
	}
	
	public boolean remove(Object obj) {
		if(contains(obj)) {
			tree = tree.remove(obj);
			size--;
			return true;
		}
		return false;
	}
	
	public Iterator<E> iterator() {
		if(size == 0)
			return new EmptyIterator<E>();
		return new TreeSetIterator<E>(this);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	public void clear() {
		tree = new EmptyBinarySearchTree<E>();
		size = 0;
	}
	
	public String toString() {
		return tree.toString();
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
		Set<E> inter = new TreeSet<E>();
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
		Set<E> union = new TreeSet<E>();
		union = this;
		E test;
		while(it.hasNext()) {
			test = it.next();
			if(!union.contains(test))
				union.add(test);
		}
		return union;
	}
}
