package Queue;

public class TestQueue {
    public static void main(String[] args) {
        // Test initialization
        Queue<Integer> q = new Queue<Integer>(4);
        System.out.println(q);

        // Test adding items
        q.add(1);
        q.add(2);
        System.out.println(q);

        // Test full queue
        q.add(3);
        q.add(4);
        System.out.println(q);

        //Test remove
        System.out.println("q.remove(): " + q.remove());
        System.out.println(q);

        // Test rewriting free space
        q.add(10);
        System.out.println(q);

        // Test is empty
        while (!q.isEmpty()) {
            System.out.println("q.remove(): " + q.remove());
        }
        System.out.println(q);

        // Test empty stack exception
        try {
            q.remove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Test full queue exception
        try {
            q.add(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
