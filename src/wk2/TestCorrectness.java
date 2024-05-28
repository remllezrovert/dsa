package wk2;
import java.util.*;

public class TestCorrectness {

	public static void testBinarySearchMethods() {

		System.out.println("****************** Finding Predecessor ******************\n");
		int A[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 27, 39, 39, 39 };
		int B[] = { 1, 0, 39, 47, 36, 12, 6 };
		System.out.println("Array is " + Arrays.toString(A));
		for (int i = 0; i < B.length; i++) {
			int key = B[i];
			int x = BinarySearchApplications.predecessor(A, A.length, key);
			if (x >= 0)
				System.out.println("Predecessor of " + B[i] + " is " + A[x]);
			else
				System.out.println("Predecessor of " + B[i] + " is not defined.");
		}

		System.out.println("\n****************** Peak Finding ******************\n");
		int C_1[] = { 15, 18, 21, 25, 29, 31, 35, 23, 14, 9, 1, -1 };
		System.out.println("Array is " + Arrays.toString(C_1) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_1, C_1.length));
		int C_2[] = { 31, 35, 23, 14, 9, 1, -1 };
		System.out.println("Array is " + Arrays.toString(C_2) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_2, C_2.length));
		int C_3[] = { 31, 35, 37, 39 };
		System.out.println("Array is " + Arrays.toString(C_3) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_3, C_3.length));
		int C_4[] = { 36, 35, 32, 29 };
		System.out.println("Array is " + Arrays.toString(C_4) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_4, C_4.length));
	}

	private static LinkedList part1LinkedList() {

		LinkedList list = new LinkedList();

		list.insertAtFront(5);
		System.out.print("Inserting 5 at front. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(16);
		System.out.print("Inserting 16 at front. Current list: ");
		list.printList();

		list.insertAfter(list.getNodeAt(1), 61);
		System.out.print("Inserting 61 after position 1. Current list: ");
		list.printList();

		list.insertAfter(list.tail, 99);
		System.out.print("Inserting 99 after tail. Current list: ");
		list.printList();

		list.deleteAfter(list.getNodeAt(1));
		System.out.print("Deleting after position 1. Current list: ");
		list.printList();

		list.deleteAfter(list.getNodeAt(2));
		System.out.print("Deleting after position 2. Current list: ");
		list.printList();

		System.out.print("Trying to delete after position 2: ");
		list.deleteAfter(list.getNodeAt(2));

		list.insertAtFront(5);
		System.out.print("Inserting 5 at front. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(16);
		System.out.print("Inserting 16 at front. Current list: ");
		list.printList();

		list.insertAtFront(8);
		System.out.print("Inserting 8 at front. Current list: ");
		list.printList();

		list.insertAtEnd(21);
		System.out.print("Inserting 21 at end. Current list: ");
		list.printList();

		list.insertAtEnd(50);
		System.out.print("Inserting 50 at end. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(66);
		System.out.print("Inserting 66 at front. Current list: ");
		list.printList();

		list.insertAtFront(66);
		System.out.print("Inserting 66 at front. Current list: ");
		list.printList();

		return list;
	}

	private static void part2LinkedList(LinkedList list) {
		System.out.print("Original List: ");
		list.printList();
		System.out.print("Reversed List: ");
		list.reverse();
		list.printList();

		System.out.print("\nAfter removing all occurrences of 37: ");
		list.removeAllOccurrencesOf(37);
		list.printList();
		System.out.print("After removing all occurrences of 21: ");
		list.removeAllOccurrencesOf(21);
		list.printList();
		System.out.print("After removing all occurrences of 32: ");
		list.removeAllOccurrencesOf(32);
		list.printList();
		System.out.print("After removing all occurrences of 16: ");
		list.removeAllOccurrencesOf(16);
		list.printList();
		System.out.print("After removing all occurrences of 66: ");
		list.removeAllOccurrencesOf(66);
		list.printList();

		LinkedList list2 = new LinkedList();
		list2.insertAtFront(50);
		System.out.print("\nList 1: ");
		list.printList();
		System.out.print("List 2: ");
		list2.printList();
		System.out.print("List1 ?= List2 : " + (list.isEqualTo(list2) ? "true" : "false"));

		list2.insertAtEnd(5);
		list2.insertAtEnd(5);
		list2.insertAtEnd(8);
		System.out.print("\n\nList 1: ");
		list.printList();
		System.out.print("List 2: ");
		list2.printList();
		System.out.print("List1 ?= List2 : " + (list.isEqualTo(list2) ? "true" : "false"));

		list2.insertAtEnd(8);
		System.out.print("\n\nList 1: ");
		list.printList();
		System.out.print("List 2: ");
		list2.printList();
		System.out.print("List1 ?= List2 : " + (list.isEqualTo(list2) ? "true" : "false"));

		LinkedList list3 = new LinkedList();
		list3.insertAtFront(50);
		list3.insertAtEnd(5);
		list3.insertAtEnd(5);
		list3.insertAtEnd(9);
		System.out.print("\n\nList 1: ");
		list.printList();
		System.out.print("List 2: ");
		list3.printList();
		System.out.print("List1 ?= List2 : " + (list.isEqualTo(list3) ? "true" : "false"));

		LinkedList list4 = new LinkedList();
		list4.insertAtFront(50);
		list4.insertAtEnd(8);
		list4.insertAtEnd(5);
		list4.insertAtEnd(5);
		System.out.print("\n\nList 1: ");
		list.printList();
		System.out.print("List 2: ");
		list4.printList();
		System.out.print("List1 ?= List2 : " + (list.isEqualTo(list4) ? "true" : "false"));
		System.out.println();
	}

	private static void testLinkedListCorrectness() {
		System.out.println("****************** Test Linked List Correctness ******************\n");
		LinkedList list = part1LinkedList();
		System.out.println();
		part2LinkedList(list);
	}

	private static void testDynamicArrayCorrectness() {
		DynamicArray da = new DynamicArray(1);
		System.out.println("****************** Test Dynamic Array Correctness ******************\n");
		for (int i = 0; i < 17; i++) {
			da.insertAtEnd(i * 5);
			System.out.print(da.toString());
			System.out.println(" Num elements: " + da.size() + ", Length: " + da.capacity());
		}
		System.out.println();
		for (int i = 0; i < 17; i++) {
			da.deleteLast();
			System.out.print(da.toString());
			System.out.println(" Num elements: " + da.size() + ", Length: " + da.capacity());
		}
	}

	public static void main(String[] args) throws Exception {

		testBinarySearchMethods();
		System.out.println();
		testLinkedListCorrectness();
		System.out.println();
		testDynamicArrayCorrectness();
	}
}
