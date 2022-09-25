package tree;

/**
 * A Variable is an Expression.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Variable extends Expr {

	char name;
	
	public Variable(char name) {
		super(null, null);
		this.name = name;
	}
	
	public int eval() {
		throw new IllegalArgumentException();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Variable))
			return false;
		Variable other = (Variable) obj;
		return (name == other.name);
	}
	
	public Expr simplify() {
		return this;
		
	}
	
	public String toString() {
		return "" + name;
	}
}
