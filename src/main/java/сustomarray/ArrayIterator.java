package сustomarray;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int idx;
    private T[] arr;

    public ArrayIterator(T[] arr) {
        this.arr = arr;
        this.idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < arr.length;
    }

    @Override
    public T next() {
        return arr[idx++];
    }
}
