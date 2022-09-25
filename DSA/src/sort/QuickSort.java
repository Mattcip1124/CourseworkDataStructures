package sort;
import list.*;

/**
 * QuickSort Algorithm.
 * List should be an ArrayList
 * 
 * @author Matthew Cipriotti
 *
 */
public class QuickSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size() - 1);
	}
	
	private void qSort(int start, int end) {
		if(end <= start)
			return; //size of this part of the list is 1 or 0
		
		int p = partition(start, end); //p is position of pivot value
		qSort(start, p-1);
		qSort(p + 1, end);
	}
	
	private int partition(int start, int end) {
		int p = (start + end)/2;
		E pivot = list.get(p);
		list.set(p, list.get(start));
		p = start;
		for(int i = start + 1; i <= end; i++)
			if(list.get(i).compareTo(pivot) < 0) {
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		list.set(p, pivot);
		return p;
	}
}
