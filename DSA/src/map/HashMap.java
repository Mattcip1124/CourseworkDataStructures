package map;

import list.*;
import hash.*;
import set.*;

/**
 * A Map which stores the key-value pairs (Entries) in a HashTable.
 * 
 * @author Matthew Cipriotti
 *
 */
public class HashMap<K, V> implements Map<K, V> {

	HashTable<Entry<K, V>> table;
	
	Entry<K, V> entry;
	
	/**
	 * Inner class for Entry.
	 */
	@SuppressWarnings("hiding")
	class Entry<K, V> {
		
		K key;
		V value;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@SuppressWarnings({"rawtypes", "unchecked"})
		public boolean equals(Object obj) {
			if(!(obj instanceof Entry))
				return false;
			Entry<K, V> other = (Entry) obj;
			return key.equals(other.key);
		}
		
		public int hashCode() {
			return key.hashCode();
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}		//End of Inner class Entry
	
	public HashMap() {
		this(10);
	}
	
	public HashMap(int cap) {
		table = new HashTable<Entry<K, V>>(cap);
	}
	
	public boolean containsKey(K key) {
		entry = new Entry<K, V>(key, null);
		return table.containsKey(entry);
	}
	
	public V get(K key) {
		entry = new Entry<K, V>(key, null);
		entry = table.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		entry = table.get(newEntry);
		if(entry == null) {
			table.put(newEntry);
			return null;
		}
		V val = entry.value;
		entry.value = value;
		return val;
	}
	
	public V remove(K key) {
		entry = new Entry<K, V>(key, null);
		entry = table.get(entry);
		if(entry == null)
			return null;
		table.remove(entry);
		return entry.value;
	}
	
	public int size() {
		return table.size();
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public void clear() {
		table.clear();
	}
	
	public String toString() {
		return table.toString();
	}
	
	public Set<K> keySet() {
		Iterator<Entry<K, V>> it = table.iterator();
		Set<K> set = new HashSet<K>();
		while(it.hasNext())
			set.add(it.next().key);
		return set;
	}
	
	public boolean hasDuplicateValues() {
		Iterator<Entry<K, V>> it = table.iterator();
		V test;
		while(it.hasNext()) {
			test = it.next().value;
			Iterator<Entry<K, V>> itty = table.iterator();
			while(itty.hasNext()) {
				if(test.equals(itty.next()))
					return true;
			}
		}
		return false;
	}
}
