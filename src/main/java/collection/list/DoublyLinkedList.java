package collection.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> {
    private Node<E> last;
    private Node<E> first;
    private int size;

    public boolean add(E element) {
        this.linkLast(element);
        return true;
    }

    public void addFirst(E element) {
        this.linkFirst(element);

    }

    public void addLast(E element) {
        this.linkLast(element);
    }

    public void add(int index, E element) {
        this.checkElementIndex(index);
        if (index == this.size) {
            this.linkLast(element);
        } else {
            this.linkBefore(element, this.node(index));
        }
    }

    public E getFirst() {
        return this.first.item;
    }

    public E getLast() {
        return this.last.item;
    }

    public E get(int index) {
        checkElementIndex(index);
        return this.node(index).item;
    }

    public E remove() {
        return this.removeFirst();
    }

    public E remove(int index) {
        this.checkElementIndex(index);
        return this.unlinkFirst(this.node(index));
    }

    public boolean remove(Object object) {
        Node<E> x;
        if (Objects.isNull(object)) {
            for (x = this.first; Objects.nonNull(object); x = x.next) {
                if (Objects.isNull(x.item)) {
                    this.unlink(x);
                    return true;
                }
            }
        } else {
            for (x = this.first; Objects.nonNull(x); x = x.next) {
                if (object.equals(x.item)) {
                    this.unlink(x);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean contains(Object object) {
        return this.indexOf(object) >= 0;
    }

    public int indexOf(Object object) {
        int index = 0;
        Node x;

        if (object == null) {
            for (x = this.first; x!=null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
            }

            ++index;
        } else {
            for (x = this.first; x != null; x = x.next) {
                if (object.equals(x.item)) {
                    return index;
                }

                ++index;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = this.size;
        Node x;

        if (object == null) {
            for (x = this.last; x != null; x = x.prev) {
                --index;
                if (x.item == null) {
                    return index;
                }
            }
        } else {
            for (x = this.last; x != null; x = x.prev) {
                --index;
                if (object.equals(x.item)) {
                    return index;
                }
            }
        }

        return -1;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        Node next;
        for (Node x = this.first; x!=null; x = next) {
            next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
        }

        this.first = this.last = null;
        this.size = 0;
    }

    private Node<E> node(int index) {
        Node x;
        int i;

        if (index < this.size >> 1) {
            x = this.first;

            for (i = 0; i < index; ++i) {
                x = x.next;
            }

            return x;
        } else {
            x = this.last;

            for (i = this.size -1; i > index; --i) {
                x = x.prev;
            }

            return x;
        }
    }

    private void linkFirst(E element) {
        Node<E> first = this.first;
        Node newNode = new Node(null, element, first);
        this.first = newNode;
        if (first == null) {
            this.last = newNode;
        } else {
            first.prev = newNode;
        }

        ++this.size;
    }

    private void linkLast(E element) {
        Node<E> last = this.last;
        Node<E> newNode = new Node<>(last, element, null);
        this.last = newNode;

        if (last == null) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }

        size++;
    }

    private void linkBefore(E element, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node newNode = new Node(pred, element, succ);
        succ.prev = newNode;

        if (pred == null) {
            this.first = newNode;
        } else {
            pred.next = newNode;
        }

        ++this.size;
    }

    private void checkElementIndex(int index) {
        if (!this.isElementIndex(index)) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private E removeFirst() {
        Node<E> first = this.first;
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return this.unlinkFirst(first);
        }
    }

    private E unlinkFirst(Node<E> first) {
        E element = first.item;
        Node<E> next = first.next;
        first.item = null;
        first.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }

        --this.size;
        return element;
    }

    private E unlink(Node<E> x) {
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;
        if (Objects.isNull(prev)) {
            this.first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (Objects.isNull(next)) {
            this.last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        --this.size;

        return element;

    }

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
}
