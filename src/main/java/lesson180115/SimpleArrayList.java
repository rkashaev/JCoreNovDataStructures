package lesson180115;

public class SimpleArrayList<E> implements SimpleList<E> {
    Object[] array;
    int size = 0;

    public SimpleArrayList() {
        array = new Object[5];
    }

    @Override
    public void add(E el) {
        if (size == array.length) {
            // we create a new array with 1.5 x increased size
            Object[] newArray = new Object[(int) (size * 1.5)];
            // copy old data to new array
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = el;
    }

    @Override
    public E get(int index) {
        // todo array bounds checking

        return (E) array[index];
    }

    @Override
    public void remove(int index) {
        // todo array bounds checking
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[--size] = null;
    }

    @Override
    public int size() {
        return size;
    }


}
