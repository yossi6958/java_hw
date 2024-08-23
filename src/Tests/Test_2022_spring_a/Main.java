package Tests.Test_2022_spring_a;


import Node.Node;
import Stack.Stack;

public class Main {
    public static void main(String[] args) {
        q2();
    }

    // Q2
    public static void orderStackByAverage(Stack<Integer> stack) {
        int stackSize = stack.getSize();
        Stack<Integer> tmp1 = new Stack<Integer>(stackSize);
        Stack<Integer> tmp2 = new Stack<Integer>(stackSize);
        int sum = 0;
        while (!stack.isEmpty()) {
            int currValue = stack.pop();
            sum += currValue;
            tmp1.push(currValue);
        }

        double average = (double) sum / stackSize;
        while (!tmp1.isEmpty()) {
            int currValue = tmp1.pop();
            if (currValue <= average) {
                stack.push(currValue);
            } else {
                tmp2.push(currValue);
            }
        }

        while (!tmp2.isEmpty()) {
            stack.push(tmp2.pop());
        }
    }

    public static void q2() {
        Stack<Integer> stack = new Stack<Integer>(5);
        stack.push(5);
        stack.push(7);
        stack.push(100);
        stack.push(1);
        stack.push(9);
        System.out.println(stack);
        orderStackByAverage(stack);
        System.out.println(stack);
    }

    // Q6 - A
    public static Node<Double> getAverages(Node<Integer> grades) {
        Node<Integer> currentGrade = grades;
        Node<Double> resRoot = null;
        Node<Double> resNode = null;
        int currentCount = 0;
        int currentSum = 0;

        while (currentGrade != null) {
            if (currentGrade.getValue() != -1) {
                // Accumulate sum and count for valid grades
                currentSum += currentGrade.getValue();
                currentCount++;
            } else if (currentCount > 0) {
                // End of a segment, calculate average and create new node
                double average = (double) currentSum / currentCount;
                Node<Double> nodeToAdd = new Node<>(average);
                if (resRoot == null) {
                    resRoot = nodeToAdd;
                } else {
                    resNode.setNext(nodeToAdd);
                }
                resNode = nodeToAdd;

                // Reset counters for the next segment
                currentSum = 0;
                currentCount = 0;
            }
            currentGrade = currentGrade.getNext();
        }
        return resRoot;
    }


    public static void Q6() {
        Node<Integer> lst = new Node<>(80,
                new Node<>(40,
                        new Node<>(90,
                                new Node<>(-1,
                                        new Node<>(95,
                                                new Node<>(-1,
                                                        new Node<>(85,
                                                                new Node<>(80,
                                                                        new Node<>(-1)))))))));

//        System.out.println(getAverages(lst));
        print(lst);
    }

    // Q6 - B
    public static void print(Node<Integer> lst) {
        // Get averages
        Node<Double> averageNodes = getAverages(lst);

        // Prepare to compute adjusted averages
        Node<Integer> currentGrade = lst;
        Node<Double> adjustedAverages = null;
        Node<Double> lastAdjustedNode = null;
        int currentCount = 0;
        int currentSum = 0;
        int minGrade = Integer.MAX_VALUE;

        // Traverse the original list to compute adjusted averages
        while (currentGrade != null) {
            int currValue = currentGrade.getValue();
            if (currValue != -1) {
                currentSum += currValue;
                currentCount++;
                if (currValue < minGrade) {
                    minGrade = currValue;
                }
            } else if (currentCount > 0) {
                double adjustedAverage = (currentCount == 1)
                        ? (double) currentSum
                        : (double) (currentSum - minGrade) / (currentCount - 1);

                Node<Double> newAdjustedNode = new Node<>(adjustedAverage);
                if (adjustedAverages == null) {
                    adjustedAverages = newAdjustedNode;
                } else {
                    lastAdjustedNode.setNext(newAdjustedNode);
                }
                lastAdjustedNode = newAdjustedNode;

                // Reset for the next segment
                currentSum = 0;
                currentCount = 0;
                minGrade = Integer.MAX_VALUE;
            }
            currentGrade = currentGrade.getNext();
        }

        // Print the results
        int index = 1;
        while (averageNodes != null && adjustedAverages != null) {
            System.out.println(index + " " + averageNodes.getValue() + " " + adjustedAverages.getValue());
            averageNodes = averageNodes.getNext();
            adjustedAverages = adjustedAverages.getNext();
            index++;
        }
    }

// Q7
//    void maximum() {
//        move(0, 1);
//        while (!isEmpty(0)) {
//            if (bigOrEqual(0, 1)) {
//                move(1, 2);
//                move(0, 1);
//            } else {
//                move(0, 1);
//                move(1, 2);
//            }
//        }
//        while (!isEmpty(2)) {
//            move(2, 0);
//        }
//    }
//
//    void sort() {
//        while (!isEmpty(1)) {
//            move(1, 2);
//        }
//        while (!isEmpty(2)) {
//            move(2, 0);
//        }
//        while (!isEmpty(0)) {
//            maximum();
//        }
//    }
// Complexity = maximum -> N, sort -> N^2


    // Q8
    // Mystery(a) ->
    //      a.getValue() -> "a" -> Mystery(a.getLeft() -> b) ->
    //          b.getValue() -> "b" -> Mystery(b.left() -> null) -> null ->
    //          b.getValue() -> "b" -> Mystery(b.getRight() -> d) ->
    //              d.getValue() -> "d" -> Mystery(d.getLeft() -> null) -> null ->
    //              d.getValue() -> "d" -> null(d.getRight() -> null) -> null ->
    //              d.getValue() -> "d" ->
    //          b.getValue() -> "b" ->
    //    a.getValue() -> "a" -> Mystery(a.getRight() -> c) ->
    //          c.getValue() -> "c" -> Mystery(c.getLeft() -> e) ->
    //              e.getValue() -> "e" -> Mystery(e.getLeft() -> f) ->
    //                  f.getValue() -> "f" -> Mystery(f.getLeft() -> null) -> null ->
    //                  f.getValue() -> "f" -> Mystery(f.getRight() -> null) -> null ->
    //                  f.getValue() -> "f" ->
    //              e.getValue() -> "e" -> Mystery(e.getRight() -> null) -> null ->
    //              e.getValue() -> "e" ->
    //          c.getValue() -> "c" -> Mystery(c.getRight() -> null) -> null ->
    //          c.getValue() -> "c" ->
    //   a.getValue() -> "a"


    // "a b b d d d b a c e f f f e e c c a"

}
