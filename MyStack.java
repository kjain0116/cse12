/*
 * NAME: Kavita Jain
 * PID: A10560035
 * LOGIN: cs12uag
 */

package hw3;

import java.util.*;

/**
 * implementation of a stack using a double ended linked list
 * 
 * @author Kavita Jain
 * @version 1.0
 * @since 7/22/17
 */
public class MyStack<T> implements Stack_QueueInterface<T> {

	private DoubleEndedLLInterface<T> stack = new DoubleEndedLL<T>();

	/**
     * Tests if the storage is empty.
     *
     * @return true a storage contains no items; false otherwise.
     */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
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
		stack.addFirst(newItem);
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
		if(stack.size() == 0)
			throw new NullPointerException();
		return stack.removeFirst();
	}

	/**
     * Returns the number of items in the storage
     *
     * @return the number of items in the storage
     */
	@Override
	public int size() {
		return stack.size();
	}

	/**
     * Returns the next item to be removed
     *
     * @return element to be removed next or null if the size was zero.
     * @throws NullPointerException if the list is empty
     */
	@Override
	public T peek() {
		if(stack.size() == 0)
			throw new NullPointerException();
		T element = stack.removeFirst();
		stack.addFirst(element);
		return element;
	}
	
}
