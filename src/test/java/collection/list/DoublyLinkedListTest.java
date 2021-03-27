package collection.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DoublyLinkedListTest {

    @Test
    void testAdd() {
        DoublyLinkedList<String> list = new DoublyLinkedList();

        assertTrue(list.add("Hello"));
    }
}
