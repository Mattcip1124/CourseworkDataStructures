package sort;

import list.*;
import java.util.Random;

/**
 * Test the binary search algorithm
 * Using the SelectionSort 
 * Algorithm on an ArrayList.
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class HomeworkTestSearchArrayList
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    static int MAX = 20;
    
    public static void main (String[] args)
    {
        
    Sorter <Integer> sorter = new SelectionSort ();
  
    testSort (sorter);

    BinarySearch<Integer> searcher = new BinarySearch<Integer> (grades);
    for (int i=0; i<MAX; i++)
        {   int target = rand.nextInt(MAX*3);
            System.out.println ("target " + target + " found at position " +
                searcher.binarySearch (target));
        }
        
    
    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        System.out.println (sorter.getClass().toString());
        System.out.println (grades);
        sorter.sort(grades);
        System.out.println (grades + "\n");
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<MAX; i++)
            grades.add (rand.nextInt(MAX*3));
    }
}
