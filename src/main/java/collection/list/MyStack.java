package collection.list;

public class MyStack<T> {
    private T[] elements = (T[])new Object[10];
    private int size = 0;

    public T push(T element) {
        elements[size++] = element;
        return element;
    }

    public int size() {
        return size;
    }

    public T pop() {
        return elements[--size];
    }

    public T peek() {
        return elements[size-1];
    }
}
