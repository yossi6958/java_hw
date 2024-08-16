package Vector;

import java.util.Arrays;

public class Vector<T> {
    private final static int DEFAULT_GROWS_FACTOR = 2;
    private T[] array;
    private int index;
    private final int growsFactor;

    public Vector(int initialSize) throws RuntimeException {
        if (initialSize <= 0) {
            throw new RuntimeException("Invalid size");
        }
        this.array = (T[]) new Object[initialSize];
        this.index = 0;
        this.growsFactor = DEFAULT_GROWS_FACTOR;
    }

    public Vector(int initialSize, int growsFactor) throws RuntimeException {
        if (initialSize <= 0) {
            throw new RuntimeException("Invalid size");
        }

        if (growsFactor <= 1) {
            throw new RuntimeException("Invalid grows factor");
        }
        this.array =  (T[])  new Object[initialSize];
        this.index = 0;
        this.growsFactor = growsFactor;
    }

    public void add(T elem) {
        if (index == array.length) {
            this.array = Arrays.copyOf(this.array, this.growsFactor * this.array.length);
        }
        this.array[index++] = elem;
    }

    public T remove() throws RuntimeException {
        if (index <= 0) {
            throw new RuntimeException("Empty array");
        }
        if (array.length / growsFactor >= index) {
            this.array = Arrays.copyOf(array, array.length / growsFactor);
        }
        return array[--index];
    }

    public T get(int index){
        if (index >= this.index || index < 0) {
            throw new RuntimeException("Invalid index");
        }
        return array[index];
    }

    public void set(int index, T item){
        if (index >= this.index || index < 0) {
            throw new RuntimeException("Invalid index");
        }
        this.array[index] = item;
    }

    public int size(){
        return this.index;
    }

    public int capacity(){
        return this.array.length;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "array=" + Arrays.toString(array) +
                ", index=" + index +
                ", growsFactor=" + growsFactor +
                '}';
    }
}
