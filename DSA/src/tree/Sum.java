package tree;

/**
 * A Sum is the result of addding two Expressions
 * 
 * @author Matthew Cipriotti
 *
 */
public class Sum extends Expr {

	public Sum(Expr left, Expr right) {
		super(left, right);
	}
	
	public int eval() {
		return left.eval() + right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sum))
			return false;
		Sum other = (Sum) obj;
		return(left.equals(other.left) && right.equals(other.right)) || (left.equals(other.right) && right.equals(other.left));
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
		return "(" + left + " + " + right + ")";
	}
}
