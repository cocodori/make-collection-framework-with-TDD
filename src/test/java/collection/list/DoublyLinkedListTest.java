package collection.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {

    @Test
    void testAdd() {
        DoublyLinkedList<String> list = new DoublyLinkedList();

        assertTrue(list.add("Hello"));
    }

    @Test
    void addFirst() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));

        list.addFirst("X");

        assertEquals("X", list.get(0));
    }

    @Test
    void testAddLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.get(2));

        list.addLast("X");

        assertEquals("X", list.get(3));
    }

    @Test
    void testAddToSpecifiedPosition() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));

        list.add(1, "X");

        assertEquals("X", list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    void testGet() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void getFirst() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.getFirst());
    }

    @Test
    void getLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.getLast());
    }

    @Test
    void testClear() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void testContains() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("X"));
    }

    @Test
    void testIndexOf() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");


        assertEquals(1, list.indexOf("B"));
        assertEquals(2, list.indexOf("C"));
        assertEquals(-1, list.indexOf("X"));
    }

    @Test
    void testLastIndexOf() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");

        assertEquals(3, list.lastIndexOf("C"));
    }

    @Test
    void testRemove() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.remove());
        assertEquals("B", list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveIndex() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);

        assertEquals("C", list.get(1));
    }

    @Test
    void testRemoveObject() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove("B");

        assertEquals("C", list.get(1));
    }

    @Test
    void testSizeTest() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());

        list.remove();

        assertEquals(2, list.size());

        list.clear();

        assertEquals(0, list.size());
    }
}
