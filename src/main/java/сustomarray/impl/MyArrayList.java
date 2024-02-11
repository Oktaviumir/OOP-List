package сustomarray.impl;

import сustomarray.ArrayIterator;
import сustomarray.MyList;

import java.util.Iterator;


public class MyArrayList<T> implements MyList<T> {

    private T[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        this.capacity = 2;
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }

    private void addCapacity() {
        T[] arr = (T[]) new Object[capacity * 2];
        System.arraycopy(array, 0, arr, 0, array.length);
        array = arr;
    }

    @Override
    public void add(T elem) {
        if (size == capacity) {
            addCapacity();
        }
        array[size] = elem;
        size++;
    }


    @Override
    public void remove(int idx) {
        T[] arr = (T[]) new Object[array.length - 1];
        System.arraycopy(array, 0, arr, 0, idx);
        int amountElementAfterIndex = arr.length - idx - 1;
        System.arraycopy(array, idx + 1, arr, idx, amountElementAfterIndex);
        array = arr;
        size--;
    }
//    public void remove(int index) {
//        try {
//            T[] temp = array;
//            array = (T[]) new Object[temp.length - 1];
//            System.arraycopy(temp, 0, array, 0, index);
//            int amountElementsAfterIndex = temp.length - index - 1;
//            System.arraycopy(temp, index + 1, array, index, amountElementsAfterIndex);
//        } catch (ClassCastException e) {
//            throw new RuntimeException(e);
//        }
//        size--;
//    }

    @Override
    public T get(int idx) {
        return array[idx];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(array);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int idx = 0;
        while (idx != size) {
            sb.append(array[idx]).append(",");
            idx++;
        }
        if (sb.length() == 1) return "{}";
        sb.deleteCharAt(sb.length() - 1).append("}");
        return sb.toString();
    }
}
