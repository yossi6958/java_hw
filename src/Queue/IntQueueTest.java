/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 3.7.24
    Description: Queue - Tests.
 =====================================================================================================*/
package Queue;

public class IntQueueTest {
    public static void main(String[] args) {

        System.out.println("Queue Test:\n===========");

        // Basic tests:
        // Test-case 1: Queue creation.
        IntQueue queue = new IntQueue(4);

        System.out.println("After Queue creation: ");
        queue.print();

        // Test-case 2: Adding elements.
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("After adding elements: ");
        queue.print();

        // Test-case 3: Delete elements.
        int item;
        item = queue.deQueue();
        System.out.println("The deleted element is: " + item);
        item = queue.deQueue();
        System.out.println("The deleted element is: " + item);
        System.out.println("After deleting elements: ");
        queue.print();

        // Test-case 4: Circular Queue.
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println("After adding elements: ");
        queue.print();

        // Error handling
        // 1) Wrong creation.
        try {
            IntQueue badQueue = new IntQueue(0);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 2) Delete item from empty queue.
        try {
            IntQueue emptyQueue = new IntQueue(5);
            emptyQueue.deQueue();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 3) Add item to a full queue.
        try {
            IntQueue fullQueue = new IntQueue(1);
            fullQueue.enQueue(1);
            fullQueue.enQueue(2);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
