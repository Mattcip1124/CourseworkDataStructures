package tree;

/**
 * A Constant has a value.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Constant extends Expr {

	int value;
	
	public Constant(int value) {
		super(null, null);
		this.value = value;
	}
	
	public int eval() {
		return value;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Constant))
			return false;
		Constant other = (Constant) obj;
		return (value == other.value);
	}
	
	public Expr simplify() {
		return this;
	}
	
	public String toString() {
		return "" + value;
	}
	
}
