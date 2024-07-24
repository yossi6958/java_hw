/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 24.7.24
    Description: Generic Singly Linked List.
 =====================================================================================================*/

package GenericSinglyLL;

public class GenericSinglyLL<T> {
    public class Node {
        private T value;
        private Node next;

        public Node(T item) {
            value = item;
            next = null;
        }

        public Node(T item, Node nextNode) {
            this.value = item;
            this.next = nextNode;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private Node tail;

    public GenericSinglyLL() {
        head = tail = null;
    }

    public void listPushHead(T item) {
        if (head == null) {
            head = tail = new Node(item);
        } else {
            head = new Node(item, head);
        }
    }

    public void listPushTail(T item) {
        if (head == null) {
            head = tail = new Node(item);
        } else {
            tail = tail.next = new Node(item);
        }
    }

    public boolean listIsEmpty() {
        return head == null;
    }

    public void listClear() {
        head = tail = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value.toString());
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public int listCountItems() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public T listPopHead() {
        if (listIsEmpty()) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public T listPopTail() {
        if (listIsEmpty()) {
            return null;
        }
        if (head == tail) {
            T value = tail.value;
            head = tail = null;
            return value;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T value = tail.value;
        tail = current;
        tail.next = null;
        return value;
    }

    public void listPushAt(int index, T item) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            listPushHead(item);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }
        if (current == tail) {
            listPushTail(item);
        } else {
            current.next = new Node(item, current.next);
        }
    }

    public T listPopAt(int index) {
        if (index < 0 || listIsEmpty()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return listPopHead();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }
        if (current.next == tail) {
            return listPopTail();
        }
        T value = current.next.value;
        current.next = current.next.next;
        return value;
    }

    public int listFind(T item) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Item not found
    }

    public Node listGetNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }
        return current;
    }

    public void listAppend(GenericSinglyLL<T> appendedList) {
        if (appendedList.listIsEmpty()) {
            return;
        }
        if (this.listIsEmpty()) {
            this.head = appendedList.head;
        } else {
            this.tail.next = appendedList.head;
        }
        this.tail = appendedList.tail;
    }

    private void iterativeReverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    private Node recursiveReverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = recursiveReverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public void listReverse(String mode) {
        if (mode.equals("iterative")) {
            iterativeReverse();
        } else if (mode.equals("recursive")) {
            head = recursiveReverse(head);
            // Update tail reference
            Node current = head;
            while (current != null && current.next != null) {
                current = current.next;
            }
            tail = current;
        } else {
            throw new IllegalArgumentException("Mode must be either 'iterative' or 'recursive'");
        }
    }
}
