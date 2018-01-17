package lesson180115;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimpleArrayListTest {
    SimpleArrayList<String> list;

    @Test
    public void testAddMultiple() {
        final String[] expected = {"1","1","2","3","4",};

        list = prepareList(expected);

        assertEquals(5, list.size);
        assertArrayEquals(expected, list.array);
    }

    @Test
    public void testAddOverflow() {
        final String[] expected = {"1","1","2","3","4","4",};

        list = prepareList(expected);

        assertEquals(6, list.size);
        compareArrays(expected, list.array);
    }

    @Test
    public void testRemoveLast() {
        list = prepareList("1","1","2","3","4");

        final String[] expected = {"1","1","2","3",};

        list.remove(4);

        assertEquals(4, list.size);
        compareArrays(expected, list.array);
    }

    @Test
    public void testRemoveFromStart() {
        list = prepareList("1","1","2","3","4");

        final String[] expected = {"1","2","3","4",};

        list.remove(0);

        assertEquals(4, list.size);
        compareArrays(expected, list.array);
    }

    @Test
    public void testRemoveFromMiddle() {
        list = prepareList("1","1","2","3","4");

        final String[] expected = {"1","1","3","4",};

        list.remove(2);

        assertEquals(4, list.size);
        compareArrays(expected, list.array);
    }



    private SimpleArrayList<String> prepareList(String... data) {
        SimpleArrayList<String> list = new SimpleArrayList<>();

        for (String s : data) {
            list.add(s);
        }
        return list;
    }

    private void compareArrays(String[] expected, Object[] actual) {
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}