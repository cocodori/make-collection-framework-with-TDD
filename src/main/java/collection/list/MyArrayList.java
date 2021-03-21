package collection.list;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private T[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.data = (T[])new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T a) {
        checkCapacity();
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
        int resultIndex = isEquals(removeObject);
        if (resultIndex != -1) {
            realRemove(resultIndex);
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, size());
        realRemove(index);
    }

    public boolean contains(T findObject) {
        return isEquals(findObject) == -1 ? false : true;
    }

    private void realRemove(int index) {
        this.data[index] = null;
        dataShift(index);
    }

    private int isEquals(T targetObject) {
        for (int i = 0; i < this.data.length; i++) {
            if (targetObject.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyArrayList = [size = " + size() + ", data = " + Arrays.toString(this.data) + "]";
    }

    private void isEqualsRemove(T removeObject, int i) {
        if (removeObject.equals(this.data[i])) {
            this.data[i] = null;
            dataShift(i);
        }
    }

    private void dataShift(int i) {
        if (i != size--) {
            System.arraycopy(data, i +1, data, i, size());
            data[size] = null;
        }
    }

    private void checkCapacity() {
        if (data.length == size()) {
            T[] temp = (T[]) new Object[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
    }
}
