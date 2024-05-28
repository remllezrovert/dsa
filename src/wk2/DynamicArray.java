package wk2;
import java.util.Arrays;

public class DynamicArray {

    private int[] A;
    private int numElements;
    private int length;

    public DynamicArray(int initialSize) {
        numElements = 0;
        length = initialSize;
        A = new int[initialSize];
    }

    /**
     * Helper function that creates an array tmp[] of size newArrayLen
     * if arrayLen <= newArrayLen, then copies array[] to tmp[]
     * else copies the first newArrayLen elements of array[] into tmp[]
     */
    private int[] copyArray(int[] array, int arrayLen, int newArrayLen) {
        int[] tmp = new int[newArrayLen];
        int len = Math.min(arrayLen, newArrayLen);
        for (int i = 0; i < len; i++)
            tmp[i] = array[i];
        return tmp;
    }

    public int access(int index) {
        if (index >= numElements)
            throw new ArrayIndexOutOfBoundsException();
        return A[index];
    }

    public void update(int index, int val) {
        if (index >= numElements)
            throw new ArrayIndexOutOfBoundsException();
        A[index] = val;
    }

    public void insertAtEnd(int val) {
        if (numElements + 1 > length) {
            length *= 2;
            A = Arrays.copyOf(A, length);
        }
        A[numElements] = val;
        numElements++;
    }

    public void deleteLast() {
        if (numElements == 0)
            throw new ArrayIndexOutOfBoundsException("Cannot delete from an empty array");
        numElements--;
        if (numElements < length / 2) {
            length /= 2;
            A = Arrays.copyOf(A, length);
        }
    }

    public int size() {
        return numElements;
    }

    public int capacity() {
        return length;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(A, 0, numElements));
    }
}