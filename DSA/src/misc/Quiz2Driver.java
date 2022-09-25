package misc;
import list.*;

public class Quiz2Driver {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(0);
		ar.add(1);
		ar.add(2);
		ar.add(3);
		
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(0);
		li.add(1);
		li.add(2);
		li.add(3);
		
		System.out.println(ar.toString());
		System.out.println(li.toString());
		
		ListIterator<Integer> iar = ar.listIterator(2);
		ListIterator<Integer> ili = li.listIterator(1);
		
		iar.swap();
		ili.swap();
		
		System.out.println(ar.toString());
		System.out.println(li.toString());
 	}
}
