package lesson180115;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimpleArrayQueueTest {

    @Test
    public void testAdd5elements() throws Exception {
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        assertEquals(5, queue.size);
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, queue.array);

    }

    @Test
    public void testAdd7remove2() throws Exception {
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");


        assertEquals("1", queue.dequeue());
        assertEquals("2", queue.dequeue());

        queue.enqueue("6");
        queue.enqueue("7");

        assertEquals(5, queue.size);
        assertArrayEquals(new String[]{"6", "7", "3", "4", "5"}, queue.array);
    }

    @Test
    public void testIterator() throws Exception {
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");


        assertEquals("1", queue.dequeue());
        assertEquals("2", queue.dequeue());

        queue.enqueue("6");
        queue.enqueue("7");

        for (String str : queue) {
            System.out.print(str + " ");
        }

    }

}