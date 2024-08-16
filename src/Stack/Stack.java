package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private final static int GROWS_SIZE = 2;
    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.items = (T[]) new Object[size];
        count = 0;
    }

    public T push(T item) {
        if (count == items.length) {
            items = Arrays.copyOf(items, count + GROWS_SIZE);
        }
        items[count++] = item;
        return item;
    }

    public T pop() throws EmptyStackException {
        if (count <= 0) throw new EmptyStackException();

        T item = items[--count];
        items[count] = null;

        return item;
    }

    public T peek() throws EmptyStackException {
        if (count <= 0) throw new EmptyStackException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "items=" + Arrays.toString(items) +
                ", count=" + count +
                '}';
    }
}
