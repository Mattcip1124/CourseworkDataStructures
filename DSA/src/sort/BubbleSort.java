package sort;

import list.*;

/**
 * A Bubble Sort Algorithm.
 * 
 * @author Matthew Cipriotti
 *
 */
public class BubbleSort <E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	boolean swapped = false;
	
	public void sort(List<E> list) {
		
		this.list = list;
		for(int i = 0; i < list.size() - 1; i++) {
			swapped = false;
			for(int j = 0; j < list.size() - i - 1; j++)
				if(list.get(j).compareTo(list.get(j+1)) > 0) {
					swap(j, j+1);
				}
			if(!swapped)
				break;
		}
	}
	
	private void swap(int x, int y) {
		
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
		swapped = true;
	}
}
