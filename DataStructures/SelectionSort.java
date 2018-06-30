package DataStructures.Sorts;

public class SelectionSort
{
	//selection sort algorithm.
	//swap the first index that has the lowest number.
	public static void selectionSort(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int minIndex = i;
			for (int j = i; j < array.length; j++)
			{
				if (array[j] < array[minIndex])
				{
					int temp = array[minIndex];
					array[minIndex] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
