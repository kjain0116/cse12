/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
* d-ary Heap tester
* 
* @author Kavita Jain
* @version 1.0
* @since 7/29/17
*/
public class dHeapTester {

	private dHeap <Integer> binary;
	private dHeap <Integer> fiveAry;
	private dHeap <Integer> empty;
	private dHeap <Integer> minHeap;
	
	/**
	 * sets up testing environment, instantiates heaps, also tests add() method
	 */
	@Before
	public void setup() {
		
		binary = new dHeap <>();
		fiveAry = new dHeap<>(5,200,true);
		empty = new dHeap <>();
		minHeap = new dHeap<>(5,200,false);
		
		binary.add(80);
		binary.add(55);
		binary.add(88);
		binary.add(33);
		binary.add(85);
		binary.remove();
		binary.add(100);
		
		for(int i = 1; i <= 100; i++) {
			fiveAry.add(i);
		}
		
		for(int i = 100; i >= 1; i--) {
			minHeap.add(i);
		}
	}
	
	/**
	 * tests size() method
	 */
	@Test 
	public void testSize() {
		assertEquals("Checking binary heap size" , 5, binary.size());
		assertEquals("Checking fiveAry heap size", 100, fiveAry.size());
		assertEquals("Checking minHeap size", 100, minHeap.size());
	}
	
	/**
	 * tests element() method
	 */
	@Test
	public void testElement() {
		assertEquals("Checking that binary max is 100", new Integer(100), binary.element());
		assertEquals("Checking that fiveAry max is 100", new Integer(100), fiveAry.element());
		assertEquals("Checking that minHeap min is 1", new Integer(1), minHeap.element());
	}
	
	/**
	 * tests exceptions
	 */
	@Test
	public void testExceptions() {
		try {
			empty.add(null);
		}
		catch(NullPointerException ex) {
			
		}
		try {
			empty.remove();
		}
		catch(NoSuchElementException ex) {
			
		}
	}
	
	/**
	 * tests remove() method
	 */
	@Test
	public void testRemove() {
		assertEquals("Checking that 100 is removed", new Integer(100), binary.remove());
		assertEquals("Checking that 85 is removed", new Integer(85), binary.remove());
		assertEquals("Checking that 100 is removed", new Integer(100), fiveAry.remove());
		assertEquals("Checking that 1 is removed", new Integer(1), minHeap.remove());
	}
	
	/**
	 * tests clear() method
	 */
	@Test
	public void testClear() {
		binary.clear();
		assertEquals("Checking that heap is cleared", 0, binary.size());
	}
	
}
