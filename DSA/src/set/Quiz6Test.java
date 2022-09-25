package set;

public class Quiz6Test {

	public static void main(String[] args) {
		HashSet<Integer> hashs = new HashSet<Integer>();
		TreeSet<Integer> trees = new TreeSet<Integer>();
		
		hashs.add(5);
		hashs.add(9);
		hashs.add(14);
		hashs.add(1);
		hashs.add(99);
		
		trees.add(0);
		trees.add(7);
		trees.add(9);
		trees.add(11);
		trees.add(1);
		trees.add(5);
		trees.add(98);
		
		Set<Integer> union = hashs.union(trees);
		
		
		System.out.println(union);
	}
}
