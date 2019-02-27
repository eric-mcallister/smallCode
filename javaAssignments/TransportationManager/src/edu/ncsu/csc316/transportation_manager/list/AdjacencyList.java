package edu.ncsu.csc316.transportation_manager.list;

import java.util.Iterator;

import edu.ncsu.csc316.transportation_manager.heap.Heap;
import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * List containing the connections between highways
 * @author Eric McAllister
 *
 */
public class AdjacencyList { 
	/** Array of linkedList to store values efficiently */
	private LinkedList<Highway> vertexList[]; 
	
	/**
	 * Creates an ArrayBasedList the size of the list. The max number the ArrayBasedList should reach. 
	 * Then initialize each part
	 * @param list - the input list for the adjacency list
	 */
	@SuppressWarnings("unchecked")
	public AdjacencyList(ArrayBasedList<Highway> list) {
		vertexList = new LinkedList[list.size()];
		for (int i = 0; i < list.size(); i++) {
			vertexList[i] = new LinkedList<Highway>();
		}
		for(int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}
	/**
	 * Adds a highway to the list
	 * @param highway - the highway to produce
	 */
	public void add(Highway highway) {
		//Attempting to order as I addS
//		if(vertexList[highway.highwayData()[0]] != null) {
//			Heap<Integer, Highway> heap = new Heap<Integer, Highway>();
//			for(int i = 0; i < vertexList[highway.highwayData()[0]].size(); i++) {
//				Iterator<Highway> itr = vertexList[highway.highwayData()[0]].iterator();
//				while(itr.hasNext()) {
//					Highway a = itr.next();
//					heap.insert(a.highwayData()[0], a);
//				}
//			}
//			for(int i = 0; i < heap.size(); i++) {
//				Highway way = heap.removeMin().data;
//				vertexList[highway.highwayData()[0]].add(way);
//			}
//		}
		vertexList[highway.highwayData()[0]].add(highway);
		vertexList[highway.highwayData()[1]].add(highway);
	}
	/**
	 * Orders the vertex list in a way that there are no null values
	 * @return - vertex without any null values 
	 */
	public LinkedList<Highway>[] getVertexList() {
		@SuppressWarnings("unchecked")
		LinkedList<Highway> newList[] = new LinkedList[vertexList.length];
		int count = 0;
		//
		for(int i = 0; i < vertexList.length - 1; i++) {
			if(vertexList[i].isEmpty()) {
				continue; 
			} else {
				newList[count] = vertexList[i];
				count = count + 1;
			}
		}
		return newList;
	}
	/**
	 * ToString method that turns the list into an order using a heap Sort
	 * @return a representation of the list as a string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		vertexList = getVertexList();
		sb.append("AdjacencyList[\n");
		for(int i = 0; i < vertexList.length; i++) {
			if(vertexList[i] == null) { break; }
			Iterator<Highway> itr = vertexList[i].iterator();
			Heap<Highway, Integer> heap = new Heap<Highway, Integer>();
			while(itr.hasNext()) {
				Highway a = itr.next(); 
				heap.insert(a, a.highwayData()[0]);
			}
			sb.append("   City ");
			sb.append(String.valueOf(i) + ":");
			while(heap.size() != 0) {
				sb.append(" -> ");
				sb.append(heap.removeMin().priority.toString());
			}
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
