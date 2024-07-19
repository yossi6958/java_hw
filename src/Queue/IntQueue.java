/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 3.7.24
    Description: Queue - Sequence of elements (1..n), FIFO, Reuse memory (circular queue).
 =====================================================================================================*/
package Queue;

public class IntQueue {
    private final int[] items;
    private int nItems;
    private int head;
    private int tail;


    public IntQueue(int size) {
        if (size <= 0) {
            throw new RuntimeException("Error: Bad argument.");
        }
        this.items = new int[size];
        this.nItems = 0;
        this.head = 0;
        this.tail = 0;

    }

    public void enQueue(int item) {
        if (nItems == items.length) {
            throw new RuntimeException("Error: Overflow.");
        }
        items[tail] = item;
        ++nItems;
        tail = ++tail % items.length;
    }

    public int deQueue() {
        if (nItems == 0) {
            throw new RuntimeException("Error: Underflow.");
        }
        int item = items[head];
        --nItems;
        head = ++head % items.length;
        return item;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public int getCapacity() {
        return items.length;
    }

    public int getSize() {
        return nItems;
    }

    public void print() {
        System.out.println("-----------------------------------------------");
        System.out.println("Queue details> Capacity: " + items.length + ", Size: " + nItems);
        System.out.print("Queue Items>    ");
        if (nItems > 0) {
            for (int i = 0, index = head; i < nItems; ++i, ++index) {
                if (index == items.length) {
                    index = 0;
                }
                System.out.print(items[index] + " ");
            }
        } else {
            System.out.print("No items");
        }
        System.out.println("\n-----------------------------------------------");
    }
}
