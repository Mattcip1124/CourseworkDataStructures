package sort;

import list.*;

/**
 * Test the sorting algorothms.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface Sorter <E extends Comparable> {
	
	void sort(List<E> list);
}
