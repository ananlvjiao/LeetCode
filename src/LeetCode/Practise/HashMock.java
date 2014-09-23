package LeetCode.Practise;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMock<K, V> {
	private final int capacity = 10;
	LinkedList<Cell<K,V>>[] items;
	
	public HashMock()
	{
		items = (LinkedList<Cell<K, V>>[]) new LinkedList[capacity];
		
	}
	
	public int hashCodeOfKey(K key)
	{
		return key.toString().length()%items.length;
	}
	
	public V get(K key)
	{
		int ikey = hashCodeOfKey(key);
		LinkedList<Cell<K,V>> vals= items[ikey];
		if(vals == null)
		{
			return null;
		}
		
		for(Cell<K, V> c: vals)
		{
			if(c.getKey().equals(key))
			{
				return c.getValue();			
			}
		}
		return null;
	}
	
	public void put(K key, V value)
	{
		int ikey =hashCodeOfKey(key);
		LinkedList<Cell<K,V>> vals= items[ikey];
		if(vals == null)
		{
			vals= new LinkedList<Cell<K,V>>();			
		}
		Cell<K,V> newCell = new Cell<K,V>(key, value);
//		for(Cell<K, V> c: vals)
//		{
//			if(c.getKey().equals(value))
//			{
//				vals.remove(c);
//				break;
//			}
//		}

		Iterator<Cell<K,V>> iter = vals.iterator();
		while(iter.hasNext())
		{
			if(((Cell<K, V>) iter).getKey().equals(key))
			{
				iter.remove();
			}
		}
		vals.add(newCell);
		items[ikey] = vals;
			
	}
}

