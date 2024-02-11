package сustomarray;

import сustomarray.impl.MyArrayList;
import сustomarray.impl.MyLinkedListImpl;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(23);
        myList.add(1);
        myList.add(22);
        System.out.println(myList);
        System.out.println(myList.get(1));
        myList.remove(1);
        System.out.println(myList);

        MyLinkedList<Integer> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(4);
        myLinkedList.addLast(25);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getSize());
        System.out.println(myLinkedList.get(3));

    }
}
