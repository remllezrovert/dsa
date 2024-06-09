package wk3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MergeSortAndFriends {

public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) { // complete this function
	int a = 0;
	int b = 0;
	ArrayList<Integer> ret = new ArrayList<>();
	while (a <= lenA  - 1 && b <= lenB - 1)
		{
		if (A[a] < B[b])
			{
			a++;
			}
		else
		{
		if (A[a] > B[b])
			{
			b++;
			}
			else
			{
			ret.add(A[a]);
			a++;
			while (a <= lenA - 1 && A[a] == B[b])
				{
				a++;
				}

			}
		}
		}
	return ret;
}

public static ArrayList<Integer> binaryMerge(ArrayList<Integer> A, ArrayList<Integer> B) { // complete this function
	int a = 0;
	int b = 0;
	int lenA = A.size();
	int lenB = B.size();
	ArrayList<Integer> ret = new ArrayList<>();
	while (a <= lenA - 1 && b <= lenB - 1)
		{
		if (A.get(a) < B.get(b))
			{
			ret.add(A.get(a));
			a++;
			}
		else
		{
		if (A.get(a) > B.get(b))
			{
			ret.add(B.get(b));
			b++;
			}
			else
				{
				ret.add(A.get(a));
				a++;
				while (a <= lenA - 1 && A.get(a) == B.get(b))
					{
					ret.add(A.get(a));
					a++;
					}
				}
		}
	}
	while (a < lenA) 
		{
		ret.add(A.get(a));
		a++;
		}
    while (b < lenB)
		{
		ret.add(B.get(b));
		b++;
		}
	return ret;
}

public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this function

	ArrayList<ArrayList<Integer>> mergedLists = new ArrayList<>();
	int k = lists.size();
	if (k == 1)
		return lists.get(0);
	for (int i=0; i < k/2; i++)
		{
		mergedLists.add(binaryMerge(lists.get(2*i), lists.get(2*i+1)));
		}
	if (k%2 != 0)
		mergedLists.add(lists.get(k-1));
	

	return kWayMerge(mergedLists);
}

	private static ArrayList<Integer> subList(ArrayList<Integer> array, int left, int right) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = left; i <= right; i++)
			list.add(array.get(i));
		return list;
	}



public static void mergesort(ArrayList<Integer> array, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergesort(array, left, mid);
        mergesort(array, mid + 1, right);
        ArrayList<Integer> A = subList(array, left, mid);
        ArrayList<Integer> B = subList(array, mid + 1, right);
        ArrayList<Integer> mergedArray = binaryMerge(A, B);
        int i = left;
        int j = 0;
        int k = 0;
        while (j < A.size() && k < B.size()) 
			{
            if (A.get(j) <= B.get(k)) 
				{
				array.set(i, A.get(j));
				j++;
				} 
			else 
				{
                array.set(i, B.get(k));
                k++;
            	}
            i++;
        	}
        while (j < A.size()) 
			{
			array.set(i, A.get(j));
			i++;
			j++;
			}
		while (k < B.size()) 
			{
			array.set(i, B.get(k));
			i++;
			k++;
			}
    }
}

}