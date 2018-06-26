
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


//Implementation of a Set object in java.
//The datastructure used underneath the hood is
//an ArrayList.
public class Set<T extends Comparable<T>>
{

	//Class instances.
	private List<T> set = new ArrayList<>();


	//Default Constructor.
	public Set()
	{
		//Nothing in this constructor.
	}


	//Constuctor to add the contents of an already
	//existing list to this Set.
	public Set(List<T> list)
	{
		for (T item : list)
			if (!set.contains(item))
				set.add(item);
	}


	//add an item to the set.
	public void add(T data)
	{
		if (!set.contains(data))
			set.add(data);
	}



	public void addAll(List<T> list)
	{
		for (T item : list)
			if (!set.contains(item))
				set.add(item);
	}


	//remove an item from this adt.
	//Item is given as parameter.
	public void remove(T item)
	{
		set.remove(item);
	}


	//clear the entire ds.
	public void removeAll()
	{
		set = new ArrayList<>();
	}


	//2string method
	public String toString()
	{
		return set.toString();
	}


	//sort our set object.
	public void sort()
	{
		Collections.sort(set);
	}


	//get an element at an index given in the set.
	public T get(int index)
	{
		if (index < 0 || index >= set.size())
			throw new IllegalArgumentException("Error: Set index out of bounds");
		return set.get(index);
	}


	//reverse the list.
	public void reverse()
	{
		Collections.reverse(set);
	}


	//soreted reversed.
	public void sortReversed()
	{
		sort();
		reverse();
	}
}