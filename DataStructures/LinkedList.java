//Author: Eric Zair
//File: LinkedList.java
//Description: This is a class file for a LinkedList.

package DataStructures;

public class LinkedList<T> extends List
{
	//variables
	//first LinkedNode in the list.
	private LinkedNode<T> front;


	//default constructor
	public LinkedList()
	{
		front = null;
	}


	//this method checks to see if the list is empty.
	public boolean isEmpty()
	{
		return front == null;
	}


	//this method returns the LinkedList as a string.
	public String toString()
	{
		if(isEmpty())
			return "[]";
		//if the list is not empty.
		else
		{
			String str = "[" + front.data;
			LinkedNode<T> current = front.next;
			while(current != null)
			{
				str += ", " + current.data;
				current = current.next;
			}
			return str + "]";
		}

	}


	//this method adds to the end of the list.
	public void add(int index, T value)
	{
		//check if the index is out of bounds.
		checkBounds(index);

		if(index == 0)
			front = new LinkedNode<>(value, front);
		else
		{
			LinkedNode<T> current = front;
			for(int i = 0; i < index - 1; i++)
				current = current.next;
			
			current.next = new LinkedNode<>(value, current.next); 
		}
		incrementSize();
	}


	//this method adds a LinkedNode to the end of the list.
	public void addLast(T value)
	{
		add(size, value);
	}


	//this method adds a LinkedNode to the front of a list.
	public void add(T value)
	{
		add(0, value);
	}

	
	//this method gets the value at a given index.
	public T get(int index)
	{
		checkBounds(index);
		
		//check not make sure that list is not empty.
		if(isEmpty())
			throw new IndexOutOfBoundsException("LIST IS EMPTY");

		//create new LinkedNode so that front is not
		//changed.
		LinkedNode current = front;
		//sort through to find value at index.
		for(int i = 0; i < index; i++)
			current = current.next;
		//type cast so that no errors occurr.
		@SuppressWarnings("unchecked")
		T value = (T) current.data;
		return value;
	}


	//this method checks to see if this list is equal to another
	//LinkedList IN THE SAME ORDER.
	public boolean equals(LinkedList<T> other)
	{
		//check if they are the same size.
		if(size != other.size())
			return false;

		for(int i = 0; i < size; i++)
			if(get(i) != other.get(i))
				return false;
			//if the condition never hits true
			//then return true.
		return true;
	}


	//this method clears the entire list.
	public void clear()
	{
		while(front != null)
			front = front.next;
	}


	//this method removes an element from the list
	//at any given index.
	public void remove(int index)
	{
		//make sure list is not empty.
		if(isEmpty())
			throw new IndexOutOfBoundsException("Error, List is empty");
		
		//check to make sure index is in bounds.
		checkBounds(index);

		if(index == 0)
			front = front.next;
		else
		{
			LinkedNode<T> current = front;
			for(int i = 0; i < index - 1; i++)
				current = current.next;
			
			current.next = current.next.next;
		}
	}


	//this method removes the first thing in the LinkedList.
	public void removeFirst()
	{
		remove(0);
	}


	//this method removes the last element in the list.
	public void removeLast()
	{
		remove(size-1);
	}

//---------------------------------------------------------------------------
	//this class creates linked nodes which make up a linked list.
	private class LinkedNode<T>
	{
		//variables
		private LinkedNode<T> next;
		private T data;
		
		
		//constructor that takes the data type given(E).
		private LinkedNode(T data)
		{
			this.data = data;
			next = null;
		}


		//Second constructor:
		//This constructor lets the user to set the value
		//of the following node.
		private LinkedNode(T data, LinkedNode<T> next)
		{
			this.data = data;
			this.next = next;
		}
	}//LinkedNode class
}