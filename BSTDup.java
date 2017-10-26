/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw3;

import java.util.*;

/**
 * BSTDup implementation
 * 
 * @author Kavita Jain
 * @version 1.0
 * @since 7/22/17
 */
public class BSTDup<T> {

	private int nelems;
	private BSTDupNode root;

	protected class BSTDupNode {

		private int key;
		private ArrayList<T> elements;
		private BSTDupNode left;
        private BSTDupNode right;

		public BSTDupNode(int key, T elem, BSTDupNode left, BSTDupNode right) {
			
			this.key = key;
			this.elements = new ArrayList<T>();
			this.elements.add(elem);
			this.left = left;
			this.right = right;
			
		}
		
		public int getKey() {
			return this.key;
		}
		
		public BSTDupNode getLeft() {
			return this.left;
		}
		
		public BSTDupNode getRight() {
			return this.right;
		}
		
		public ArrayList<T> getElements() {
			return this.elements;
		}
		
		public void setLeft(BSTDupNode newLeft) {
			this.left = newLeft;
		}
		
		public void setRight(BSTDupNode newRight) {
			this.right = newRight;
		}
		
		public void addElement(T element) {
			this.elements.add(element);
		}
		
	}
	
	/**
	 * constructor for BSTDup
	 */
	public BSTDup() {
		this.nelems = 0;
		this.root = null;
	}
	
	/**
	 * accessor for root of BST
	 * @return BST root
	 */
	public BSTDupNode getRoot() {
		return this.root;
	}
	
	/**
	 * accessor for size of BST
	 * @return BST size
	 */
	public int getSize() {
		return this.nelems;
	}
	
	/**
	 * inserts key-value pair into BST
	 * @param key
	 * @param element
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if the same key-value pair already is present in the tree
	 */
	public void insert(int key, T element) {
		if(element == null)
			throw new NullPointerException("element is null");
		if(this.root == null) {
			this.root = new BSTDupNode(key,element,null,null);
		}
		else
			addHelper(this.root,key,element);
		this.nelems++;
	}
	
	private void addHelper(BSTDupNode currNode, int key, T element) {
		
		if(currNode.getKey() == key) {
			for(int i = 0; i < currNode.elements.size();i++) {
				if(currNode.elements.get(i)== element)
					throw new IllegalArgumentException();
			}
			currNode.addElement(element);
		}
		else if(key < currNode.getKey()) {
			if(currNode.getLeft() == null) {
				currNode.setLeft(new BSTDupNode(key,element,null,null));
			}
			else {
				addHelper(currNode.getLeft(),key,element);
			}
		}
		else if(key > currNode.getKey()) {
			if(currNode.getRight() == null) {
				currNode.setRight(new BSTDupNode(key,element,null,null));
			}
			else {
				addHelper(currNode.getRight(),key,element);
			}
		}
	}
	
	/**
	 * Returns true if the key-value pair is present in the tree, false otherwise.
	 * @param key
	 * @param element
	 * @return true or false
	 */
	public boolean findPair(int key, T element) {
		return findPairHelper(this.root,key,element);
	}
	
	private boolean findPairHelper(BSTDupNode currNode, int key, T element) {
		
		if(currNode == null) {
			return false;
		}
		else if(currNode.getKey() == key) {
			for(int i = 0; i < currNode.elements.size();i++) {
				if(currNode.elements.get(i)== element)
					return true;
			}
			return false;
		}
		else if(key < currNode.getKey()) {
			if(currNode.getLeft() == null) {
				return false;
			}
			else {
				currNode = currNode.getLeft();
				return findPairHelper(currNode, key,element);
			}
		}
		else {
			if(currNode.getRight() == null) {
				return false;
			}
			else {
				currNode = currNode.getRight();
				return findPairHelper(currNode, key,element);
			}
		}
	}
	
	/**
	 * Accessor for all elements stored with the specified key
	 * @param key
	 * @return ArrayList of elements
	 * @throws IllegalArgumentException if key is not present in the tree
	 */
	public ArrayList<T> getElements(int key){
		return getElementsHelper(this.root,key);
	}
	
	private ArrayList<T> getElementsHelper(BSTDupNode currNode, int key){
		
		if(currNode.getKey() == key) {
			return currNode.elements;
		}
		else if(key < currNode.getKey()) {
			if(currNode.getLeft() == null) {
				throw new IllegalArgumentException();
			}
			else {
				currNode = currNode.getLeft();
				return getElementsHelper(currNode,key);
			}
		}
		else {
			if(currNode.getRight() == null) {
				throw new IllegalArgumentException();
			}
			else {
				currNode = currNode.getRight();
				return getElementsHelper(currNode,key);
			}
		}
	}
	
	/**
	 * Calculates the height of the tree, returns -1 if the tree is empty
	 * @return height 
	 */
	public int getHeight() {
		
		int height = -1;
		if(this.root == null)
			return height;
		return getHeightHelper(this.root,0);
		
	}
	
	private int getHeightHelper(BSTDupNode currNode, int height) {
		int height1 = 0;
		int height2 = 0;
		if(currNode.getLeft() != null)
			height1 = getHeightHelper(currNode.getLeft(),height+1);
		if(currNode.getRight() !=null)
			height2 = getHeightHelper(currNode.getRight(),height+1);
		if(currNode.getLeft() == null & currNode.getRight() ==null)
			return height;
		if(height1 > height2)
			return height1;
		else if (height2 > height1)
			return height2;
		else
			return height1;
			
	}
	
	/**
	 * Calculates the number of leaves on the tree.
	 * @return number of leaves
	 */
	public int leafCount() {
		int count = 0;
		if(this.root == null)
			return count;
		return getLeafCountHelper(this.root);
	}
	
	private int getLeafCountHelper(BSTDupNode currNode) {
		
		int count1 = 0;
		int count2 = 0;
		if(currNode.getLeft() != null)
			count1 = getLeafCountHelper(currNode.getLeft());
		if(currNode.getRight() !=null)
			count2= getLeafCountHelper(currNode.getRight());
		if(currNode.getLeft() == null & currNode.getRight() ==null)
			return 1;
		return count1 + count2;
		
	}
	
	/**
	 * Prints and returns the keys only in post-order traversal. 
	 * @return int[] of the keys
	 */
	public int[] postOrder() {
		int[] array = new int[this.nelems];
		int i = 0;
		MyStack<BSTDupNode> stack = new MyStack<>();
		BSTDupNode currNode = this.root;
		stack.addElement(currNode);
		while(currNode.getLeft() != null) {
			stack.addElement(currNode.getLeft());
			currNode = currNode.getLeft();
		}
		array[i] = currNode.getKey();
		while(!stack.isEmpty()) {
			stack.removeElement();
			currNode = stack.peek();
			if(currNode.getRight() != null)
				stack.addElement(currNode.getRight());
				array[++i] = currNode.getRight().getKey();
			array[++i] = currNode.getKey();
		}
		return array;
	}
	
	/**
	 * Prints and returns the keys only in breadth-first search order
	 * @return int[] of the keys
	 */
	public int[] bfs() {
		int[] array = new int[this.nelems];
		int i = 0;
		MyQueue<BSTDupNode> queue = new MyQueue<>();
		BSTDupNode currNode = this.root;
		queue.addElement(currNode);
		while (!queue.isEmpty()) {
			currNode = queue.removeElement();
			array[i] = currNode.getKey();
			System.out.print(array[i]+" ");
			i++;
			if (currNode.getLeft() != null)
				queue.addElement(currNode.getLeft());
			if (currNode.getRight() != null)
				queue.addElement(currNode.getRight());
		}
		return array;
	}
	
}