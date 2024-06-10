package wk4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashingWithChaining {

	public ArrayList<LinkedList<Integer>> hashTable;
	public int TABLE_SIZE;

	@SuppressWarnings("unchecked")
	public HashingWithChaining(int tableSize) {
		TABLE_SIZE = tableSize;
		hashTable = new ArrayList<>();
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable.add(new LinkedList<Integer>());
	}

	private int hash(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}


	public boolean search(int key) { // complete this method
		int hashIndex= hash(key);
		LinkedList<Integer> linkedList = hashTable.get(hashIndex);
		Iterator<Integer> it = linkedList.iterator();
		while (it.hasNext())
			if (it.next() == key)
				return true;
		return false;
	}


	public boolean insert(int key) { // complete this method
		if (search(key) == true)
			return false;
		int hashIndex= hash(key);
		LinkedList<Integer> linkedList = hashTable.get(hashIndex);
		return linkedList.add(key);
	}

	public boolean remove(int key) { // complete this method
		int hashIndex= hash(key);
		LinkedList<Integer> linkedList = hashTable.get(hashIndex);
		Iterator<Integer> it = linkedList.iterator();
		while (it.hasNext())
			if (it.next() == key)
				{
				it.remove();
				return true;
				}
		return false;

	}

	public void printStatistics() {
		int maxSize = hashTable.get(0).size();
		int minSize = maxSize, total = maxSize;
		for (int i = 1; i < TABLE_SIZE; i++) {
			int size = hashTable.get(i).size();
			if (size > maxSize)
				maxSize = size;
			else if (size < minSize)
				minSize = size;
			total += size;
		}
		System.out.printf(
				"Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n",
				maxSize, minSize, total / TABLE_SIZE);
	}
}
