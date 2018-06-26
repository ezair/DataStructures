import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


//This file is a used to set out my Set implementation in java.
public class SetClient
{
	public static void main(String[] args)
	{
		//testing code goes in here.
		Set<Integer> set = new Set<>();
		List<Integer> list = new ArrayList<>();
		list.add(2);
		//Set<Double> set2 = new Set<>(list);
		System.out.println("Testing toString: " + set);
	
		//test out the add method.
		set.add(3);
		set.add(2);
		set.add(2);
		System.out.println(set);
		//set.add(3.4);
	

		//test out sort method.
		set.sort();
		System.out.println(set);
	

		//test out removeAll()
		set.removeAll();
		System.out.println("After remove all: " + set);

		
		//test get()
		System.out.println(set.get(0));
		System.out.println(set.get(1));	

	}
}