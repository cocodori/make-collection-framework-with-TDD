package collection.list;

import java.util.LinkedList;

public class DoublyLinkedList<E> {
    Node node;

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public boolean add(E item) {
        node = new Node(null, item, null);
        return true;
    }
}
