package DataStructures.Sorts;

public class MergeSort
{
	public static String toString(int[] array)
	{
		if (array.length == 0)
			return "[]";
		String str = "[" + array[0];
		for (int i = 1; i < array.length; i++)
			str += "," + array[i];
		return str + "]";
	}

	//mergesort private version.
	private static int[] merge(int[] a, int[] b)
	{
		int[] merged = new int[a.length + b.length];
		int i = 0, j = 0;
		for (int k = 0; k < merged.length; k++)
		{
			if (i >= a.length)
				merged[k] = b[j++];
			else if (j >= b.length)
				merged[k] = a[i++];
			else if (a[i] <= b[j])
				merged[k] = a[i++];
			else
				merged[k] = b[j++];
		}
		return merged;
	}


	public static int[] mergeSort(int[] array)
	{
		int n = array.length;
		if (n <= 1)
			return array;
		//create 2 lists to divide and conquer
		int[] a = new int[n/2];
		int[] b = new int[n/2];
		//populate both arrays with elements
		//from the original list.
		for (int i = 0; i < a.length; i++)
			a[i] = array[i];
		for (int i = 0; i < b.length; i++)
			b[i] = array[i+b.length];
		//call our private merge algorithm on
		//the merged verion of these 2 list.
		return merge(mergeSort(a), mergeSort(b));
	}
}