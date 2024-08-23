package Tests.Test_2022_summer_a;


import Node.Node;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        q2();
    }

    // Q1
    public static Node<Integer> getDifferenceList(Node<Integer> list) {
        if (list == null) {
            return null;
        }


        Node<Integer> differenceList = new Node<>(0);
        Node<Integer> differenceListRoot = differenceList;

        while (list.getNext() != null) {
            int currentDiff = Math.abs(list.getValue() - list.getNext().getValue());
            differenceList.setNext(new Node<>(currentDiff));
            differenceList = differenceList.getNext();
            list = list.getNext();

        }
        return differenceListRoot.getNext();
    }

    public static int theSurvives(Node<Integer> list) {
        if (list.getNext() == null) {
            return list.getValue();
        }
        System.out.println(list);
        return theSurvives(getDifferenceList(list));
    }


    public static void q1() {
        Node<Integer> lst = new Node<>(5,
                new Node<>(20,
                        new Node<>(9,
                                new Node<>(6,
                                        new Node<>(5,
                                                new Node<>(8,
                                                        new Node<>(2
                                                        )))))));

        System.out.println(theSurvives(lst));
        ;
    }

    // Q2

    public static boolean biggerSum(Stack<Integer> stack) {
        int sum = stack.pop();
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            int currentValue = stack.pop();
            if (currentValue <= sum) {
                return false;
            }
            tmp.push(currentValue);
            sum += currentValue;
        }

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        return true;
    }

    public static void q2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(15000);
        stack.push(1200);
        stack.push(15);
        stack.push(3);
        stack.push(11);
        System.out.println(biggerSum(stack));
    }
}
