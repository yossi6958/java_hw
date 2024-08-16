package Queue;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Queue<T> {
    private T[] items;
    private int start, end, count;

    public Queue(int size) {
        this.items = (T[]) new Object[size];
        start = end = count = 0;
    }

    public void add(T item) {
        if (end == start && count == items.length) {
            throw new RuntimeException("Error: Queue is full");
        }
        items[end++] = item;
        end %= items.length;
        count++;
    }

    public T remove() {
        if (count == 0) {
            throw new RuntimeException("Error: empty queue");
        }
        count--;
        T item = items[start++];
        items[start - 1] = null;
        start %= items.length;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void printQueue() {
        String res = "[";
        if (start >= end) {
            for (int i = start; i < items.length; i++) {
                res += items[i];
                if (i != items.length - 1) res += ",";
            }
            for (int i = 0; i < end; i++) {
                res += "," + items[i];
//                if (i != end - 1) res += ;
            }
        } else {
            for (int i = start; i < end; i++) {
                res += items[i];
                if (i != end - 1) res += ",";
            }
        }
        res += "]";
        System.out.println(res);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "items=" + Arrays.toString(items) +
                ", start=" + start +
                ", end=" + end +
                ", count=" + count +
                '}';
    }
}
