package collection.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStackTest {
    MyStack<String> stack;

    @BeforeEach
    void initialization() {
        this.stack = new MyStack<>();
    }

    @Test
    void testPush() {
        assertEquals(stack.push("A"), "A");
        assertEquals(stack.push("B"), "B");
    }

    @Test
    void testSize() {
        stack.push("A");
        stack.push("B");

        assertEquals(stack.size(), 2);
    }

    @Test
    void testPop() {
        stack.push("A");
        stack.push("B");

        assertEquals(stack.size(), 2);
        assertEquals(stack.pop(), "B");
        assertEquals(stack.pop(), "A");
        assertEquals(stack.size(), 0);
    }

    @Test
    void testPeek() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(stack.peek(), "C");
        assertEquals(stack.peek(), "C");
    }
}
