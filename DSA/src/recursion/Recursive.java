package recursion;

/**
 * 
 * @author Matthew Cipriotti
 *
 */
public class Recursive {

	/** @return the quotient when x is divided by y.
    Pre:  x >= 0, y>0
	*/
	public int div(int x, int y) {
		if(x < y)
			return 0;
		return 1 + div(x-y,y);
	}
	
	/**
	 * @return the remainder when x is divided by y.
	 * Pre: x >= 0, y > 0
	 */
	public int mod(int x, int y) {
		if(x < y)
			return x;
		return mod(x-y,y);
	}
}
