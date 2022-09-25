package sort;

import list.*;

/**
 * Sort a LinkedList in 0(n^2).
 * 
 * @author Matthew Cipriotti
 *
 */
public class BubbleSortLinked <E extends Comparable> implements Sorter<E> {
	
	public void sort(List<E> list) {
		
		E left, right;
		ListIterator<E> it;
		
		for(int i=0; i<list.size()-1;i++) {
			
			it = list.listIterator();
			right = it.next();
			
			for(int j=0;j<list.size()-i-1;j++) {
				
				left = right;
				right = it.next();
				if(left.compareTo(right) > 0) {
					
					it.remove();
					it.previous();
					it.add(right);
					right = it.next();
				}	
			}
		}
	}
}
