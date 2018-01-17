package lesson180115;

public interface SimpleList<E> {

    void add(E element);

    E get(int index);

    void remove(int index);

    int size();
}
