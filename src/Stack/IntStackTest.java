/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 1.7.24
    Description: Stack - Tests.
 =====================================================================================================*/
package Stack;

public class IntStackTest {
    public static void main(String[] args) {
        System.out.println("Stack.IntStack Test:\n==============");

        // Basic tests:
        // Test-case 1: Stack creation.
        IntStack stack = new IntStack(5, 2);

        System.out.println("After stack creation: ");
        stack.print();

        // Test-case 2: Pushing elements.
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("After pushing elements: ");
        stack.print();

        // Test-case 3: Popping elements.
        System.out.println("Popped: " + stack.pop());
        System.out.println("After popping an element: ");
        stack.print();

        // Test-case 4: Top element.
        System.out.println("Top: " + stack.top());
        System.out.println("After using top: ");
        stack.print();

        // Error handling
        // 1) Pop from empty stack.
        try {
            IntStack emptyStack = new IntStack(5, 2);
            emptyStack.pop();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        // 2) Top from empty stack.
        try {
            IntStack emptyStack = new IntStack(5, 2);
            emptyStack.top();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        // Additional tests:
        // Test-case 5: Pushing more elements to test resizing.
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("After pushing more elements: ");
        stack.print();

        // Test-case 6: Checking stack size.
        System.out.println("Stack size: " + stack.getSize());

        // Test-case 7: Clearing the stack.
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("After clearing the stack: ");
        stack.print();
    }
}
