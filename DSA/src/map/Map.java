package map;

import set.*;

/**
 * key-value pairs. Lookup is fast using keys, which are unique.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface Map<K, V> {

	/**
	 * @return true if given key is in this Map.
	 */
	boolean containsKey(K key);
	
	/**
	 * @return the value corresponding to the given key, or null if
	 *  not in this map.
	 */
	V get(K key);
	
	/**
	 * Put the given key-value pair into this map. Replace old value
	 *  with given value, if already in this Map.
	 *  @return old value, or null
	 */
	V put(K key, V value);
	
	/**
	 * Remove key-value pair which has given key, from this map.
	 * @return its value, or null if not found.
	 */
	V remove(K key);
	
	/**
	 * @return the size of this map.
	 */
	int size();
	
	/**
	 * @return true iff this Map is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Clear this Map.
	 */
	void clear();
	
	/**  @return the entries in this Map as a String, in the format key=value */
	String toString();
	
	/** @ return a Set of all the keys in this Map */
	Set< K> keySet(); 
	
	/** @return true iff this Map contains duplicate values */

	boolean hasDuplicateValues();
}
