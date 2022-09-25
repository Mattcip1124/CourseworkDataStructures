package recursion;

public class RecursiveTest {

	public static void main (String[] args) {
		
		Recursive rec = new Recursive();
		System.out.println(rec.div(30,9));
		System.out.println(rec.mod(23, 5));
		System.out.println(rec.mod(690,6));
		System.out.println(rec.mod(45, 7));
		System.out.println(rec.mod(34, 32));
	}
}
