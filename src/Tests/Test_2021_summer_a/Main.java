package Tests.Test_2021_summer_a;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        testGetMoreThanTwiceQueue();
    }


    //Q2
    public static Queue<Integer> filterRepeatingElements(Queue<Integer> q) {
        // Temporary queues for processing
        Queue<Integer> tempQueue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        Queue<Integer> resultQueue = new LinkedList<>();

        // First pass: Count occurrences
        while (!q.isEmpty()) {
            int element = q.poll();
            tempQueue.add(element);
            countQueue.add(element);
        }

        // Second pass: Collect elements with occurrences more than 2
        while (!tempQueue.isEmpty()) {
            int element = tempQueue.poll();
            int count = 0;

            // Count occurrences in the countQueue
            Queue<Integer> tempCountQueue = new LinkedList<>();
            while (!countQueue.isEmpty()) {
                int countElement = countQueue.poll();
                if (countElement == element) {
                    count++;
                }
                tempCountQueue.add(countElement);
            }
            countQueue = tempCountQueue; // Restore original countQueue

            // If the element appears more than twice and not already in resultQueue, add it
            if (count > 2 && !resultQueue.contains(element)) {
                resultQueue.add(element);
            }
        }

        return resultQueue;
    }

    public static void testFilterRepeatingElements(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int[] nums = {2, 5, 5, 7, 2, 4, 1, 3, 2, 5, 5, 1};
        for (int num : nums) {
            q.add(num);
        }

        Queue<Integer> result = filterRepeatingElements(q);

        // Print the resulting queue
        while (!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
    }

    public static Queue<Integer> getMoreThanTwiceQueue(Queue<Integer> queue) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        while (!queue.isEmpty()) {
            int currentValue = queue.remove();
            if (numCount.containsKey(currentValue)) {
                numCount.put(currentValue, numCount.get(currentValue) + 1);
            } else {
                numCount.put(currentValue, 1);
            }
        }

        Queue<Integer> resQueue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > 2) {
                resQueue.add(entry.getKey());
            }
        }

        return resQueue;
    }

    public static void testGetMoreThanTwiceQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(3);
        queue.add(3);
        queue.add(3);
        queue.add(4);
        queue.add(4);
        queue.add(4);
        queue.add(4);

        Queue<Integer> resultQueue = getMoreThanTwiceQueue(queue);


        System.out.println("Elements that appear more than twice:");
        while (!resultQueue.isEmpty()) {
            System.out.println(resultQueue.remove());
        }

    }

}
