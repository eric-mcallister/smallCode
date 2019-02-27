package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
/**
 * Credit to Typos
 */
/**
 * Graph implementation to store relations of data 
 * 
 * @author Eric McAllister
 *
 * @param <V> - the data type for the vertices of a graph 
 * @param <E> - the data type for the edges of a graph 
 */
public class Graph<V extends Comparable<V>, E extends Comparable<E>> {
	/** A list of all the vertices in the graph*/
	public ArrayBasedList<Vertex<V>> vertices;
	/** A list of all the edges in the graph*/
	public ArrayBasedList<WeightedEdge<V, E>> edges;
	/**
	 * Constructor for the graph object
	 */
	public Graph() {
		this.vertices = new ArrayBasedList<Vertex<V>>();
		this.edges = new ArrayBasedList<WeightedEdge<V, E>>();
	}
	/**
	 * Inserts an edge into the graph 
	 * Adds vertices to the graph - no need to add vertices method
	 * @param edge - edge to be inserted in the graph
	 */
	public void insertEdge(WeightedEdge<V, E> edge) {
		Vertex<V> v1 = edge.v1;
		Vertex<V> v2 = edge.v2;
		
		if(!vertices.contains(v1)) {
			vertices.add(v1);
		}
		v1 = vertices.get(vertices.indexOf(v1));
		
		if(!vertices.contains(v2)) {
			vertices.add(v2);
		}
		v2 = vertices.get(vertices.indexOf(v2));
		
		if (!edges.contains(edge))
			edges.add(edge);
		
		if(!v1.neighbors.contains(v2))
			v1.neighbors.add(v2);
		if(!v2.neighbors.contains(v1))
			v2.neighbors.add(v1);
	} 
	/**
	 * Getter for the number of vertices
	 * @return - the number of vertices 
	 */
	public int numOfVertices() {
		return vertices.size();
	}
	/**
	 * Getter for the number of the edges 
	 * @return - the number of edges in the list 
	 */
	public int numOfEdges() {
		return edges.size();
	}
	
}
