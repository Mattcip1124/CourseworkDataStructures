package sort;

import list.*;

/**
 * HeapSort Algorithm.
 * Apply to an ArrayList.
 * 
 * @author Matthew Cipriotti
 */
public class HeapSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
	public void sort(List<E> list) {	//O(nlog(n)) for loop, O(nlog(n)) for loop, O(nlog(n)) total.
		this.list = list;
		
		heapify(0);
		int last = list.size() - 1;
		while(last > 0) {				//O(n)
			swap(0, last);
			last--;
			percDown(0, last);			//O(log(n))
		}
	}
	
	private void heapify(int root) {		//O(n) calls on heapify, O(log(n)) for percDown, O(nlog(n)) total.
		int max = list.size() - 1;
		
		if(root >= max)
			return;
		heapify(2*root + 1);	//left child
		heapify(2*root + 2);	//right child
		percDown(root, max);
	}
	
	private void percDown(int root, int max) {		//O(log(n))
		int bc = biggerChild(root, max);
		
		while(2*root + 1 <= max && greater(bc, root)) {
			swap(root,bc);
			root = bc;
			bc = biggerChild(root, max);
		}
	}
	
	/**
	 * @return position of bigger child of root.
	 * Do not go beyond max.
	 */
	private int biggerChild(int root, int max) {	//O(1)
		int left = 2*root + 1;
		int right = 2*root + 2;
		
		if(right > max)
			return left;
		if(greater(left, right))
			return left;
		return right;
	}
	
	private boolean greater(int x, int y) {			//O(1)
		return list.get(x).compareTo(list.get(y)) > 0;
	}
	
	private void swap(int x, int y) {
		
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
}
