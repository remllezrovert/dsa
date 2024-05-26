package wk2;

public class LinkedList {

    public ListNode head, tail;
    public int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void insertAfter(ListNode argNode, int value) {
        if (argNode == null) return;
        ListNode newNode = new ListNode(value);
        newNode.next = argNode.next;
        argNode.next = newNode;
        if (argNode == tail) {
            tail = newNode;
        }
        size++;
    }

    public void deleteAfter(ListNode argNode) {
        if (argNode == null || argNode.next == null) return;
        ListNode nodeToDelete = argNode.next;
        argNode.next = nodeToDelete.next;
        if (nodeToDelete == tail) {
            tail = argNode;
        }
        nodeToDelete.next = null;
        size--;
    }

    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        tail = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void removeAllOccurrencesOf(int key) {
        while (head != null && head.value == key) {
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.value == key) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    public boolean isEqualTo(LinkedList arg) {
        if (this.size != arg.size) return false;

        ListNode thisCurrent = this.head;
        ListNode argCurrent = arg.head;

        while (thisCurrent != null) {
            if (thisCurrent.value != argCurrent.value) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            argCurrent = argCurrent.next;
        }
        return true;
    }

    public ListNode insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }

    public ListNode insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    public void deleteHead() {
        if (size == 0) {
            System.out.println("Cannot delete from an empty list");
        } else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            tmp = null;
            size--;
        }
    }

    public ListNode getNodeAt(int pos) {
        if (pos < 0 || pos >= size || size == 0) {
            System.out.println("No such position exists");
            return null;
        } else {
            ListNode tmp = head;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }
    }

    public void printList() {
        if (size == 0) {
            System.out.println("[]");
        } else {
            ListNode tmp = head;
            StringBuilder output = new StringBuilder("[");
            while (tmp != tail) {
                output.append(tmp.value).append(" -> ");
                tmp = tmp.next;
            }
            output.append(tail.value).append("]");
            System.out.println(output);
        }
    }

    public int getSize() {
        return size;
    }
}

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val) {
        value = val;
        next = null;
    }
}
