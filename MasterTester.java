package hw1;
/* Modified by Pooja Bhat
   04/12/2016
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.runner.*;
import org.junit.runner.notification.*;

public class MasterTester {

    private DoublyLinkedList <Integer> empty;
    private DoublyLinkedList <Integer> one;

    private DoublyLinkedList <Integer> listInt1;
    private DoublyLinkedList <Integer> listInt2;
    private DoublyLinkedList <String> listString;

    private DoublyLinkedList <String> testList;
    LinkedList<Integer> myL = new LinkedList<Integer>();

    static final int DIM = 1000;


    /**
     * Sets up testing environment, instantiates list.
     */
    @Before
    public void setup() {

        empty = new  DoublyLinkedList <>();
        one = new  DoublyLinkedList <>();
        listInt1 = new  DoublyLinkedList <>();
        listInt2 = new  DoublyLinkedList <>();
        listString = new  DoublyLinkedList <>();

        //one = {100}
        one.add(100);

        //listInt = {8,7,6,5,4,3,2,1}
        for(int i=DIM; i>0; i--)
            listInt1.add(i);

        //listString = {vanilla, caramel, raspberry, hazelnut, blueberry, chocolate}
        //Had a craving for donuts when I wrote this
        listString.add("vanilla");
        listString.add("caramel");
        listString.add("raspberry");
        listString.add("hazelnut");
        listString.add("blueberry");
        listString.add("chocolate");
    }

    /**
     * Test add exceptions
     */
    @Test(timeout=1000)
    public void testAdd() {
        //test Add to End
        assertTrue(listInt1.add(555));
        assertEquals("Check if 555 has been added to the end", new Integer(555), listInt1.get(listInt1.size()-1));
        listString.add("pumpkin");
        assertEquals("Check if pumpkin has been added to the end", new String("pumpkin"), listString.get(listString.size()-1));
    }
    /**
     * Test get(int index)
     */
    @Test(timeout=1000)
    public void testGet() {
        assertEquals("Check if first element is vanilla.", new String("vanilla"), listString.get(0));
        assertEquals("Check if second element is caramel.", new String("caramel"), listString.get(1));
        assertEquals("Check if third element is raspberry.", new String("raspberry"), listString.get(2));
        assertEquals("Check if fourth element is hazelnut.", new String("hazelnut"), listString.get(3));
        assertEquals("Check if fifth element is blueberry.", new String("blueberry"), listString.get(4));
        assertEquals("Check if sixth element is chocolate.", new String("chocolate"), listString.get(5));
    }

    @Test(timeout=1000)
    public void testSet()
    {
        assertEquals(new Integer(996), listInt1.set(4, 211));
        assertEquals("Check if [4] has been assigned to 211.", new Integer(211), listInt1.get(4));
    }

    /**
     * Test size()
     */
    @Test(timeout=1000)
    public void testSize() {
        assertEquals("Check if size of Integerlist is 8.", 1000, listInt1.size());
        assertEquals("Check if size of Stringlist is 6.", 6, listString.size());
        assertEquals("Check if size of one is 1.", 1, one.size());
        assertEquals("Check if size of empty is 0.", 0, empty.size());
    }

    /**
     * Test isEmpty()
     */
    @Test(timeout=1000)
    public void testIsEmpty() {
        assertTrue("Should not be empty.", !listInt1.isEmpty());
        assertTrue("Should be empty.", empty.isEmpty());
    }

}
