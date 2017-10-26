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
 * BSTDup Tester
 * 
 * @author Kavita Jain
 * @version 1.0
 * @since 7/22/17
 */
public class BSTDupTester {

	private BSTDup <String> bst;
	
	@Before
	public void setup() {
		
		bst = new BSTDup <>();
		
		bst.insert(2, "candy");
		bst.insert(1, "cookies");
		bst.insert(3,"brownies");
		bst.insert(3, "chocolate");
		bst.insert(10, "ice cream");
		bst.insert(5, "muffins");
		bst.insert(7, "frozen yogurt");
	}
	
	/**
	 * tests findPair method
	 */
	@Test
	public void testFindPair() {
		
		assertTrue("Checking key-value pair", bst.findPair(3, "chocolate"));
		assertFalse("Checking fake key-value pair", bst.findPair(4,"muffins"));
		
	}
	
	/**
	 * tests getElements method
	 */
	/*@Test
	public void testGetElements() {
		ArrayList <String> elements = new ArrayList <>(); 
		assertEquals("Checking accessor for all elements",elements,bst.getElements(1));
	}*/
	
	/**
	 * tests getHeight method
	 */
	@Test
	public void testGetHeight() {
		assertEquals("Checking height",4,bst.getHeight());
	}
	
	/**
	 * tests leafCount method
	 */
	@Test
	public void testLeafCount() {
		assertEquals("Checking leaf count",2,bst.leafCount());
	}
	
	/**
	 * tests postOrder method
	 */
	@Test
	public void testPostOrder() {
		int[] array = bst.postOrder();
		assertEquals("Checking bfs method",1,array[0]);
	}
	
	/**
	 * tests bfs method
	 */
	@Test
	public void testBfs() {
		int[] array = bst.bfs();
		assertEquals("Checking bfs method",5,array[4]);
	}
}
