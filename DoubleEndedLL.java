/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw3;

/**
* implementation of a Double Ended Linked List
* 
* @author Kavita Jain
* @version 1.0
* @since 7/22/17
*/
public class DoubleEndedLL<T> implements DoubleEndedLLInterface<T> {
	
	private int nelems;   //No. of items in the list
	private Node head;
	private Node tail;

	/**
	* creates node objects to be used in the Double Ended Linked List
	* 
	* @author Kavita Jain
	* @version 1.0
	* @since 7/22/17
	*/
	protected class Node {

		T data;
		Node next;

		/** Constructor to create singleton Node */
		public Node(T element)
		{
			data = element;
			next = null;
			
		}
		/** Constructor to create singleton link it between previous and next 
		 *   @param element Element to add, can be null
		 *   @param prevNode previous Node, can be null
		 */
		public Node(T element, Node prevNode)
		{
			data = element;
			this.next = prevNode.next;
			prevNode.next = this;
			
		}
		
		/** Set the next node in the list
		 *  @param n new next node
		 */
		public void setNext(Node n)
		{
			this.next = n;
		}

		/** Set the element 
		 *  @param e new element 
		 */
		public void setElement(T e)
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
		
		/** Accessor to get the Nodes Element 
		 *  @return node's element
		 */
		public T getElement()
		{
			return this.data;
		} 
	}
	
	/** Double Ended Linked List Constructor */
	public DoubleEndedLL()
	{
		head = new Node(null);
		tail = new Node(null,head);
		nelems = 0;
	}
	
	/**
     * Checks if the list is empty
     *
     * @return returns true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
    	
    	if(this.nelems == 0)
    		return true;
    	else return false;
    	
    }

    /**
     * Checks the size of the list
     *
     * @return returns the number of elements in the list
     */
    public int size() {
    	
    	return this.nelems;
    	
    }

    /**
     * Adds a new node to the front of the list
     *
     * @param newItem - an element to add
     */
    public void addFirst(T newItem) {
    	
    	new Node(newItem,this.head);
    	this.nelems++;
    }

    /**
     * Adds a new node to the end of the list
     *
     * @param newItem - an element to add
     */
    public void addLast(T newItem) {
    	
    	Node current = this.head;
    	while(current.getNext() != this.tail)
    		current = current.getNext();
    	new Node(newItem, current);
    	this.nelems++;
    }

    /**
     * Removes a node from the beginning of the list
     *
     * @return element the data found
     * @throws NullPointerException if the list is empty
     */
    public T removeFirst() {
    	
    	if(nelems == 0)
    		throw new NullPointerException("List is empty");
    	Node current = this.head.getNext();
    	T element = current.getElement();
    	this.head.setNext(current.getNext());
    	this.nelems--;
    	return element;
    	
    }

    /**
     * Removes a node from the end of the list
     *
     * @return element the data found
     * @throws NullPointerException if the list is empty
     */
    public T removeLast() {
    	
    	if(nelems == 0)
    		throw new NullPointerException("List is empty");
    	Node current = this.head;
    	while(current.getNext().getNext() != this.tail)
    		current = current.getNext();
    	T element = current.getNext().getElement();
    	current.setNext(this.tail);
    	this.nelems--;
    	return element;
    	
    }
    
}
