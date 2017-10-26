/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw5;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import org.junit.runner.*;
import org.junit.runner.Result;
import org.junit.runner.notification.*;
import org.junit.runner.notification.Failure;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import hw5.HashTable.HashType;

/**
* Hash Table Tester
* 
* @author Kavita Jain
* @version 1.0
* @since 8/3/17
*/
public class HashTableTester {

	//hashTable objects for all 3 hash functions
	HashTable hashTable;
	HashTable hashTable2;
	HashTable hashTable3;
	
	/*
	 * setup before testing
	 */
	@Before
	public void setup() {
		hashTable = new HashTable(10, HashType.ONE);
		hashTable2 = new HashTable(10, HashType.TWO);
		hashTable3 = new HashTable(10, HashType.THREE);
	}
	
	/*
	 * testing insert method for all 3 hash functions
	 */
	@Test
	public void testInsert() {
		assertTrue("testing successful insert", hashTable.insert("contains"));
		assertTrue("testing successful insert", hashTable.insert("the"));
		assertFalse("testing failed insert",hashTable.insert("contains"));
		assertTrue("testing successful insert", hashTable2.insert("the"));
		assertTrue("testing successful insert", hashTable3.insert("the"));
	}
	
	/*
	 * testing contains method for all 3 hash functions
	 */
	@Test
	public void testContains() {
		hashTable.insert("the");
		hashTable2.insert("the");
		hashTable3.insert("the");
		assertTrue("testing contain method", hashTable.contains("the"));
		assertTrue("testing contain method", hashTable2.contains("the"));
		assertTrue("testing contain method", hashTable3.contains("the"));
		assertFalse("testing contain method", hashTable.contains("a"));
	}
	
	/*
	 * testing delete method for all 3 hash functions
	 */
	@Test
	public void testDelete() {
		hashTable.insert("the");
		hashTable2.insert("the");
		hashTable3.insert("the");
		assertTrue("testing successful delete", hashTable.delete("the"));
		assertTrue("testing successful delete", hashTable2.delete("the"));
		assertTrue("testing successful delete", hashTable3.delete("the"));
		assertFalse("testing failed delete", hashTable.delete("a"));
	}
	
	/*
	 * testing getSize method for all 3 hash functions
	 */
	@Test
	public void testGetSize() {
		hashTable.insert("the");
		hashTable.insert("a");
		hashTable.insert("I");
		hashTable.insert("person");
		hashTable2.insert("the");
		hashTable2.insert("a");
		hashTable2.insert("I");
		hashTable2.insert("person");
		hashTable3.insert("the");
		hashTable3.insert("a");
		hashTable3.insert("I");
		hashTable3.insert("person");
		assertEquals("testing getSize method", 4, hashTable.getSize());
		assertEquals("testing getSize method", 4, hashTable2.getSize());
		assertEquals("testing getSize method", 4, hashTable3.getSize());
	}
	
	/*
	 * testing exceptions
	 */
	@Test
	public void testExceptions() {
		try{
			hashTable.insert(null);
		}catch(NullPointerException e) {
			
		}
		try{
			hashTable.delete(null);
		}catch(NullPointerException e) {
			
		}
		try{
			hashTable.contains(null);
		}catch(NullPointerException e) {
			
		}
	}
	
}
