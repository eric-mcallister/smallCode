package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.util.Type;
/**
 * Credit to Typos 
 */
/**
 * A heap that will be used to quickly find the minimum highway
 * @author Eric McAllister
 *
 */
public class MinHighwayHeap {
	/** Creates heap object to do heap insertions*/
	private Heap<Double, Highway> heap;
	/** Boolean variable to determine if to get cost or asphalt*/
	private boolean getCost;

	/**
	* Constructs a new Highway heap
	* 
	* @param type the type of weight to consider ("COST" or "ASPHALT") when
	*         operating on the heap
	*/
	public MinHighwayHeap(String type) {
	    Type t1 = Type.ASPHALT;
	    Type t2 = Type.COST;
	    if(type.equals(t1.name())) {
	    	getCost = false;
	    } else if(type.equals(t2.name())) {
	    	getCost = true; 
	    }
	    heap = new Heap<Double, Highway>();
	}
	/**
	 * Getter method for the size 
	 * @return - the size of the heap
	 */
	public int size() {
		return heap.size();
	}
	
	/**
	 * Inserts the given Highway into the minheap
	 * @param hwy the Highway to insert into the minheap
	 */
	public void insert(Highway hwy) {
		if(getCost) {
			heap.insert(hwy.getCost(), hwy);
		} else {
			heap.insert(hwy.getAsphalt(), hwy);
		}
	}
	/**
	 * Returns the Highway with minimum weight in the minheap
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin() {
		return heap.removeMin().data;
	}
	/**
	 * Returns a string representation of the level-order traversal 
	 * of the heap in the following format:
	 * 
	 * Heap[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Heap[\n");
		for(int i = 0; i < heap.size() - 1; i++) {
			sb.append("   " + heap.get(i).data.toString() + ",\n");
		}
		sb.append("   " + heap.get(heap.size() - 1).data.toString() + "\n]");
		return sb.toString();
	} 
	
}
