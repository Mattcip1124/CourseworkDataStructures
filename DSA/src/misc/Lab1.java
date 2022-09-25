package misc;
import java.util.*;

/**
 * Work with lists
 * 
 * @author (sdb)
 * @author (Matthew Cipriotti)
 * @version (Fall 2019)
 */
public class Lab1
{   static int MAX = 1000000;
    public static void main(String[] args)
    {
        List<Integer> myList = new LinkedList<Integer>();
        init (myList);
        System.out.println ("First 20 numbers before removing evens");
        show (myList,20);
        deleteEvens(myList);
        System.out.println ();
        System.out.println ("First 20 numbers after removing evens");
        show (myList,20);
    }
    /**
     *  Delete all even numbers from the given list
     */
    private  static void deleteEvens(List<Integer> aList)
    {
    	Iterator<Integer> it = aList.iterator();
    	
    	while(it.hasNext()) {
    		int x = it.next();
    		if(x % 2 == 0) {
    			it.remove();
    		}
    	}
    }
  
//     Initialize the given list with MAX integers
    private static void init (List<Integer> aList)
    {
        Random rand = new Random(1);
        for (int i=0; i<MAX; i++)
            aList.add(rand.nextInt(100));
    }
    
//     Display the first max numbers from the given List on stdout
    private static void show (List<Integer> aList, int max)
    {
        for (int i=0; i<max; i++)
            System.out.print (aList.get(i) + " ");
    }
    
    
}
