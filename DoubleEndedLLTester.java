/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Double Ended Linked List Tester
 * 
 * @author Kavita Jain
 * @version 1.0
 * @since 7/22/17
 */
public class DoubleEndedLLTester {
	
	private DoubleEndedLL <Integer> empty;
    private DoubleEndedLL <Integer> one;
    private DoubleEndedLL <Integer> listInt;
    private DoubleEndedLL <String> listString;

    static final int DIM = 1000;


    /**
     * Sets up testing environment, instantiates lists.
     */
    @Before
    public void setup() {

        empty = new  DoubleEndedLL <>();
        one = new  DoubleEndedLL <>();
        listInt = new  DoubleEndedLL <>();
        listString = new  DoubleEndedLL <>();

        //one = {100}
        one.addFirst(100);

        //listInt = {8,7,6,5,4,3,2,1}
        for(int i=DIM; i>0; i--)
            listInt.addLast(i);

        //listString = {vanilla, caramel, raspberry, hazelnut, blueberry, chocolate}
        listString.addFirst("vanilla");
        listString.addLast("caramel");
        listString.addLast("raspberry");
        listString.addLast("hazelnut");
        listString.addLast("blueberry");
        listString.addLast("chocolate");
    }

    /**
     * Test isEmpty method
     */
    @Test(timeout=1000)
    public void testIsEmpty() {
        
        assertFalse("Check that one is not empty", one.isEmpty());
        assertTrue("Check if empty list is empty", empty.isEmpty());
        assertFalse("Check that listInt1 is not empty", listInt.isEmpty());
        assertFalse("Check that listString is not empty", listString.isEmpty());
        
    }
    
    /**
     * Test size method
     */
    @Test
    public void testSize() {
    	
    	assertEquals("Check that one has size 1", 1, one.size());
    	assertEquals("Check that empty has size 0", 0, empty.size());
    	assertEquals("Check that listInt has size 1000", 1000, listInt.size());
    	assertEquals("Check that listString has size 6", 6, listString.size());
    	
    }
    
    /**
     * Test removeFirst method
     */
    @Test
    public void testRemoveFirst() {
    	
    	assertEquals("Check that one has removes and returns 100", new Integer(100), one.removeFirst());
    	assertEquals("Check that listInt removes and returns 1000", new Integer(1000), listInt.removeFirst());
    	assertEquals("Check that listString removes and returns vanilla", new String("vanilla"), listString.removeFirst());	
    	
    }
    
    /**
     * Test removeLast method
     */
    @Test
    public void testRemoveLast() {
    	
    	assertEquals("Check that one has removes and returns 100", new Integer(100), one.removeLast());
    	assertEquals("Check that listInt removes and returns 1", new Integer(1), listInt.removeLast());
    	assertEquals("Check that listString removes and returns chocolate", new String("chocolate"), listString.removeLast());	
    	
    }
    
    /**
     * Test exceptions
     */
    @Test
    public void testException() {
    	
    	try {
    		empty.removeFirst();
    	}
    	catch(NullPointerException ex) {
    	}
    	
    	try {
    		empty.removeLast();
    	}
    	catch(NullPointerException ex) {
    	}
    }
    
}
