package wk1;
public class Sorting {





public static void selectionSort(int[] array, int arrayLen) { // complete this method
 for (int i = 0; i < arrayLen - 1; i++)
 {
    int min = i;
    for (int j = i + 1; j < arrayLen; j++){
		if (array[min] > array [j] )
		{
			min = j;
		}
    }
	int temp = array[i];
	array[i] = array[min];
	array[min] = temp;
	}
	}

public static void insertionSort(int[] array, int arrayLen) 
	{ // complete this method
	for (int i = 1; i < arrayLen; i++)
    {
    int temp = array[i];
    int j = i - 1;
    while(j >= 0 && array[j] > temp){
        array[j + 1] = array[j];
        j--;
    }
    array[j + 1]  = temp;
}
}


}