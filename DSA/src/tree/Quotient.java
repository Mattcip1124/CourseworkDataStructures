package tree;

/**
 * A Quotient is the result of dividing two Expressions
 * 
 * @author Matthew Cipriotti
 *
 */
public class Quotient extends Expr {

	public Quotient(Expr left, Expr right) {
		super(left, right);
	}
	
	public int eval() {
		return left.eval() / right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient))
			return false;
		Quotient other = (Quotient) obj;
		return(left.equals(other.left) && right.equals(other.right));
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && left.eval() == 0 || right instanceof Constant && right.eval() == 0)
			return new Constant(0);
		if(right instanceof Constant && right.eval() == 1)
			return left;
		if(left.equals(right))
			return new Constant(1);
		if(left.right.equals(right.left))
			return new Quotient(left.left, right.right);
		return this;
	}
	
	/**
	 * @return this Sum as an infix String
	 */
	public String toString() {
		return "(" + left + " / " + right + ")";
	}
}
