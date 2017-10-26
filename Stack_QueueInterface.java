package hw3;

interface Stack_QueueInterface<T> {

    /**
     * Tests if the storage is empty.
     *
     * @return true a storage contains no items; false otherwise.
     */
    public boolean isEmpty();

    /**
     * Adds an element to a storage
     *
     * @param newItem - item to be added
     * @throws NullPointerException if the specified element is null
     */
    public void addElement(T newItem);

    /**
     * Removes the object from the storage and returns that object as the value
     * of this function.
     *
     * @return value of the removed object or null if the size was zero.
     * @throws NullPointerException if the list is empty
     */
    public T removeElement();

    /**
     * Returns the number of items in the storage
     *
     * @return the number of items in the storage
     */
    public int size();

    /**
     * Returns the next item to be removed
     *
     * @return element to be removed next or null if the size was zero.
     * @throws NullPointerException if the list is empty
     */
    public T peek();
}
