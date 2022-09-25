package misc;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb and Matthew Cipriotti)
 * @version (2020) 
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT<Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    int curdoc = 100;
    int size;

    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
      this.speed = speed;
      this.id = id;
      docs = new Queue<Doc>();
    }

    /** Add a document to this printer's queue 
       Display the document and printer on stdout.
       */
    public void add (Doc doc)
    {    
    	docs.add(doc);
    	size++;
        
        //////////// Do not change this println statement ///////////////
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     *  
     */
    public void print()
    {  
    	if(curdoc == 100 && !(docs.isEmpty()))
    	curdoc = docs.peek().size();
    	if(curdoc <= speed)
    	{
    	System.out.println("Print task completed on " + id + " for: Doc of size " + docs.peek().size());
    	docs.remove();
    	size--;
    	curdoc = 100;
    	}
    	else {
    		curdoc = curdoc - speed;
    		
    	}
    }

    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return size; }

    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}
