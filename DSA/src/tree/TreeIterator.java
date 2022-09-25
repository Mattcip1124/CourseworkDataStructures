package tree;

import list.*;
import queue.*;

/**
 * Visit every value in the family of a Binary Tree, using In-order Traversal.
 * 
 * @author Matthew Cipriotti
 *
 */
public class TreeIterator<E> implements Iterator<E> {

	BinaryTree<E> tree;
	QueueADT<E> queue = new Queue<E>();
	E lastGotten;   //Last value obtained by next.
	
	public TreeIterator(BinaryTree<E> tree) {
		this.tree = tree;
		if(!tree.isEmpty())
			buildQ(tree);
	}
	
	private void buildQ(BinaryTree<E> tree) {
		//InOrder Traversal
		if(!tree.getLeft().isEmpty())
			buildQ(tree.getLeft());
		queue.add(tree.getValue());
		if(!tree.getRight().isEmpty())
			buildQ(tree.getRight());
		//PreOrder Traversal
		/**queue.add(tree.getValue());
		if(!tree.getLeft().isEmpty())
			buildQ(tree.getLeft());
		if(!tree.getRight().isEmpty())
			buildQ(tree.getRight());*/
	}
	
	public boolean hasNext() {
		return ! queue.isEmpty();
	}
	
	public E next() {
		lastGotten = queue.remove();
		return lastGotten;
	}
	
	public void remove() {
		if(!(lastGotten.equals(tree.getValue()) && (tree.getLeft().isEmpty() || tree.getRight().isEmpty()))) {
			tree = tree.remove(lastGotten);
			return;
		}
		E repl;
		if(tree.getLeft().isEmpty())
			repl = getSuccessor();
		else
			repl = getPredecessor();
		tree.remove(repl);
		tree.setValue(repl);
	}
	
	private E getSuccessor() {
		BinaryTree<E> result = tree.getRight();
		while(!result.getLeft().isEmpty())
			result = result.getLeft();
		return result.getValue();
	}
	
	private E getPredecessor() {
		BinaryTree<E> result = tree.getLeft();
		while(!result.getRight().isEmpty())
			result = result.getRight();
		return result.getValue();
	}
	
	public E getLastGotten() {
		return lastGotten;
	}
}
