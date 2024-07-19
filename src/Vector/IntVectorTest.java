package Vector;/*===================================================================================================
    Author: Yossi Kleiner.
    Creation date: 30.8.23
    Description: Dynamic vector - Tests.
 =====================================================================================================*/

public class IntVectorTest {
    public static void main(String[] args) {
        unitTests();
    }

    static void unitTests() {
        System.out.println("Vector Test:\n===========");

        // Basic tests:
        // Test-case 1: Vector creation.
        IntVector vec = new IntVector(5, 2);

        System.out.println("After vector creation: ");
        vec.print();

        // Test-case 2: Adding elements.
        vec.add(1);
        vec.add(2);
        vec.add(3);
        System.out.println("After adding elements: ");
        vec.print();

        // Test-case 3: Grows on demand.
        vec.add(4);
        vec.add(5);
        vec.add(6);
        System.out.println("After adding elements: ");
        vec.print();


        // Test-case 3: Delete elements.
        while (vec.getSize() > 0) {
            int num = vec.delete();
            System.out.println(num);
        }
        System.out.println("After deleting elements: ");
        vec.print();

        // Test-case 4: Set/Get accessors.
        vec.add(1);
        vec.add(2);
        vec.add(3);

        vec.set(0, 10);
        vec.set(2, 30);
        System.out.println("After changing elements: ");
        vec.print();

        // Error handling
        // 1) Wrong creation.
        try {
            IntVector badVector = new IntVector(0, 2);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 2) Delete item from empty vec.
        try {
            IntVector emptyVector = new IntVector(5, 2);
            emptyVector.delete();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 3) Set with wrong index.
        try {
            IntVector validVector = new IntVector(10, 3);
            validVector.set(0, 10);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 4) Get with wrong index.
        try {
            IntVector validVector = new IntVector(5, 3);
            validVector.get(0);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
