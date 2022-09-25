package tree;

/**
 * An Expression may have two operands, each of which is Expression.
 * 
 * @author Matthew Cipriotti
 */
public abstract class Expr {

	Expr left, right;
	
	public Expr(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * @return the value of this Expression.
	 * Pre: This Expression has a value.
	 */
	public abstract int eval();
	
	/**
	 * @return true iff this Expression is equal to the given object
	 */
	public abstract boolean equals(Object obj);
	
	/**
	 * @return a simplified version of this Expression, if possible
	 */
	public abstract Expr simplify();
}
