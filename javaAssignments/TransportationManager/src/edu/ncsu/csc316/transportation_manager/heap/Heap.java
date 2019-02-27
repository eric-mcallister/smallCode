package edu.ncsu.csc316.transportation_manager.heap;
/**
 * Credit to Typos 
 */
/**
 * Class that implements the heap data structure
 * 
 * @author Eric McAllister
 *
 * @param <K> - Data type for the key for the heap 
 * @param <E> - Data type for the data in the heap 
 */
public class Heap<K extends Comparable<K>, E> {
	private int levels = 10;
	private int capacity = (int)Math.pow(2, levels);
	private int next = 0;
	private int size;
	private Object[] tree = new Object[capacity];
	/**
	 * Constructor that sets the size of the heap to zero 
	 */
	public Heap() {
		size = 0;
	}
	/**
	 * Returns the size of the heap 
	 * @return - the integer value of the size of the heap
	 */
	public int size() {
		return size; 
	}
	
	/**
	 * Returns the data at the given index 
	 * @param i - the index to lookup in the array 
	 * @return - the node at that position 
	 */
	@SuppressWarnings("unchecked")
	public HeapNode<K, E> get(int i) {
		if (i >= size)
			return null;
		return (HeapNode<K, E>) tree[i];
	}
	
	/**
	 * Adds a new element into the heap 
	 * @param priority - the priority to order the element 
	 * @param element - the element being added to the heap 
	 */
	@SuppressWarnings("unchecked")
	public void insert(K priority, E element) {
		HeapNode<K, E> newNode = new HeapNode<K, E>(priority, element);
		tree[next] = newNode;
		bubbleUp(next);
		next = next + 1;
		
		if (next == (capacity - 100)) {
			levels = levels * 2;
			capacity = (int)Math.pow(2, levels);
			Object[] temp = new Object[capacity];
			for (int i = 0; i < tree.length; i++) {
				temp[i] = (HeapNode<K, E>) tree[i];
			}
			tree = temp;
		}
		size++; 
	}

	@SuppressWarnings("unchecked")
	/**
	 * Private method that reorders the heap when an element is added 
	 * @param i - the position to start the bubble up
	 */
	private void bubbleUp(int i) {
		while (i > 0 && ((HeapNode<K, E>) tree[(i - 1) / 2]).compareTo((HeapNode<K, E>) tree[i]) > 0) {
			HeapNode<K, E> temp = (HeapNode<K, E>)tree[(i - 1) / 2];
			tree[(i - 1) / 2] = tree[i];
			tree[i] = temp;
			i = (i - 1) / 2;
		}
	}

	
	/**
	 * Removes the top of the list or the lowest value 
	 * @return - the top of the heap 
	 */
	@SuppressWarnings("unchecked")
	public HeapNode<K, E> removeMin() {
		if(next == 0) return null;
		HeapNode<K, E> root = (HeapNode<K, E>)tree[0];
		if(next == 1) {
			tree[0] = null;
		} else {
			Object[] newTree = new Object[tree.length];
			newTree[0] = tree[next - 1];
			for (int i = 1; i < next - 1; i++) {
				newTree[i] = (HeapNode<K, E>)tree[i];
			}
			tree = newTree;
		}
		next = next - 1;
		bubbleDown(0);
		size--;
		return root;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Private method to reorder list after min is removed 
	 * @param i - always is going to be 0 because remove only takes top of heap --> 0 
	 */
	private void bubbleDown(int i) { 
		while((2 * i) + 1 < next) {
			int j = (2 * i) + 1;
			HeapNode<K, E> self = (HeapNode<K, E>) tree[i];
			HeapNode<K, E> leftChild = (HeapNode<K, E>) tree[j];
			HeapNode<K, E> rightChild = (HeapNode<K, E>) tree[j + 1];
			if (j < next - 1 && (leftChild.compareTo(rightChild) > 0))
				j++;
			HeapNode<K, E> childToCompare = (HeapNode<K, E>) tree[j];
			if (self.compareTo(childToCompare) < 0)
				break;
			HeapNode<K, E> temp = (HeapNode<K, E>)tree[j];
			tree[j] = tree[i];
			tree[i] = temp;
			i = j;
		}
	}
}
