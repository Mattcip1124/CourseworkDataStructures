package hash;

import list.*;

/**
 * A HashTable provides quick access to keys.
 * Your hashCode method must agree with your equals method!
 * 
 * @author Matthew Cipriotti
 *
 */
public class HashTable<K> {

	List<List<K>> lists;
	int size = 0;
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int cap) {
		lists = new ArrayList<List<K>>(cap);
		
		for(int i = 0; i < cap; i++)
			lists.add(new LinkedList<K>());
	}
	
	/**
	 * @return true if given object is in HashTable.
	 */
	public boolean containsKey(Object obj) {
		return getList(obj).contains(obj);
	}
	
	public void put(K key) {
		getList(key).add(key);
		size++;
	}
	
	/**
	 * @return a LinkedList for given object.
	 */
	private List<K> getList(Object obj) {
		int code = obj.hashCode();
		code = Math.abs(code);
		code = code % lists.size();				//x % y must be in [0 - y-1]
		return lists.get(code);
	}
	
	/**
	 * @return a key which matches the given key, or null if not found.
	 */
	public K get(K key) {
		List<K> list = getList(key);
		int ndx = list.indexOf(key);
		if(ndx < 0)
			return null;
		return list.get(ndx);
	}
	
	/**
	 * Remove given obj from this HashTable, if possible.
	 * @return true iff obj was removed.
	 */
	public boolean remove(Object obj) {
		boolean result;
		result = getList(obj).remove(obj);
		if(result)
			size--;
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	public void clear() {
		for(int i = 0; i < lists.size(); i++)
			lists.get(i).clear();
		size = 0;
	}
	
	public Iterator<K> iterator() {
		return new TableIterator<K>(this);
	}
	
	public String toString() {
		if(isEmpty())
			return "[]";
		Iterator<K> itty = this.iterator();
		String list = "[" + itty.next();
		while(itty.hasNext()) {
			K temp = itty.next();
			list = list + "," + temp;
			}
		
		return list + "]";
	}
}
