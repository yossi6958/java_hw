package Tests.Test_2021_summer_b;

import Node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        testLevelNQueue();
        testIsLevelNQueue();
    }

    // Q1
    public static Queue<Integer> levelNQueue(int num) {
        Queue<Integer> queueN = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                queueN.add(i);
            }
        }
        return queueN;
    }

    public static void testLevelNQueue() {
        System.out.println(levelNQueue(5));
    }

    public static boolean isLevelNQueue(Queue<Integer> queue, int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                if (queue.isEmpty() || queue.remove() != i) {
                    return false;
                }
            }
        }

        return queue.isEmpty();
    }

    public static void testIsLevelNQueue() {
        Queue<Integer> sequence = new LinkedList<>();
        sequence.add(1);
        sequence.add(2);
        sequence.add(2);
        sequence.add(3);
        sequence.add(3);
        sequence.add(3);
        sequence.add(4);
        sequence.add(4);
        sequence.add(4);


        System.out.println(isLevelNQueue(sequence, 4));
    }

    // Q2
    public static boolean isSumList(Node<Integer> head) {
        Node<Integer> currentNode = head;
        int listSum = currentNode.getValue();

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            if (currentNode.getValue() != listSum) {
                return false;
            }

            listSum += currentNode.getValue();
        }
        return true;
    }

}
