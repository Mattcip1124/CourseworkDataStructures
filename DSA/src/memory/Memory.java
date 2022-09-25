package memory;

import list.*;
/**
 * Simulate the management of memory.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Memory {

	List<Block> free = new LinkedList<Block>();
	List<Block> allocated = new LinkedList<Block>();
	static int MAX = 4096;	//static means MAX is a class variable, not an instance.
	
	public Memory() {
		free.add(new Block(0, MAX));
	}
	
	/**
	 * Free the Block that has the given start position.
	 * 
	 * @param start The start of the Block to be freed.
	 * @return true iff there is an allocated Block at start.
	 */
	public boolean free(int start) {
		Block b;
		Iterator<Block> it = allocated.iterator();
		while(it.hasNext()) {
			b = it.next();
			if(b.start == start) {
				it.remove();
				free.add(b);
				coalesce(b);	//Lab 13
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Allocate memory for the given size.
	 * 
	 * @param size The given size of the Block to allocate.
	 * @return start for that Block, or -1 if not available.
	 */
	public int allocate(int size) {
		Block b, newBlock;
		b = findBestFit(size);
			if(b != null) {
				newBlock = new Block(b.start, size);
				allocated.add(0, newBlock);
				b.start = b.start + size;
				b.size = b.size - size;
				if(b.size == 0)
					free.remove(free.indexOf(b));
				return newBlock.start;
			}
		return -1;
	}
	
	public String toString() {
		return "Free: " + free + "\n" + "Allocated: " + allocated;
	}
	
	private Block findBestFit(int size) {
		Iterator<Block> it = free.iterator();
		Block b;
		Block result = null;
		int testSize = 0;
		boolean found = false;
		while(it.hasNext()) {
			b = it.next();
			if(found) {
				if(b.size < testSize && b.size >= size) {
					testSize = b.size;
					result = b;
				}	
			}
			else {
				if(b.size >= size) {
					testSize = b.size;
					found = true;
					result = b;
				}
			}
		}
		return result;
	}
	
	//Lab 13
	private void coalesce(Block b) {
		
	}
}
