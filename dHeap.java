/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;

import java.util.*;

/**
* implementation of a d-ary heap
* 
* @author Kavita Jain
* @version 1.0
* @since 7/25/17
*/
public class dHeap<T extends Comparable<? super T>>
        implements dHeapInterface<T> {

    private T[] heap; //heap array
    private int d; //branching factor
    private int nelems;
    private boolean isMaxHeap; //boolean to indicate whether heap is max or min

    /**
     * Initializes a binary max heap with capacity = 7
     */
    public dHeap() {
    	this.heap = (T[]) new Comparable[7];
    	this.d = 2;
    	this.nelems = 0;
    	this.isMaxHeap = true;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    public dHeap(int heapSize) {
    	if(heapSize <= 0 )
    		heapSize = 1;
    	this.heap = (T[]) new Comparable[heapSize];
    	this.d = 2;
    	this.nelems = 0;
    	this.isMaxHeap = true;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d The number of child nodes each node in the heap should have.
     * @param heapSize The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap)
            throws IllegalArgumentException {
    	if(heapSize <= 0 )
    		heapSize = 1;
    	this.heap = (T[]) new Comparable[heapSize];
    	this.d = d;
    	if(this.d < 1)
    		throw new IllegalArgumentException();
    	this.nelems = 0;
    	this.isMaxHeap = isMaxHeap;
    }

    /**
     * Returns the number of elements stored in the heap.
     *
     * @return The number of elements stored in the heap.
     */
    @Override
    public int size() {
        return this.nelems;

    }
    /**
     * returns the parent index of a certain index
     * @param index
     * @return parent index
     */
    private int parent(int index) {
    	if(index == 0)
    		return 0;
    	return (index - 1)/(this.d);
    }
    
    /**
     * Adds the specified element to the heap; data cannot be null. Resizes the
     * storage if full.
     *
     * @param data The element to add.
     * @throws NullPointerException if data is null.
     */
    @Override
    public void add(T data) throws NullPointerException {
    	if(data == null) {
    		throw new NullPointerException();
    	}
    	if(this.size() == this.heap.length) {
    		this.heap = this.resize(this.heap);
    	}
        this.heap[this.size()] = data;
        this.nelems++;
        T newElement = bubbleUp(this.size()-1);
    }
    
    /**
     * resizes the heap array if it reaches full capacity
     * @param array Original array
     * @return resized array
     */
    private T[] resize(T[] array) {
    	int newSize = 2*array.length;
    	T[] newArray = (T[]) new Comparable[newSize];
    	for(int i = 0; i < array.length; i++) {
    		newArray[i] = array[i];
    	}
    	return newArray;
    }

    /**
     * bubbles up the element at the index to its correct location in the heap
     * @param index Index of the element
     * @return the element
     */
    private T bubbleUp(int index) {
    	int parentInd = parent(index);
    	if(this.isMaxHeap) {
    		if(this.heap[index].compareTo(this.heap[parentInd]) <=0) {
        		return this.heap[index];
        	}
    	}
    	if(!this.isMaxHeap) {
    		if(this.heap[index].compareTo(this.heap[parentInd]) >=0) {
        		return this.heap[index];
        	}
    	}
    	this.swap(index, parentInd);
    	return bubbleUp(parentInd);
    }
    
    /**
     * Removes and returns the element at the root. If the heap is empty, then
     * this method throws a NoSuchElementException.
     *
     * @return The element at the root stored in the heap.
     * @throws NoSuchElementException if the heap is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
    	if(this.size() == 0) {
    		throw new NoSuchElementException();
    	}
        this.swap(0,this.size() -1);
        T root = this.heap[this.size() -1];
        this.heap[this.size() -1] = null;
        this.nelems--;
        T lastElement = trickleDown(0);
        return root;
    }
    
    /**
     * swap method
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
    	T temp = this.heap[index1];
    	this.heap[index1] = this.heap[index2];
    	this.heap[index2] = temp;
    }
    
    /**
     * trickles down the element at the index to its correct location in the heap
     * @param index Index of the element
     * @return the element
     */
    private T trickleDown(int index) {
    	int d = this.d;
    	int firstchild = d*index + 1;
    	int lastchild = d*index + d;
    	int maxchild = firstchild;
    	int minchild = firstchild;
    	for(int i = firstchild; i <= lastchild; i++) {
    		if(i >= this.nelems)
    			break;
    		if(this.heap[i] !=null && this.heap[i].compareTo(this.heap[maxchild]) > 0) {
    			maxchild = i;
    		}
    		if(this.heap[i] !=null && this.heap[i].compareTo(this.heap[minchild]) < 0) {
    			minchild = i;
    		}
    	}
    	if(firstchild >= this.nelems) {
    		return this.heap[index];
    	}
    	if(this.isMaxHeap) {
    		if(this.heap[index].compareTo(this.heap[maxchild]) >= 0) {
        		return this.heap[index];
        	}
    		this.swap(maxchild, index);
        	return trickleDown(maxchild);
    	}
    	else {
    		if(this.heap[index].compareTo(this.heap[minchild]) <= 0) {
        		return this.heap[index];
        	}
    		this.swap(minchild, index);
        	return trickleDown(minchild);
    	}
    }

    /**
     * Clears all the items in the heap Heap will be empty after this call
     * returns
     */
    @Override
    public void clear() {
        for(int i = 0; i < this.size(); i++) {
        	this.heap[i] = null;
        }
        this.nelems = 0;
    }

    /**
     * Retrieves, but does not remove, the element at the root.
     *
     * @return item at the root of the heap
     * @throws NoSuchElementException - if this heap is empty
     */
    @Override
    public T element() throws NoSuchElementException {
    	if(this.size() == 0)
    		throw new NoSuchElementException();
        return this.heap[0];
    }
}
