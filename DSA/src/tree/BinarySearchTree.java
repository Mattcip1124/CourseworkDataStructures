package tree;

import list.*;

/**
 * A Binary Tree: left child's value is smaller.
 * 				  right child's value is larger.
 * 				  All children are Binary Search Trees.
 * 
 * @author Matthew Cipriotti
 *
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	E value;
	BinaryTree<E> left = new EmptyBinarySearchTree<E>();
	BinaryTree<E> right = new EmptyBinarySearchTree<E>();
	int size = 1;
	
	public BinarySearchTree(E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}
	
	public boolean containsKey(Object obj) {
		int cmp = this.value.compareTo(obj);
		
		if(cmp == 0)
			return true;
		if(cmp<0)
			return right.containsKey(obj);
		return left.containsKey(obj);
	}
	
	public E get(E value) {
		int cmp = this.value.compareTo(value);
		
		if(cmp == 0)
			return this.value;
		if(cmp<0)
			return right.get(value);
		return left.get(value);
	}
	
	public BinaryTree<E> add(E value) {
		int cmp = this.value.compareTo(value);
			
		if(cmp<0)
			right = right.add(value);
		if(cmp>0)
			left = left.add(value);
		if(cmp != 0)
			size++;
		return this;
	}
	
	public BinaryTree<E> remove(Object obj) {
		E other;
		try {other = (E) obj;
		int cmp = value.compareTo(other);
		if(cmp == 0) {
			List<BinaryTree<E>> kids;
			kids = children();
			if(kids.size() == 0)
				return new EmptyBinarySearchTree<E>();
			if(kids.size() == 1)
				return kids.get(0);
			//kids.size() == 2
			BinaryTree<E> successor = getSuccessor();
			remove(successor.getValue());
			value = successor.getValue();
		}
		if(cmp < 0)
			right = right.remove(other);
		if(cmp > 0)
			left = left.remove(other);
		return this;
		}
		catch (ClassCastException cce) {
			return this;
		}
	}
	
	private List<BinaryTree<E>> children() {
		List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
		if(!left.isEmpty())
			result.add(left);
		if(!right.isEmpty())
			result.add(right);
		return result;
	}
	
	private BinaryTree<E> getSuccessor() {
		BinaryTree<E> result = right;
		while(!result.getLeft().isEmpty())
			result = result.getLeft();
		return result;
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	 
	public BinaryTree< E> getLeft() {
		return left;
	}
	 
	public BinaryTree< E> getRight() {
		return right;
	}

	public void setLeft(BinaryTree< E> tree) {
		this.left = tree;
	}
	 
	public void setRight(BinaryTree< E> tree) {
		this.right = tree;
	}
	 
	public void setValue(E value) {
		this.value = value;
	}
	
	public Iterator<E> iterator() {
		return new TreeIterator(this);
	}
	
	public String toString() {
		Iterator<E> it = iterator();
		String list = "[" + it.next();
		while(it.hasNext()) {
			E temp = it.next();
			list = list + "," + temp;
			}
		
		return list + "]";
	}
	
	public int getHeight() {		//O(n)
		int l = 1;
		int r = 1;
		if(!left.isEmpty())
			l = left.getHeight() + 1;
		if(!right.isEmpty())
			r = right.getHeight() + 1;
		if(l > r)
			return l;
		return r;		
	}
	
	public boolean isBalanced() {
		int l = left.getHeight();
		int r = right.getHeight();
		if(!((l - r) < 5))
			return false;
		return left.isBalanced() && right.isBalanced();
	}
}
