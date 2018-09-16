//Author:	Eric Zair
//File:		HashTable.java
//Description:	My personal implementation of
//				a HashTable (hashmap) in java.
//				This class contains an inner class
//				called "HashEntry<K, V>
//				HashEntry is used for putting things
//				into out HashTable Data Structure.
package DataStructures;
import java.util.TreeSet;
import java.util.Set;


public class HashTable <K, V>
{
	//HashTable instance variables
	private int INITAL_SIZE = 16;
	//This will serve as our inner data structure.
	private HashEntry[] entries = new HashEntry[INITAL_SIZE];


	//Default constructor
	public HashTable() 
	{
		//nothing to be done here;)
	}


	//Put a Key, Value into our HashTable.
	public void put(K key, V value)
	{
		int hashValue = getHash(key);
		HashEntry<K, V> hashEntry = new HashEntry<>(key, value);
		if (entries[hashValue] == null)
			entries[hashValue] = hashEntry;
		else
		{
			HashEntry<K, V> temp = entries[hashValue];
			while (temp.next != null)
				temp = temp.next;
			temp.next = hashEntry;
		}
	}

	//remove an Entry from the HashTable.
	public void remove(K key)
	{
		int hashValue = getHash(key);
		if (entries[hashValue] == null)
			throw new IllegalArgumentException("Error in HashTable.remove(): key does not exist.");
		entries[hashValue] = entries[hashValue].next;
	}


	//This method takes a key and returns the value
	//at the loncation of the key.
	public V get(K key)
	{
		int hashValue = getHash(key);
		HashEntry<K,V> current = entries[hashValue];
		if (entries[hashValue] != null)
		{
			while (!current.key.equals(key) && current.next != null)
				current = current.next;
		}
		return current.value;
	}


	//This method checks to see if a given K
	//is in out HashTable object.
	public boolean contains(K key)
	{
		return entries[getHash(key)] != null;
	}


	//Returns a String version of our
	//HashTable Data Structure.
	public String toString()
	{
		String str = "{\n";
		for (K key : keySet())
			str += "[" + key + " : " +  get(key) + "]\n";	
		return str + "}";
	}


	//This method returns the list of all the keys
	//that this HashTable objects contains.
	//Speed is about.
	public Set<K> keySet()
	{
		Set<K> keys = new TreeSet<>();
		//Go throught each element in out entries array.
		//Add every element in it's linked list to our set
		for (HashEntry<K, V> entry : this.entries)
		{
			HashEntry<K, V> current = entry;
			while (current != null)
			{
				keys.add(current.key);
				current = current.next;
			}
		}
		return keys;
	}


	//Return the location of where our value is
	//in our HashEntry[] arryay. 
	private int getHash(K key)
	{
		return key.hashCode() % INITAL_SIZE;
	}


	/*This is the inner HashEntry class.
	  This class will be used inorder to add
	  new entries into out HashTable.
	*/
	private class HashEntry<K, V>
	{
		//HashEntry instance variables.
		private K key;
		private V value;
		private HashEntry<K, V> next;

		//Default constructor for HashEntry object.
		private HashEntry(K key, V value)
		{
			this.key = key;
			this.value = value;
			next = null;
		}
	}
}
