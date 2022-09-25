package misc;
import stack.*;
import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and Matthew Cipriotti) 
 * @version (2020)
 */
public class LabPostfix
{
    public static void main (String [] args)
    {   postfixEval();  }
    
    // read postfix expressions from the keyboard, and evaluate
    public static void postfixEval()
    {   Stack <Integer> stack = new Stack <Integer> ();
        
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int.
        int right;           // store right operand
        int left;
        String oper = "";
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        while (input.length() > 0)               // Empty input line terminates the program
            {   opInts = input.split (" ");      // An array of Strings, delimiter is space
                
                for (String s : opInts)
                    {
                	
                	if(Character.isDigit(s.charAt(0)))
                		stack.push(Integer.parseInt(s));
                	else
                		oper = s;
                	
                	if(oper.equals("+")) {
                		right = stack.pop();
                		left = stack.pop();
                		stack.push(left + right);
                	}
                	if(oper.equals("-")) {
                		right = stack.pop();
                		left = stack.pop();
                		stack.push(left - right);
                	}
                	if(oper.equals("*")) {
                		right = stack.pop();
                		left = stack.pop();
                		stack.push(left * right);
                	}
                	if(oper.equals("/")) {
                		right = stack.pop();
                		left = stack.pop();
                		stack.push(left / right);
                	}
                	if(oper.equals("%")) {
                		right = stack.pop();
                		left = stack.pop();
                		stack.push(left % right);
                	}
                	oper = "";
                    }
                	
                    if (!stack.isEmpty())
                        System.out.println (stack.peek());
                    stack.clear();
                    
                    input = scanner.nextLine();
            }
        scanner.close();
    }
}
 
