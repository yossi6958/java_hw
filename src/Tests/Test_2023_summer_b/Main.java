package Tests.Test_2023_summer_b;


import Node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        testSplit();
    }

    // Q1
    public static boolean strangers(int num1, int num2) {
        while (num2 > 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1 == 1;
    }


    public static void change(Queue<Integer> q, int num) {
        Queue<Integer> stranger = new LinkedList<>();
        Queue<Integer> notStranger = new LinkedList<>();
        while (!q.isEmpty()) {
            int currValue = q.remove();
            if (strangers(num, currValue)) {
                stranger.add(currValue);
            } else {
                notStranger.add(currValue);
            }
        }

        while (!stranger.isEmpty()) {
            q.add(stranger.remove());
        }

        while (!notStranger.isEmpty()) {
            q.add(notStranger.remove());
        }

    }

    public static void testChange() {
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(10);
        q.add(12);
        q.add(3);
        q.add(7);
        q.add(4);
        q.add(1);
        System.out.println(q);
        change(q, 9);
        System.out.println(q);
    }

    // Q2

    public static Node<Integer> split(Node<Integer> chain) {
        if (chain == null) {
            return null;
        }

        boolean isFirstNodeOdd = chain.getValue() % 2 != 0;

        Node<Integer> differentParityChain = null;
        Node<Integer> differentParityChainRoot = null;

        Node<Integer> prev = null;
        Node<Integer> current = chain;

        while (current != null) {
            Node<Integer> next = current.getNext();

            boolean isCurrentOdd = current.getValue() % 2 != 0;
            if (isCurrentOdd != isFirstNodeOdd) {
                if (differentParityChain == null) {
                    differentParityChain = differentParityChainRoot = new Node<>(current.getValue());
                } else {
                    differentParityChain.setNext(new Node<>(current.getValue()));
                    differentParityChain = differentParityChain.getNext();
                }

                if (prev != null) {
                    prev.setNext(next);
                }
            } else {
                prev = current;
            }

            current = next;
        }

        return differentParityChainRoot;
    }


    public static void testSplit() {
        Node<Integer> chain = new Node<>(10,
                new Node<>(20,
                        new Node<>(5,
                                new Node<>(7,
                                        new Node<>(8,
                                                new Node<>(4,
                                                        new Node<>(6,
                                                                new Node<>(11,
                                                                        new Node<>(7)))))))));

        Node<Integer> newChain = split(chain);
        System.out.println(chain);
        System.out.println(newChain);
    }

}
