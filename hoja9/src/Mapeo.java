public interface Mapeo<K, V> {
	void put(K key, V value);

	boolean contains(K key);

	V get(K key);
}
