package map;

import list.Iterator;
import map.HashMap.Entry;
import set.HashSet;
import set.Set;
import tree.*;

/**
 * A map implemented with a BinarySearchTree.
 * 
 * @author Matthew Cipriotti
 *
 */
public class TreeMap<K extends Comparable, V> implements Map<K, V> {

	BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree<Entry<K, V>>();
	int size = 0;
	private Entry<K, V> entry;
	
	//beginning of inner class
	class Entry<K extends Comparable, V> implements Comparable<Entry<K, V>> {
		
		K key;
		V value;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public int compareTo(Entry<K, V> other) {
			return key.compareTo(other.key);
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}	//end of inner class
	
	public boolean containsKey(K key) {
		entry = new Entry<K, V>(key, null);
		return tree.containsKey(entry);
	}
	
	public V get(K key) {
		entry = new Entry<K, V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		entry = tree.get(newEntry);
		if(entry == null) {				//key not in map.
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		V result = entry.value;
		entry.value = value;
		return result;
	}
	
	public V remove(K key) {
		entry = new Entry<K, V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		tree = tree.remove(entry);
		size--;
		return entry.value;
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
		tree = new EmptyBinarySearchTree();
		size = 0;
	}
	
	public Set<K> keySet() {
		Iterator<Entry<K, V>> it = tree.iterator();
		Set<K> set = new HashSet<K>();
		while(it.hasNext())
			set.add(it.next().key);
		return set;
	}
	
	public boolean hasDuplicateValues() {
		Iterator<Entry<K, V>> it = tree.iterator();
		V test;
		while(it.hasNext()) {
			test = it.next().value;
			Iterator<Entry<K, V>> itty = tree.iterator();
			while(itty.hasNext()) {
				if(test.equals(itty.next()))
					return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return tree.toString();
	}
}
