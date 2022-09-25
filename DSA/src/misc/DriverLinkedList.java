package misc;
import list.*;

/**
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2019)  
 */
public class DriverLinkedList
{
     
/**
 *  This main method tests the LinkedList class
 */
    List<String> friends = new LinkedList <String> ();
    
    public static void main (String[] args)
    {   DriverLinkedList driver = new DriverLinkedList();
        driver.problem1();
   // Uncomment the following when ready for problem 2
        driver.problem2();
   // Uncomment the following when ready for problem 3
        driver.problem3();
        System.out.println ("\nTesting complete");
    }
    
    private void problem1()
    {   System.out.println ("Testing problem 1");
        init();
         friends.remove (0);                             // Remove joe at position 0 
    if (friends.size() != 4)
        System.err.println ("Error in add, remove or size");
    String s1 = "sal";
    String s2 = "ly";       // s1 + s2 is "sally"
    if (friends.indexOf(s1+s2) != 1)
        System.err.println ("Error in indexOf"); 
    if  (friends.contains ("Jim"))
        System.err.println ("Not correct"); 
    if (!friends.contains (new String("jim")))
        System.err.println ("Not correct"); 
    friends.add ("mary");
     
    if (friends.indexOf("mary") != 0)
        System.err.println ("Not correct");
    }
        
    private void init()
    {
         friends.add ("joe");
         friends.add ("mary");
         friends.add ("jim");
         friends.add ("joe");                            // Lists may contain duplicate elements
         friends.add (2, "sally");                       // Insert at position 2
    }
        
    private void problem2()
     {  System.out.println ("Testing problem 2(a)");
        List<Integer> numbers = new LinkedList <Integer> ();
        for (int i=0; i<100000; i++)
            numbers.add(i);
        
        for (int i=0; i<100000; i++)
            {   int smallNdx = i % 5;
                if (numbers.get(smallNdx) != smallNdx)
                    System.err.println ("Error for " + smallNdx);
                int largeNdx = 100000 - smallNdx - 1;
                if (numbers.get(largeNdx) != largeNdx)
                    System.err.println ("Error for " + largeNdx);
           }
           
        System.out.println ("\nTesting problem 2(b)");
        System.out.println ("The list of friends is " + friends);
        friends.clear();
        if (! friends.isEmpty())
            System.err.println ("Error in clear or isEmpty");
        System.out.println (friends);
    }
    
  
    private void problem3()
    {
        System.out.println ("\nTesting problem 3 for LinkedList");
        test();
        System.out.println ("\nTesting problem 3 for ArrayList");
        friends = new ArrayList<String>();
        test();
    }

    
    
    private void test()
    {   
        ////  Uncomment the following when ready for problem 3
        friends.clear();
        for (int i=0; i< 25; i++)
            friends.add ("str" + i);
        friends.add("str3");
        if (friends.indexOf(new String("str3")) != 3)
            System.err.println ("Error in indexOf");
        if (friends.remove("foo"))
            System.err.println ("Error in remove(Object)");
            for (int i=0; i<100; i = i+2)               // remove even values
            	friends.remove(new String("str"+i));
        if (friends.size() != 13)
            System.err.println ("Error in remove(Object)");
        System.out.println (friends);
    }
}       
