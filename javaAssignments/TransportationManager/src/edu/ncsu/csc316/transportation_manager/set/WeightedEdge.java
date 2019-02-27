package edu.ncsu.csc316.transportation_manager.set;
/**
 * Credit to Typos
 */
/**
 * Edge class for the graph 
 * @author Eric McALlister
 *
 * @param <V> - the data type of two vertices 
 * @param <E> - the weight of the two vertices 
 */
public class WeightedEdge<V extends Comparable<V>, E extends Comparable<E>>
								implements Comparable<WeightedEdge<V, E>> {
	/** The weight of the edge*/ 
	public E weight; 
	/** The first vertex in the edge*/
	public Vertex<V> v1;
	/** The second vertex in the edge*/
	public Vertex<V> v2; 
	/**
	 * Constructor setting the vertices and edge weight 
	 * @param v1 - the first vertex 
	 * @param v2 - the second vertex 
	 * @param weight - the weight between the two vertices 
	 */
	public WeightedEdge(Vertex<V> v1, Vertex<V> v2, E weight) {
		this.v1 = v1; 
		this.v2 = v2; 
		this.weight = weight; 
	}
	/**
	 * The weighted edge for the graph 
	 * @param v1 - the first vertex 
	 * @param v2 - the second vertex 
	 * @param weight - the weight of the edge between them
	 */
	public WeightedEdge(V v1, V v2, E weight) {
		this.v1 = new Vertex<V>(v1);
		this.v2 = new Vertex<V>(v2);
		this.weight = weight;
	}
	
	@Override
	/**
	 * A compareTo method for a weightedEdge 
	 * @return the value of the weighted edge compared to another edge
	 */
	public int compareTo(WeightedEdge<V, E> o) {
		return weight.compareTo(o.weight);
	}

}
