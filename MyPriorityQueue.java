/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;

/**
* implementation of a priority queue using a d-ary heap
* 
* @author Kavita Jain
* @version 1.0
* @since 7/29/17
*/
public class MyPriorityQueue<T extends Comparable<? super T>> {

	private dHeap <T> heap;
	
	/**
	 * MyPriorityQueue constructor
	 * @param initialSize Size of the heap
	 */
    public MyPriorityQueue(int initialSize) {
    	heap = new dHeap<>(3, initialSize, true);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot
     * be null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
    	if(element == null) {
    		throw new NullPointerException();
    	}
    	this.heap.add(element);
        return true; 
    }

    /**
     * Removes the head of this Priority Queue (largest element), or null if
     * the queue is empty.
     *
     * @return The head of the queue (largest element), or null if queue is
     * empty.
     */
    public T poll() {
    	if(this.heap.size() == 0) {
    		return null;
    	}
        return this.heap.remove();
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        this.heap.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     *
     * @return the next item to be removed, null if the queue is empty
     */
    public T peek() {
    	if(this.heap.size() == 0) {
    		return null;
    	}
        return this.heap.element();
    }
}
