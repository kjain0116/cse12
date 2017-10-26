/*
 * NAME: Kavita Jain
 * PID: A10560035
 * LOGIN: cs12uag
 */

package hw3;

import java.util.*;

/**
 * implementation of a queue using a double ended linked list
 * 
 * @author Kavita Jain
 * @version 1.0
 * @since 7/22/17
 */
public class MyQueue<T> implements Stack_QueueInterface<T> {

	private DoubleEndedLLInterface<T> queue = new DoubleEndedLL<T>();

	/**
     * Tests if the storage is empty.
     *
     * @return true a storage contains no items; false otherwise.
     */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
     * Adds an element to a storage
     *
     * @param newItem - item to be added
     * @throws NullPointerException if the specified element is null
     */
	@Override
	public void addElement(T newItem) {
		if(newItem == null)
			throw new NullPointerException();
		queue.addLast(newItem);
	}

	/**
     * Removes the object from the storage and returns that object as the value
     * of this function.
     *
     * @return value of the removed object or null if the size was zero.
     * @throws NullPointerException if the list is empty
     */
	@Override
	public T removeElement() {
		if(queue.size() == 0)
			throw new NullPointerException();
		return queue.removeFirst();
	}

	/**
     * Returns the number of items in the storage
     *
     * @return the number of items in the storage
     */
	@Override
	public int size() {
		return queue.size();
	}

	/**
     * Returns the next item to be removed
     *
     * @return element to be removed next or null if the size was zero.
     * @throws NullPointerException if the list is empty
     */
	@Override
	public T peek() {
		if(queue.size() == 0)
			throw new NullPointerException();
		T element = queue.removeFirst();
		queue.addFirst(element);
		return element;
	}
	
}
