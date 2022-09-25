package tree;

public class Quiz5ExprDriver {

	public static void main(String[] args) {
	
    Expr e1 = new Product (new Variable('a'), new Variable('b'));    
    Expr e2 = new Product (new Variable('b'), new Variable('c'));     
    Expr e3 = new Quotient (e1, e2);
    
    System.out.println("Simplifified: " + e3.simplify());
    
    Expr e4 = new Sum (new Variable('a'), new Variable('b'));
    Expr e5 = new Sum (new Variable('b'), new Variable('a'));            
    Expr e6 = new Difference (e4, e5);                                 
    System.out.println (e6 + "Simplifies to " + e6.simplify());          
    System.out.println();
	}
}
