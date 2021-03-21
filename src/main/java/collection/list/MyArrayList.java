package collection.list;

import java.util.Arrays;
import java.util.Objects;

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
        return this.size == 0;
    }

    /*
     *   1. 일치하는 데이터가 있다면 삭제한다.
     *   2. size를 -1한다.
     *   3. 삭제된 데이터가 마지막 데이터가 아니라면
     *       데이터를 삭제된 위치부터 한 칸씩 왼쪽으로 이동해야 한다.
     *   4. 마지막 데이터는 지운다.
     * */
    public void remove(T removeObject) {
        removeObject(removeObject);
    }


    public void remove(int index) {
        checkIndex(index);
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, size());
        this.data[index] = null;
        size--;
        dataShift(index);
    }

    private void removeObject(T removeObject) {
        for (int i = 0; i < this.data.length; i++) {
            realRemove(removeObject, i);
        }
    }

    private void realRemove(T removeObject, int i) {
        if (removeObject.equals(this.data[i])) {
            this.data[i] = null;
            size--;
            dataShift(i);
        }
    }

    private void dataShift(int i) {
        if (i != size) {
            System.arraycopy(data, i +1, data, i, size());
            data[size] = null;
        }
    }

    @Override
    public String toString() {
        return "MyArrayList = [size = " + size() + ", data = " + Arrays.toString(this.data) + "]";
    }

}
