//Test client for HashTable.java
public class HashTableClient
{
	public static void main(String[] args)
	{
		HashTable<String, String> table = new HashTable<>();
		
		//test put() method.
		System.out.println("Testing the put() method.");
		table.put("Eric", "Jason");
		System.out.println("\nPut seems to work.");	
		table.put("Jason", "Jesse");
		System.out.println("Check for duplicates");
		table.put("Jason", "Eric");
		System.out.println("Check for duplicates");

		//test get() method.
		System.out.println("Testing the get() method.");
		System.out.println(table.get("Eric"));
		System.out.println(table.get("jason"));

		//test out keySet method.
		System.out.println("Testing the keySet() method.");
		System.out.println(table.keySet());

		//test out remove() method.
		System.out.println("Testing the remove() method.");
		table.remove("Eric");
		System.out.println(table.keySet());
	
		//test out contains() method.
		System.out.println("Testing the remove() method");
		System.out.println(table.contains("Jason"));

		//test out the toString() method
		table.put("Eric", "jason");
		table.put("Eric", "David");
		System.out.println("Testing the toString() method");
		System.out.println(table);
	}
}