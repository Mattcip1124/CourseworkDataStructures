package memory;


/**
 * Test the Memory allocation and free methods.
 *
 * @author (sdb)
 * @version (Dec. 2019)
 */
public class HWmemoryDriver
{
    
    public static void main (String [] args)
    {   Memory mem = new Memory();
        
        mem.allocate (64);
        mem.allocate (32);
        mem.allocate (16);
        if (! mem.free (64))
            System.err.println ("Error");
        mem.allocate(48);
        mem.allocate(8);
        System.out.println (mem);
        // There should be two blocks on the free list
        // There should be four blocks on the allocated list
    }
}
