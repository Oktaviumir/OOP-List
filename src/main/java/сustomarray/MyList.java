package сustomarray;

public interface MyList<T> extends Iterable<T>{
    void add(T elem);
    void remove(int idx);
    T get(int idx);
    int size();
}
