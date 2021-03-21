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

    @Test
    void testDelete() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");

        assertEquals(3, myArrayList.size());

        myArrayList.delete("c");

        assertEquals(2, myArrayList.size());

        myArrayList.delete("a");

        assertEquals(1, myArrayList.size());

    }
}
