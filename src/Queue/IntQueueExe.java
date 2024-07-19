/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 3.7.24
    Description: Queue - Exes.
 =====================================================================================================*/

package Queue;

public class IntQueueExe {
    public static void main(String[] args) {
        queueNumOfItemsTest();
        queueSumOfItemsTest();
        queueRemoveFirstInstanceTest();

    }

    public static int queueNumOfItems(IntQueue intQueue) {

        IntQueue otherQueue = new IntQueue(intQueue.getCapacity());
        int numOfItems = 0;

        while (!intQueue.isEmpty()) {
            otherQueue.enQueue(intQueue.deQueue());
            numOfItems++;
        }

        while (!otherQueue.isEmpty()) {
            intQueue.enQueue(otherQueue.deQueue());
        }
        return numOfItems;
    }

    public static void queueNumOfItemsTest() {
        System.out.println("numOfItems Queue test:");
        IntQueue intQueue = new IntQueue(10);
        intQueue.enQueue(4);
        System.out.println(queueNumOfItems(intQueue));
        intQueue.enQueue(3);
        System.out.println(queueNumOfItems(intQueue));
        intQueue.deQueue();
        intQueue.deQueue();
        System.out.println(queueNumOfItems(intQueue));
    }

    public static int queueSumOfItems(IntQueue intQueue) {
        IntQueue otherQueue = new IntQueue(intQueue.getCapacity());
        int sumOfItems = 0;

        while (!intQueue.isEmpty()) {
            int top = intQueue.deQueue();
            sumOfItems += top;
            otherQueue.enQueue(top);
        }

        while (!otherQueue.isEmpty()) {
            intQueue.enQueue(otherQueue.deQueue());
        }
        return sumOfItems;
    }

    public static void queueSumOfItemsTest() {
        System.out.println("Sum Queue test:");
        IntQueue intQueue = new IntQueue(10);
        intQueue.enQueue(4);
        System.out.println(queueSumOfItems(intQueue));
        intQueue.enQueue(3);
        System.out.println(queueSumOfItems(intQueue));
        intQueue.deQueue();
        intQueue.deQueue();
        System.out.println(queueNumOfItems(intQueue));
    }

    public static int queueRemoveFirstInstance(IntQueue intQueue, int item) {
        IntQueue otherQueue = new IntQueue(intQueue.getCapacity());
        int currIndex = 0;
        int itemIndex = -1;
        boolean foundItem = false;

        while (!intQueue.isEmpty()) {
            otherQueue.enQueue(intQueue.deQueue());
        }

        while (!otherQueue.isEmpty()) {
            int top = otherQueue.deQueue();
            if (top == item && !foundItem) {
                itemIndex = currIndex;
            } else {
                currIndex++;
                intQueue.enQueue(top);
            }
        }
        return itemIndex;
    }

    public static void queueRemoveFirstInstanceTest() {
        System.out.println("Remove item Queue test:");
        IntQueue intQueue = new IntQueue(10);
        intQueue.enQueue(4);
        System.out.println(queueRemoveFirstInstance(intQueue, 4));
        intQueue.enQueue(3);
        intQueue.enQueue(3);
        intQueue.enQueue(5);
        intQueue.enQueue(3);
        System.out.println(queueRemoveFirstInstance(intQueue, 4));
        System.out.println(queueRemoveFirstInstance(intQueue, 3));
        System.out.println(queueRemoveFirstInstance(intQueue, 3));
        System.out.println(queueRemoveFirstInstance(intQueue, 5));
    }

}
