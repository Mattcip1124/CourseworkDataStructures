package tree;

/**
 * A Difference is the result of subtracting two Expressions.
 * @author Matthew Cipriotti
 *
 */
public class Difference extends Expr {

	public Difference(Expr left, Expr right) {
		super(left, right);
	}
	
	public int eval() {
		return left.eval() - right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference))
			return false;
		Difference other = (Difference) obj;
		return(left.equals(other.left) && right.equals(other.right));
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 0)
			return left;
		if(left instanceof Constant && left.eval() == 0)
			return right;
		if(left.equals(right))
			return new Constant(1);
		return this;
	}
	
	/**
	 * @return this Sum as an infix String
	 */
	public String toString() {
		return "(" + left + " - " + right + ")";
	}
}
