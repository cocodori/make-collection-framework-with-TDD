package collection.list;

public class MyArrayList<T> {
    private T[] data;
    private int size;

    public MyArrayList() {
        this.data = (T[])new Object[10];
        this.size = 0;
    }

    public void add(T a) {
        this.data[size++] = a;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        return this.data[index];
    }

    public boolean isEmpty() {
        return false;
    }
}
