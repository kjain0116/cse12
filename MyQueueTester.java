package hw3;

import org.junit.*;
import static org.junit.Assert.*;

public class MyQueueTester {

    private MyQueue<Integer> empty;
    private MyQueue<Integer> one;
    private MyQueue<Integer> many;

    private final int N = 3;

    @Before
    public void setUp() {
        empty = new MyQueue<>();
        one = new MyQueue<>();
        one.addElement(15);
        many = new MyQueue<>();
        for (int i = 0; i < N; i++) {
            many.addElement(i);
        }
    }

    @Test
    public void testSize() {
        assertEquals(empty.size(), 0);
        assertEquals(one.size(), 1);
        assertEquals(many.size(), N);
    }

    @Test
    public void testAddElement() {
        assertEquals(0, empty.size());
        empty.addElement(10);
        assertEquals(1, empty.size());
        one.addElement(10);
        assertEquals(2, one.size());
    }

    @Test(expected = NullPointerException.class)
    public void testEnqueueNull() {
        one.addElement(null);
    }

    @Test
    public void testRemoveElement() {
        assertEquals(15, one.removeElement().intValue());
        assertEquals(0, one.size());
        assertEquals(0, many.removeElement().intValue());
        assertEquals(N - 1, many.size());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveElementEmpty() {
        empty.removeElement();
    }

    @Test
    public void testPeek() {
        assertEquals(15, one.peek().intValue());
        assertEquals(1, one.size());
        assertEquals(0, many.peek().intValue());
        assertEquals(N, many.size());
    }

    @Test(expected = NullPointerException.class)
    public void testPeekEmpty() {
        empty.peek();
    }

}
