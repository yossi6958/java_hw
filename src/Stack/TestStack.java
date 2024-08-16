package Stack;

import javax.swing.*;

public class TestStack {
    public static void main(String[] args) {
        System.out.println("\n********Checking stack for int********\n");

        System.out.println("Initialization:");
        Stack<Integer> sInt = new Stack<Integer>(4);
        System.out.println(sInt + "\n");
        System.out.println("Push int to sInt: " + sInt.push(5));
        System.out.println("\nStack after adding int: \n" + sInt + "\n");

        System.out.println("Pop int from sInt: " + sInt.pop());
        System.out.println("\nStack after removing int: \n" + sInt);

        System.out.println("\nTest growing:");
        System.out.println("sInt.push(6): " + sInt.push(6));
        System.out.println(sInt);

        System.out.println("\nTest peek():");
        System.out.println("sInt.peek(): " + sInt.peek());

        System.out.println("\nPop int from sInt: " + sInt.pop());
        System.out.println("Stack after removing int: \n" + sInt + "\n\n");


        System.out.println("\n********Checking stack for String********\n");

        System.out.println("Initialization:");
        Stack<String> sString = new Stack<String>(4);
        System.out.println(sString + "\n");
        System.out.println("Push String to sString: " + sString.push("first"));
        System.out.println("\nStack after adding int: \n" + sString + "\n");

        System.out.println("Pop int from String: " + sString.pop());
        System.out.println("\nStack after removing int: \n" + sString);

        System.out.println("\nTest growing:");
        System.out.println("String.push(): " + sString.push("Hello"));
        System.out.println(sString);

        System.out.println("\nTest peek():");
        System.out.println("String.peek(): " + sString.peek());

        System.out.println("\npop String from String: " + sString.pop());
        System.out.println("Stack after removing String: \n" + sString + "\n\n");


    }
}
