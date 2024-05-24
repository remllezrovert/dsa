package wk1;
import java.util.Arrays;
public class TestCorrectness {

    private static void testStack() throws Exception {
        int stackSize = 7;
        Stack stack = new Stack(stackSize);
        System.out.println("**** Push Test ****");
        System.out.println();
        for (int i = 1; i <= 4; i++) {
            int x = i * 5;
            stack.push(x);
            System.out.println("Push " + x);
            System.out.println("Stack: " + stack.toString());
            System.out.println("Size: " + stack.size());
            System.out.println();
        }
        System.out.println("**** Pop Test ****");
        System.out.println();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Stack: (Popped " + stack.pop() + ") " + stack.toString());
            System.out.println("Size: " + stack.size());
            System.out.println();
        }

        System.out.println("**** Push Test ****");
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            int x = i * 7;
            stack.push(x);
            System.out.println("Push " + x);
            System.out.println("Stack: " + stack.toString());
            System.out.println("Size: " + stack.size());
            System.out.println();
        }
        System.out.println("**** Pop Test ****");
        System.out.println();
        for (int i = 1; i <= 7; i++) {
            System.out.println("Stack: (Popped " + stack.pop() + ") " + stack.toString());
            System.out.println("Size: " + stack.size());
            System.out.println();
        }
    }

    private static void testQueue() throws Exception {
        int queueSize = 7;
        Queue queue = new Queue(queueSize);
        System.out.println("**** Enqueue Test ****");
        System.out.println();
        for (int i = 1; i <= 4; i++) {
            int x = i * 5;
            queue.enqueue(x);
            System.out.println("Enqueue " + x);
            System.out.println("Queue: " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
        System.out.println("**** Dequeue Test ****");
        System.out.println();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Queue: (Dequeued " + queue.dequeue() + ") " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
        System.out.println("**** Enqueue Test ****");
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            int x = i * 7;
            queue.enqueue(x);
            System.out.println("Enqueue " + x);
            System.out.println("Queue: " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
        System.out.println("**** Dequeue Test ****");
        System.out.println();
        for (int i = 1; i <= 4; i++) {
            System.out.println("Queue: (Dequeued " + queue.dequeue() + ") " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
        System.out.println("**** Enqueue Test ****\n");
        for (int i = 1; i <= 4; i++) {
            int x = i * 7;
            queue.enqueue(x);
            System.out.println("Enqueue " + x);
            System.out.println("Queue: " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
        System.out.println("**** Dequeue Test ****\n");
        for (int i = 1; i <= 7; i++) {
            System.out.println("Queue: (Dequeued " + queue.dequeue() + ") " + queue.toString());
            System.out.println("Size: " + queue.size());
            System.out.println();
        }
    }

    private static void testSorting() {
        System.out.println("**** Sorting ****\n");
        int A[] = {13, 17, 8, 14, 1};
        System.out.println("Original Array: " + Arrays.toString(A));
        Sorting.selectionSort(A, A.length);
        System.out.println("Selection Sorted Array: " + Arrays.toString(A));

        System.out.println();

        int B[] = {-13, -17, -8, -14, -1, -20};
        System.out.println("Original Array: " + Arrays.toString(B));
        Sorting.insertionSort(B, B.length);
        System.out.println("Insertion Sorted Array: " + Arrays.toString(B));
    }

    public static void main(String[] args) throws Exception {
        testStack();
        testQueue();
        testSorting();
    }
}

