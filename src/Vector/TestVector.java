package Vector;

public class TestVector {
    public static void main(String[] args) {

        // Test vector initialization default constructor
        System.out.println("vector initialization: ");
        Vector<Integer> v = new Vector<Integer>(2);
        System.out.println(v + "\n\n");

        // Test add()
        v.add(2);
        v.add(20);
        v.add(-15);
        System.out.println("Vector after adding 3 items: ");
        System.out.println(v + "\n\n");

        // Testing get
        int i = 2;
        System.out.println("Testing get: ");
        System.out.println("v.get(" + i + "): " + v.get(i));
        System.out.println();

        // Testing set
        System.out.println("Testing set: ");
        v.set(i, 50);
        System.out.println("v.set(" + i + ", 50)");
        System.out.println(v + "\n\n");

        // Test remove()
        System.out.println("Before removed item, v.size(): " + v.size());
        System.out.println("Removed item: " + v.remove());

        while (v.size() > 0) {
            System.out.println("Removed item: " + v.remove());
        }

        System.out.println("After removed items, v.size(): " + v.size());
        System.out.println(v + "\n\n");

        // Test vector initialization with grows factor
        System.out.println("Test vector initialization with grows factor");
        Vector<Integer> v2 = new Vector<Integer>(2, 3);
        System.out.println(v2);

        int ogCapaxity = v2.capacity();
        for (i = 1; i <= 3; i++) {
            v2.add(i);
        }
        System.out.println(v2.toString());
        System.out.println();

        // Test remove() Exception
        try {
            System.out.println("Test remove() Exception: ");
            v.remove();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        // Test get() Exception
        try {
            System.out.print("Test get() out of bound Exception: ");
            v.get(10);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        // Test get() Exception
        try {
            System.out.print("Test get(-1) Exception: ");
            System.out.println(v.get(-1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        // Test initial size error
        try {
            System.out.print("Test initial size error: ");
            Vector<Integer> vError = new Vector<Integer>(-1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }

        // Test weird grow factor
        try {
            System.out.print("Test weird grow factor: ");
            Vector<Integer> vError = new Vector<Integer>(10, 0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }


    }
}
