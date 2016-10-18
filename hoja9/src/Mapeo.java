/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
public interface Mapeo<K, V> {
	void put(K key, V value);

	boolean contains(K key);

	V get(K key);
}
