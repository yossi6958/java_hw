package Vector;

/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 30.8.23
    Description: Dynamic vector - sequence of generic elements, direct access, grows on demand.
                 Index range: 0..N-1
 =====================================================================================================*/
public class IntVector {
    private int[] items;
    private final int originalSize;
    private final int blockSize;
    private int numOfItems;

    private static final int GROWS_ON_DEMAND = 2;

    //creating a constructor of the class that initializes the values
    public IntVector(int originalSize, int blockSize) {
        if (originalSize <= 0 || blockSize < 0) {
            throw new RuntimeException("Error: Bad argument.");
        }
        this.items = new int[originalSize];
        this.originalSize = originalSize;
        this.blockSize = blockSize;
        this.numOfItems = 0;
    }

    public void add(int item) throws RuntimeException {
        if (numOfItems == items.length) {
            if (blockSize == 0) {
                throw new RuntimeException("Error: Overflow.");
            }
            int[] newArray = new int[items.length + blockSize];
            System.arraycopy(items, 0, newArray, 0, numOfItems);
            items = newArray;
        }
        items[numOfItems] = item;
        ++numOfItems;
    }

    public int delete() throws RuntimeException {
        if (numOfItems == 0) {
            throw new RuntimeException("Error: Underflow.");
        }
        if ((items.length > originalSize) &&
                (numOfItems <= items.length - (blockSize * GROWS_ON_DEMAND))) {
            int[] newArray = new int[items.length - blockSize];
            System.arraycopy(items, 0, newArray, 0, numOfItems);
            items = newArray;
        }
        return items[--numOfItems];
    }

    public void set(int reqIndex, int item) throws RuntimeException {
        if (reqIndex >= numOfItems || reqIndex < 0)
            throw new RuntimeException("Error: Wrong index.");

        items[reqIndex] = item;
    }

    public int get(int reqIndex) throws RuntimeException {
        if (reqIndex >= numOfItems || reqIndex < 0)
            throw new RuntimeException("Error: Wrong index.");

        return items[reqIndex];

    }

    public int getCapacity() {
        return items.length;
    }

    public int getSize() {
        return numOfItems;
    }

    public void print() {
        System.out.println("-----------------------------------------------");
        System.out.println("Vector details> Capacity: " + items.length + ", Size: " + numOfItems);
        System.out.print("Vector Items>    ");
        if (numOfItems > 0) {
            for (int i = 0; i < numOfItems; ++i) {
                System.out.print(items[i] + " ");
            }
        } else {
            System.out.print("No items");
        }
        System.out.println("\n-----------------------------------------------");
    }
}