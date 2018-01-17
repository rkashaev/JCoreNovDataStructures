package lesson180115;

import java.util.Iterator;

public class SimpleArrayQueue<E> implements Iterable<E> {
    private final int CAPACITY = 5;

    Object[] array;
    int size = 0;
    int head;
    int tail;

    public SimpleArrayQueue() {
        array = new Object[CAPACITY];
    }

    public void enqueue(E value) {
        if (size >= array.length) {
            throw new RuntimeException("Queue is totally full!");
        }

        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        E value = (E) array[head];
        head = (head + 1) % array.length;
        size--;
        return value;
    }


    @Override
    public Iterator<E> iterator() {
        return new SimpleQueueIterator<>();
    }

    class SimpleQueueIterator<E> implements Iterator<E> {
        int cur;
        int count = 0;

        public SimpleQueueIterator() {
            this.cur = head;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            Object value = array[cur];
            cur = (cur + 1) % array.length;
            count++;
            return (E) value;
        }
    }
}
