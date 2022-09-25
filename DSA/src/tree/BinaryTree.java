package tree;

import list.Iterator;

/**
 * May have a value, two children
 * 
 * @author Matthew Cipriotti
 *
 */
public interface BinaryTree<E> {

	/**
	 * @return value of this Binary Tree, or null if none.
	 */
	E getValue();
	
	/**
	 * @return true iff the family of this Binary Tree contains
	 * the given object.
	 */
	boolean containsKey(Object obj);
	
	/**
	 * @return the given value from the family of this Binary Tree,
	 * or null if not founds.
	 */
	E get(E value);
	
	/**
	 * Add the given value to the family of this Binary Tree.
	 * Do not add if value is in family.
	 * @return the resulting Binary Tree.
	 */
	BinaryTree<E> add(E value);
	
	/**
	 * Remove the given object from the family of this Binary Tree,
	 * if possible.
	 * @return the resulting Binary Tree.
	 */
	BinaryTree<E> remove(Object obj);
	
	/** @return true iff this BinaryTree is empty */
	boolean isEmpty();
	 
	/** @return the left child of this BinaryTree */
	BinaryTree< E> getLeft();
	 
	/** @return the right child of this BinaryTree */
	BinaryTree< E> getRight();

	/** Set the left child of this BinaryTree to the given BinaryTree */
	void setLeft(BinaryTree< E> tree);
	 
	/** Set the right child of this BinaryTree to the given BinaryTree */
	void setRight(BinaryTree< E> tree);
	 
	/** Set the value of this BinaryTree to the given value */
	void setValue(E value);

	Iterator<E> iterator();
	
	String toString();
	
	/**
	 * @return The height of this BinarySearchTree
	 */
	int getHeight();
	
	/** @return true iff this BinaryTree is well balanced */
	boolean isBalanced();
}
