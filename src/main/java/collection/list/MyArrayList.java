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

    @Override
    public String toString() {
        return "MyArrayList = [size = " + size() + ", data = " + Arrays.toString(this.data) + "]";
    }

    public void add(T a) {
        checkCapacity();
        this.data[size++] = a;
    }

    /*
     *   1. 유효한 index인지
     *   2. 마지막 인덱스라면 그냥 추가
     *   3. 아니라면 뒤로 한 칸씩 미루고 그 자리에 추가
     * */
    public void add(int index, T data) {
        Objects.checkIndex(index, this.data.length);

        if (index >= size++) {
            this.data[index] = data;
            return;
        }

        shift(index, index+1);
        this.data[index] = data;
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
        Objects.checkIndex(index, this.data.length);
        realRemove(index);
    }

    public boolean contains(T findObject) {
        return isEquals(findObject) == -1 ? false : true;
    }

    private void realRemove(int index) {
        this.data[index] = null;

        if (index != this.size) {
            shift(index + 1, index);
            data[size--] = null;
        }
    }

    private int isEquals(T targetObject) {
        for (int i = 0; i < this.data.length; i++) {
            if (targetObject.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    private void checkCapacity() {
        if (data.length == size()) {
            T[] temp = (T[]) new Object[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
    }

    private void shift(int from, int to) {
        System.arraycopy(this.data, from, this.data, to, this.size);
    }
}
