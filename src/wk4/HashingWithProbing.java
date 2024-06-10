package wk4;
import java.util.ArrayList;

public class HashingWithProbing {

	public ArrayList<Integer> hashTable;
	public int _size;
	public int _garbage;

	public static final int EMPTY = -1;
	public static final int TOMBSTONE = -9;

	private int hash(int val) {
		return (37 * val + 61) % capacity();
	}

	public HashingWithProbing(int initSize) {
		init(initSize);
	}

	private void init(int capacity) { // complete this method
		this._size = 0;
		this._garbage = 0;
		hashTable = new ArrayList<Integer>();
		for (int i=0; i < capacity; i++)
			{
			hashTable.add(EMPTY);
			}
	}


	private void resize(int newTableSize) { // complete this method
		ArrayList<Integer> keys = new ArrayList<>();
		hashTable.forEach((i) -> 
			{
			if (i != TOMBSTONE && i != EMPTY) 
				keys.add(i);
			});
		init(newTableSize);
		//keys.forEach((i)-> insert(i));
		keys.forEach(this::insert);
	}

	public int search(int key) { // complete this method
		int hashIndex = hash(key);
		for (int i = 0; i < capacity(); i++)
			{
			if (hashTable.get(hashIndex) == key)
				return hashIndex;
			if (hashTable.get(hashIndex) == EMPTY)
				return -1;
			hashIndex++;
			if (hashIndex == capacity())
				hashIndex = 0;
			}
		return -1;
	}

	public int insert(int key) { // complete this method
		if (_size + _garbage == capacity())
			resize(2 * _size);
		int hashIndex = hash(key);
		for (int i = 0; i < capacity(); i++)
			{
			if (hashTable.get(hashIndex) == key)
				return -1;
			if (hashTable.get(hashIndex) == EMPTY)
				break;
			hashIndex++;
			if (hashIndex == capacity())
				hashIndex = 0;
			}
		hashTable.set(hashIndex, key);
		_size++;
		return hashIndex;
	}

	public int remove(int key) { // complete this method
		int index = search(key);
		if (index < 0)
			return -1;
		hashTable.set(index, TOMBSTONE);
		_garbage++;
		_size--;
		if (_garbage * 2 == capacity())
			resize(2 * _size);
		return index;

	}

	public int capacity() {
		return hashTable.size();
	}

	public int size() {
		return _size;
	}
}
