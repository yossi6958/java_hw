/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 24.7.24
    Description: Generic Singly Linked List - Test.
 =====================================================================================================*/


package GenericSinglyLL;

public class GenericSinglyLLTest {
    public static void main(String[] args) {
        GenericSinglyLL<Integer> list = new GenericSinglyLL<Integer>();

        // Test listPushHead and toString
        list.listPushHead(3);
        list.listPushHead(2);
        list.listPushHead(1);
        System.out.println("After pushing to head: " + list);

        // Test listPushTail
        list.listPushTail(4);
        list.listPushTail(5);
        System.out.println("After pushing to tail: " + list);

        // Test listIsEmpty
        System.out.println("Is list empty? " + list.listIsEmpty());

        // Test listCountItems
        System.out.println("Number of items in the list: " + list.listCountItems());

        // Test listPopHead
        System.out.println("Popped from head: " + list.listPopHead());
        System.out.println("After popping from head: " + list);

        // Test listPopTail
        System.out.println("Popped from tail: " + list.listPopTail());
        System.out.println("After popping from tail: " + list);

        // Test listPushAt
        list.listPushAt(1, 6);
        System.out.println("After pushing at index 1: " + list);

        // Test listPopAt
        System.out.println("Popped from index 1: " + list.listPopAt(1));
        System.out.println("After popping from index 1: " + list);

        // Test listFind
        System.out.println("Index of item 3: " + list.listFind(3));
        System.out.println("Index of item 10: " + list.listFind(10));

        // Test listGetNode
        System.out.println("Node at index 1: " + list.listGetNode(1).getValue());

        // Test listAppend
        GenericSinglyLL<Integer> list2 = new GenericSinglyLL<Integer>();
        list2.listPushTail(7);
        list2.listPushTail(8);
        list.listAppend(list2);
        System.out.println("After appending list2: " + list);

        // Test iterativeReverse
        list.listReverse("iterative");
        System.out.println("After iterative reverse: " + list);

        // Test recursiveReverse
        list.listReverse("recursive");
        System.out.println("After recursive reverse: " + list);

        // Test listClear
        list.listClear();
        System.out.println("After clearing the list: " + list);
        System.out.println("Is list empty? " + list.listIsEmpty());
    }
}
