package sort;

import list.*;

/**
 * Search for a target.
 * Pre: List is an ArrayList. Sorted in increasing order.
 * 
 * @author Matthew Cipriotti
 *
 */
public class BinarySearch <E extends Comparable> {
	
	List<E> list;
	
	public BinarySearch(List<E> list) {
		
		this.list = list;
	}
	
	public int binarySearch(E target) {
		
		return binSrch(0, list.size()-1, target);
	}
	
	private int binSrch(int start, int end, E target) {
		
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		int cmp = target.compareTo(list.get(mid));
		if(cmp == 0)
			return mid;
		if(cmp < 0)
			return binSrch(start, mid - 1, target);
		return binSrch(mid + 1, end, target);
	}
}
