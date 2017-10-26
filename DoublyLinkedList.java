/**
 * NAME: Kavita Jain
 * PID: A10560035
 * LOGIN: cs12uag
 */

package hw1;

import java.util.*;

/**
* creates implementation of a Doubly-Linked List
* 
* @author Kavita Jain
* @version %I%, %G%
* @since ${date}
*/
public class DoublyLinkedList<E> extends AbstractList<E> {

	private int nelems;   //No. of items in the list
	private Node head;
	private Node tail;

	/**
	* creates node objects to be used in the Doubly-Linked List
	* 
	* @author Kavita Jain
	* @version %I%, %G%
	* @since ${date}
	*/
	protected class Node {

		E data;
		Node next;
		Node prev;

		/** Constructor to create singleton Node */
		public Node(E element)
		{
			this.data = element;
			next = null;
			prev = null;
		}
		/** Constructor to create singleton link it between previous and next 
		 *   @param element Element to add, can be null
		 *   @param prevNode predecessor Node, can be null
		 *   @param nextNode successor Node, can be null 
		 */
		public Node(E element, Node prevNode, Node nextNode)
		{
			this.data = element;
			this.next = nextNode;
			this.prev = prevNode;
			if(prevNode != null)
				prevNode.next = this;
			if(nextNode != null)
				nextNode.prev = this;
			
		}
		/** Remove this node from the list. Update previous and next nodes */
		public void remove()
		{
			this.prev.next = this.next;
			this.next.prev = this.prev;
		}
		/** Set the previous node in the list
		 *  @param p new previous node
		 */
		public void setPrev(Node p)
		{
			this.prev = p;
			p.next = this;
		}
		/** Set the next node in the list
		 *  @param n new next node
		 */
		public void setNext(Node n)
		{
			this.next = n;
			n.prev = this;
		}

		/** Set the element 
		 *  @param e new element 
		 */
		public void setElement(E e)
		{
			this.data = e;
		}
		
		/** Accessor to get the next Node in the list 
		 *  @return next node
		 */
		public Node getNext()
		{
			return this.next; 
		}
		
		/** Accessor to get the prev Node in the list 
		 *  @return prev node
		 */
		public Node getPrev()
		{
			return this.prev;
		} 
		
		/** Accessor to get the Nodes Element 
		 *  @return node's element
		 */
		public E getElement()
		{
			return this.data;
		} 
	}

	/** ListIterator implementation */ 

	protected class MyListIterator implements ListIterator<E> {

		private boolean forward;
		private boolean canRemove;
		private Node left,right; // Cursor sits between these two nodes
		private int index;        // Tracks current position. what next() would return

		public MyListIterator()
		{
		}

		@Override
		public void add(E e) throws  NullPointerException
		{
		}
		@Override
		public boolean hasNext()
		{
			return false; // XXX-CHANGE-XXX
		}

		@Override
		public boolean hasPrevious()
		{
			return false; // XXX-CHANGE-XXX
		}
		@Override
		public E next() throws NoSuchElementException
		{
			return (E) null;  // XXX-CHANGE-XXX
		}
		@Override
		public int nextIndex()
		{
			return 0; // XXX-CHANGE-XXX
		}
		@Override
		public E previous() throws NoSuchElementException
		{
			return (E) null; // XXX-CHANGE-XXX
		}

		@Override
		public int previousIndex()
		{
			return 0;  // XXX-CHANGE-XXX
		}
		@Override
		public void remove() throws IllegalStateException
		{
		}
		@Override
		public void set(E e) 
				throws NullPointerException,IllegalStateException
		{
		}

	}

	//  Implementation of the DoublyLinkedList Class


	/** Only 0-argument constructor is define */
	/**
	 * Creates a new, empty doubly-linked list.
	 */
	public DoublyLinkedList()
	{
		head = new Node(null);
		tail = new Node(null,head,null);
		nelems = 0;
	}

	/**
	 * Retrieves the amount of elements that are currently on the list.
	 * 
	 * @return Number of elements currently on the list
	 */
	@Override
	public int size()
	{
		return nelems; 
	}

	/**
	 * Adds an element to a certain index in the list, shifting exist elements to
	 * create room. Does not accept null values.
	 * 
	 * @param index Where in the list to add the element.
	 * @param data Data to be added.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 * @throws NullPointerException if data received is null.
	 */
	@Override
	public void add(int index, E data) 
			throws IndexOutOfBoundsException,NullPointerException
	{
		if(index < 0 || index > nelems)
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		
		if(data == null)
			throw new NullPointerException("Null Pointer Exception");
		
		if(this.isEmpty())
			new Node(data,this.head,this.tail);
		else
			new Node(data,this.getNth(index),this.getNth(index).next);	
		
		this.nelems++;
		
	}

	/**
	 * Add an element to the end of the list.
	 * Note: the boolean add method will presumably always return true; it is a boolean 
	 * function due to the method definition in AbstractList.
	 * 
	 * @param data Data to be added.
	 * @return boolean that will always return true
	 * @throws NullPointerException if data received is null.
	 */
	@Override
	public boolean add(E data) throws NullPointerException
	{
		if(data == null)
			throw new NullPointerException("Null Pointer Exception");
		
		if(this.isEmpty())
			new Node(data,this.head,this.tail);
		else
			new Node(data,this.getNth(nelems - 1),this.tail);
		this.nelems++;
		return true;
	}

	/**
	 * Retrieves the element stored with a given index on the list.
	 * 
	 * @param index The index of the desired element.
	 * @return The element stored in the Node with the desired index.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index > nelems || nelems == 0)
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		
		return this.getNth(index).getElement();
	}

	/**
	 * Retrieves the last index of the item passed as a parameter
	 * 
	 * @param Item whose index is to be retrieved
	 * @return index The index of the desired item, -1 if the item is not found.
	 * @throws NullPointerException if item passed is null
	 */
	@Override
	public int lastIndexOf(Object o) throws NullPointerException {
		
		if(o == null)
			throw new NullPointerException("Null Pointer Exception");
		
		
		int counter = nelems - 1;
		while(counter > -1) {
			Node current = this.getNth(counter);
			if(current.getElement() == o)
				return counter;
			else
				counter--;
		}
		return counter;
	}
	
	/**
	 * Sets the value of an element at a certain index in the list.
	 * 
	 * @param index Where in the list the data should be added.
	 * @param data Data to add.
	 * @return Element that was previously at this index.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 * @throws NullPointerException if data received is null.
	 */
	@Override
	public E set(int index, E data) 
			throws IndexOutOfBoundsException,NullPointerException
	{
		if(index < 0 || index > nelems || nelems == 0)
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		
		if(data == null)
			throw new NullPointerException("Null Pointer Exception");
		
		E result = this.getNth(index).getElement();
		this.getNth(index).setElement(data);
		return result; 
	}

	/**
	 * Removes the element from a certain index in the list.
	 * 
	 * @param index where element will be removed from the list.
	 * @return element that was previously at this index.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index > nelems || nelems == 0)
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		
		E result = this.getNth(index).getElement();
		this.getNth(index).remove();
		this.nelems--;
		return result;
	}

	/**
	 * Returns true if this list contains the specified element,
	 * false otherwise.
	 * @param data to be searched in the list
	 * @return true if the data is in the list, false otherwise
	 * @throws NullPointerException if the data is null
	 */
	@Override
	public boolean contains(Object o) throws NullPointerException {
		
		if(o == null)
			throw new NullPointerException("Null Pointer Exception");
		
		Node current = this.getNth(0);
		boolean flag = false;
		
		while(!flag && current != this.tail) {
			if(current.getElement() == o) {
				flag = true;
				return flag;
			}
			else
				current = current.getNext();
		}
		
		return flag; 
	}
	
	/**
	 * Removes the first occurrence of the specified element in this list,
	 * (when traversing the list from head to tail).
	 * If the list does not contain the element, it is unchanged.
	 * @param data to be removed from the list
	 * @return true if the data is in the list, false otherwise
	 * @throws NullPointerException if the data is null
	 */
	public boolean removeFirstOccurrence(Object o) throws NullPointerException {
		
		if(o == null)
			throw new NullPointerException("Null Pointer Exception");
		
		Node current = this.getNth(0);
		boolean flag = false;
		
		while(!flag && current != this.tail) {
			if(current.getElement() == o) {
				flag = true;
				current.remove();
				this.nelems--;
				return flag;
			}
			else
				current = current.getNext();
		}
		
		return flag; 
	}
	
	/** Clear the linked list */
	public void clear()
	{
		int counter = 0;
		Node current = this.getNth(counter);
		
		while(current != this.tail) {
			
			current = current.getNext();
			this.getNth(counter).remove();
			counter++;
				
		}
		this.nelems = 0;
	}

	/** 
	 * Determine if the list empty 
	 * 
	 *  @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if(this.nelems == 0)
			return true;
		else 
			return false;
		
	}

	public Iterator<E> QQQiterator()
	{
		return new MyListIterator();
	}
	public ListIterator<E> QQQlistIterator()
	{
		return new MyListIterator();
	}

	// Helper method to get the Node at the Nth index
	private Node getNth(int index) 
	{
		Node current = head.getNext();
		int counter = 0;
		while(counter < index) {
			current = current.getNext();
			counter++;
		}
		return current;  
	}




	/*  UNCOMMENT the following when you believe your MyListIterator class is
   functioning correctly
   public Iterator<E> iterator()
   {
   return new MyListIterator();
   }
   public ListIterator<E> listIterator()
   {
   return new MyListIterator();
   }
	 */
}

