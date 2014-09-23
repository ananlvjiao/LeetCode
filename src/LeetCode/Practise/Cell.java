package LeetCode.Practise;

public class Cell<K, V> {
	private K key;
	private V value;
	public Cell(K k, V v)
	{
		this.key = k;
		this.value = v;
	}
	
//	public boolean equalTo(V value)
//	{
//		key
//	}
	
	public K getKey(){return this.key;}
	public V getValue(){return this.value;}
}
