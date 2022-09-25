package hash;

import list.*;

/**
 * An Iterator for HashTables.
 * 
 * @author Matthew Cipriotti
 *
 */
class TableIterator<K> implements Iterator<K> {

	HashTable<K> table;
	int ndx = 0;			 //which LinkedList is visited.
	Iterator<K> itty;		//An Iterator for a LinkedList.
	
	public TableIterator(HashTable<K> table) {
		this.table = table;
		setItty(0);
	}
	
	/**
	 * Reset itty to the beginning of the LinkedList at given ndx.
	 */
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}
	
	/**
	 * @return the ndx of the next nonEmpty LinkedList, or -1 if none.
	 */
	private int nextList() {
		for(int i = ndx + 1; i < table.lists.size(); i++)
			if(!table.lists.get(i).isEmpty())
				return i;
		return -1;
	}
	
	public boolean hasNext() {
		if(itty.hasNext())
			return true;
		return nextList() != -1;
	}
	
	public K next() {
		if(! itty.hasNext()) {
			ndx = nextList();
			setItty(ndx);
		}
		return itty.next();
	}
	
	public void remove() {
		itty.remove();
		table.size --;
	}
}
