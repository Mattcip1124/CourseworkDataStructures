package tree;

public class HeightTest {

	public static void main(String[] args ) {
		
		BinaryTree<String> tree = new BinarySearchTree<String>("dog");
		tree.add("cat");
		tree.add("robin");
		tree.add("mouse");
		tree.add("goat");
		tree.add("snake");
		tree.add("snake");
		tree.add("hamster");
		tree.add("groat");
		tree.add("haamster");
		tree.add("habster");
		tree.add("frog");
		tree.add("elephant");
		tree.add("hornet");
		tree.add("Iganua");
		tree.add("jaguar");
		System.out.println("Height is:" + tree.getHeight());
		
		System.out.println(tree.isBalanced());
	}
}
