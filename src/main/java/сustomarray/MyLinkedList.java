package сustomarray;

public interface MyLinkedList<E> extends Iterable<E> {
    MyLinkedList<E> addFirst(E element);
    MyLinkedList<E> addLast(E element);

    int getSize();

    E get(int index);
}