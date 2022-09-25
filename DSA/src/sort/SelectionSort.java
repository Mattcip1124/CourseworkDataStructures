package sort;

import list.*;

/**
 * Selection Sort Algorithm.
 * For efficiency the list should be an ArrayList.
 * 
 * @author Matthew Cipriotti
 *
 */
public class SelectionSort <E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		
		this.list = list;
		for(int i = 0; i < list.size() - 1;i++)
			swap(i, posSmallest(i));
	}
	
	/**
	 * @return position of the smallest value 
	 * from position start to the end of list.
	 */
	private int posSmallest(int start) {
		
		int result = start;
		for(int i = start + 1; i < list.size(); i++) {
			int cmp = list.get(i).compareTo(list.get(result));
			if(cmp < 0) //Change to < for ascending and > for descending.
				result = i;
		}
		return result;
	}
	
	private void swap(int x, int y) {
		
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
}
