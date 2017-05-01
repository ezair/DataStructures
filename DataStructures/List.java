//Author: Eric Zair
//File: List.java
//Description:	This File contains a list interface that is implemented
//				by LinkedList.java and ArrayList.java

package DataStructures;

public abstract class List
{

	//variables
	//Contains the size of the list.	
	protected int size;

	//this method increments the size of the list.
	protected void incrementSize()
	{
		size++;
	}


	//this method decrements the size of the list.
	protected void decrementSize()
	{
		size--;
	}

	//this method checks if index is out of bounds.
	protected void checkBounds(int index)
	{
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Error! Out Of Bound");
	}


	//this method returns the size of the list.
	public int size()
	{
		return size;
	}

}	