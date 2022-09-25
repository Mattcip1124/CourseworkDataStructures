package queue;

import list.*;
/**
 * Queue in which the largest value is removed first.
 * 
 * @author Matthew Cipriotti
 *
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {

	List<E> values = new ArrayList<E>();
	
	public E remove() {
		E result = values.get(0);
		int last = values.size() - 1;
		int parent = 0;
		int bc = biggerChild(0);
		while(2*parent+1 < last && greater(bc, last)) {
			values.set(parent, values.get(bc));
			parent = bc;
			bc = biggerChild(parent);
		}
		values.set(parent,  values.get(last));
		values.remove(last);
		return result;
	}
	
	public void add(E value) {
		int last = values.size();
		values.add(value);;
		int child = last;
		int parent = (child-1)/2;
		while(child > 0 && greater(child, parent)) {
			swap(child, parent);
			child = parent;
			parent = (child-1)/2;
		}
	}
	
	private boolean greater(int x, int y) {
		return values.get(x).compareTo(values.get(y)) > 0;
	}
	
	private int biggerChild(int parent) {
		int left = 2*parent+1;
		int right = 2*parent+2;
		if(right >= values.size())
			return left;
		if(greater(left, right))
			return left;
		return right;
	}
	
	public E peek() {
		
		if(values.isEmpty())
			return null;
		return values.get(0);
	}
	
	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public int size() {
		return values.size();
	}
	
	private void swap(int x, int y) {
		
		E temp = values.get(x);
		values.set(x, values.get(y));
		values.set(y, temp);
	}
	
	public void clear() {
		values.clear();
	}
	
	public String toString() {
		if(isEmpty()) 
			return "[]";
		String list = "[" + values.get(0);
		for(int i = 1; i < values.size(); i++) {
			E temp =  values.get(i);
			list = list + "," + temp;
			}
		
		return list + "]";
	}
}
