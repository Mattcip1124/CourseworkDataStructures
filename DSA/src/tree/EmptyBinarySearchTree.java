package tree;

import list.Iterator;

/**
 * A Binary Tree which has no value, no children.
 * 
 * @author Matthew Cipriotti
 *
 */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	public E getValue() {
		return null;
	}
	
	public boolean containsKey(Object obj) {
		return false;
	}
	
	public E get(E value) {
		return null;
	}
	
	public BinaryTree<E> add(E value) {
		return new BinarySearchTree<E>(value);
	}
	
	public BinaryTree<E> remove(Object obj) {
		return this;
	}
	
	public boolean isEmpty() {
		return true;
	}
	 
	public BinaryTree< E> getLeft() {
		return null;
	}
	 
	public BinaryTree< E> getRight() {
		return null;
	}

	public void setLeft(BinaryTree< E> tree) {
		
	}
	 
	public void setRight(BinaryTree< E> tree) {
		
	}
	 
	public void setValue(E value) {
		
	}
	
	public Iterator<E> iterator() {
		return new TreeIterator(this);
	}
	
	public String toString() {
		return "[]";
	}
	
	public int getHeight() {    //O(1)
		return 0;
	}
	
	public boolean isBalanced() {
		return true;
	}
}
