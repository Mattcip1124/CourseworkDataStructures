package  memory;

/**
 * Test the memory allocator.
 * 
 * @author (sdb) 
 * @version (Dec 2019)
 */
public class LabTestMemoryBestFitCoalesce
{
    static int v1, v2, v3, v4, v5, v6;
    static Memory mem = new Memory ();
    
   public static void main(String[] args)
   {   init();
       
       // Testing part (a),  Best Fit Algorithm
      System.out.println ("Testing part (a)");
      System.out.println (mem);
       mem.free (v2);
       mem.free (v4);
       mem.free (v6);
       System.out.println (mem);
       
       mem.allocate(150);
       System.out.println (mem);
       System.out.println ();
       
       // Testing part (b), Coalesce free blocks
       /////// Uncomment the following when ready for part (b)
       System.out.println ("Testing part (b)");
       init();
       mem.free (v2);
       mem.free (v4);
       System.out.println (mem);
       System.out.println ();
       
       mem.free (v1);
       mem.free (v5);
       System.out.println (mem);
       System.out.println ();
       
       mem.free (v3);
       System.out.println (mem);
       System.out.println ();
       
       mem.free (v6);
       System.out.println (mem);
    }
    
   private static void init()
   {   mem = new Memory ();
       v1 = mem.allocate (100);
       v2 = mem.allocate (250);
       v3 = mem.allocate (300);
       v4 = mem.allocate (200);
       v5 = mem.allocate (500);
       v6 = mem.allocate (250);
    }   
       
}
