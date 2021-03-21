package collection.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    void testAdd() {
        MyArrayList<String> arrayList = new MyArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals(3, arrayList.size());
    }

    @Test
    void testGet() {
        MyArrayList<String> arrayList = new MyArrayList<>();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));

        //만약 List 크기를 초과하는 인덱스를 호출한다면?
        try {
            arrayList.get(1111);
            fail("?");
        } catch (Exception e) {
        }
    }

    @Test
    void testIsEmpty() {
        MyArrayList myArrayList = new MyArrayList();

        assertTrue(myArrayList.isEmpty());
    }


    /*
    *   remove() 고려 사항
    *   데이터 삭제할 때마다 size도 같이 -1 되어야 함.
    *   0번째 인덱스를 지웠다면 1번 인덱스가 0번 인덱스 자리로 이동해야 함
    * */
    @Test
    void testRemoveWithObject() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        myArrayList.add("f");
        myArrayList.add("g");

        myArrayList.remove("a");
        myArrayList.remove("d");
        myArrayList.remove("f");

        assertEquals(4, myArrayList.size());

        System.out.println(myArrayList);
    }
}
