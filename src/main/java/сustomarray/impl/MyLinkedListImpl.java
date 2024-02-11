package сustomarray.impl;
import сustomarray.MyLinkedList;

import java.util.Iterator;
import java.util.Objects;


public class MyLinkedListImpl<E> implements MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public MyLinkedList<E> addFirst(E element) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        return this;
    }

    @Override
    public MyLinkedList<E> addLast(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return this;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E get(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<E> current = first;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash();
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}