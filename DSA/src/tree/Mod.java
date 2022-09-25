package tree;

/**
 * A mod is the difference remaining after dividing two Expressions.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Mod extends Expr {

	public Mod(Expr left, Expr right) {
		super(left, right);
	}
	
	public int eval() {
		return left.eval() % right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Mod))
			return false;
		Mod other = (Mod) obj;
		return(left.equals(other.left) && right.equals(other.right)) || (left.equals(other.right) && right.equals(other.left));
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 1)
			return left;
		if(left instanceof Constant && left.eval() == 1)
			return right;
		return this;
	}
	
	/**
	 * @return this Sum as an infix String
	 */
	public String toString() {
		return "(" + left + " % " + right + ")";
	}
}
