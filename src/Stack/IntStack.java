/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 1.7.24
    Description: Stack - Sequence of elements (1..n), Grows & Reduce on demand,LIFO.
 =====================================================================================================*/
package Stack;

import Vector.IntVector;

public class IntStack {
    private final IntVector vector;

    public IntStack(int originalSize, int blockSize) {
        vector = new IntVector(originalSize, blockSize);
    }

    public void push(int item) {
        vector.add(item);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Stack is empty.");
        }
        return vector.delete();
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Stack is empty.");
        }
        return vector.get(vector.getSize() - 1);
    }

    public boolean isEmpty() {
        return vector.getSize() == 0;
    }

    public int getSize() {
        return vector.getSize();
    }

    public void print() {
        vector.print();
    }

}
