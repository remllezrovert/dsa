
package wk6;

import java.util.ArrayList;

public class StringHeap {

	private ArrayList<String> heapArray;

	public StringHeap() {
		heapArray = new ArrayList<>();
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) {
		String temp = heapArray.get(index1);
		heapArray.set(index1, heapArray.get(index2));
		heapArray.set(index2, temp);
	}

	public void insert(String value) { // complete this method
		int currentIndex = heapArray.size();
		int parentIndex = (currentIndex -1) /2;
		heapArray.add(value);
		while (currentIndex > 0 && 0 <= heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex))){
			swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	public void extract() { // complete this method
    swap(0, heapArray.size() - 1);
    heapArray.remove(heapArray.size() - 1);
    int currentIndex = 0;
    int leftIndex = 2 * currentIndex + 1;
    int rightIndex = 2 * currentIndex + 2;
    
    while (leftIndex < heapArray.size()) {
        int minIndex = leftIndex;
        String minKey = heapArray.get(minIndex);
        
        if (rightIndex < heapArray.size()) {
            String rightKey = heapArray.get(rightIndex);
            if (rightKey.compareTo(minKey) < 0) {
                minIndex = rightIndex;
                minKey = rightKey;
            }
        }
        
        if (minKey.compareTo(heapArray.get(currentIndex)) < 0) {
            swap(minIndex, currentIndex);
            currentIndex = minIndex;
        } else {
            break;
        }
        
        leftIndex = 2 * currentIndex + 1; // left child i
        rightIndex = leftIndex + 1;       // right child i
    }
}




	public static void heapSort(String array[], int arrayLen) throws Exception {
		StringHeap heap = new StringHeap();
		for (String s : array)
			heap.insert(s);
		for (int i = 0; i < arrayLen; i++) {
			array[i] = heap.top();
			heap.extract();
		}
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
