package tree;

/**
 * A Product is the result of multiplying two Expressions.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Product extends Expr {

	public Product(Expr left, Expr right) {
		super(left, right);
	}
	
	public int eval() {
		return left.eval() * right.eval();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return(left.equals(other.left) && right.equals(other.right)) || (left.equals(other.right) && right.equals(other.left));
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 1)
			return left;
		if(left instanceof Constant && left.eval() == 1)
			return right;
		if(left instanceof Constant && left.eval() == 0 || right instanceof Constant && right.eval() == 0 )
			return new Constant(0);
		return this;
	}
	
	/**
	 * @return this Product as an infix String
	 */
	public String toString() {
		return "(" + left + " * " + right + ")";
	}
}
