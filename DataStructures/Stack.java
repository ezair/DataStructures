/*
Author: Eric Zair
File: Stack.java
Description: This program contains a inner class called node
			 that simulates a linked list. The outter class,
			 Stack, is contains a linked nodes that create my
			 version of a Stack datastructure.
*/
package DataStructures;


import java.util.Iterator;
import java.util.List;

//Outter class
//this class creates a stack Data structure.
public class Stack<T>
{
	//Variables
	private Node top;
	private int size;

	//default constructor.
	public Stack()
	{
		//(takes no arguments)
		//nothing is done inside of constructor.	
	}


	//constructor that takes a List and copies all of
	//it's elements into the this stack.
	public Stack(List<T> list)
	{
		for(T value : list)
			push(value);
	}


	//method for Stack -------------------------------

	//this method adds(pushes) a node to the
	//top of the stack.
		
	public void push(T data)
	{
		Node temp = top;
		top = new Node(data);
		top.next = temp;
		size++;
	}


	//this method returns the top node and removes it
	//from the stack.
	public T pop()
	{
		if(top == null)
			throw new IllegalArgumentException("No data to pop!");
		//otherwise.
		T popped = top.data;
		remove();
		return popped;
	}


	//this method returns the data at top
	//IT DOES NOT REMOVE remove top Node.
	public T peek()
	{
		return top.data;
	}


	//this method removes the top node from the stack.
	private void remove()
	{
		if(top == null)
			throw new IllegalArgumentException("top.next is NULL");

		top = top.next;
		size--;
	}


	//this method returns how far away the value
	//passed in is from being popped.
	//Return -1 if value is not in stack.
	public int search(T value)
	{
		//return -1 if value is not in stack.
		if(!contains(value))
			return -1;
		//check to find where index is and return it.
		else
		{
			int index = 0;
			Node current = top;

			for(int i = 0; i < size; i++)
			{
				if(current.data == value)
				{
					index = i;				
					current = current.next;
				}
			}
			return index;
		}
	}


	//this method checks to see if a stack contains
	//given data.
	public boolean contains(T value)
	{
		Node current = top;
		while(current != null)
		{
			if(current.data == value)
				return true;
			else
				current = current.next;
		}
		return false;
	}


	//this method prints out the stack
	//as a String.
	public String toString()
	{
		if(top == null)
			return "[]";
		else
		{
			Node current = top;
			String str = "[" + current.data;
			while(current.next != null)
			{
				current = current.next;
				str += ", " + current.data;
			}
			return str + "]";
		}
	}


	//---------------------------------------------
	//This is the inner Node class that will be used
	//by the outter stack classs.
	private class Node
	{
		//Variables
		Node next;
		T data;

		//constructor that takes data only.
		private Node(T data)
		{
			this.data = data;
		}


		//constructor that takes first node and data.
		private Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}

	}//outter Node class.
}
