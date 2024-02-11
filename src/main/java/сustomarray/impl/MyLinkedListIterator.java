package сustomarray.impl;
import java.util.Iterator;


public class MyLinkedListIterator<E> implements Iterator<E> {

    private MyLinkedListImpl.Node<E> current;

    private MyLinkedListImpl<E> myLinkedList;




    public MyLinkedListIterator(MyLinkedListImpl<E> myLinkedList) {

        this.current = myLinkedList.getFirst();

        this.myLinkedList = myLinkedList;

    }




    @Override

    public boolean hasNext() {

        return current != null;

    }




    @Override

    public E next() {

        current = current.next;

        if (current == null) return myLinkedList.getLast().item;

        return current.prev.item;

    }

}