package collection.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}
