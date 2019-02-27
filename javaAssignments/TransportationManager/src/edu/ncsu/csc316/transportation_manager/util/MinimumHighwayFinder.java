package edu.ncsu.csc316.transportation_manager.util;
import edu.ncsu.csc316.transportation_manager.heap.MinHighwayHeap;
import edu.ncsu.csc316.transportation_manager.highway.City;
import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.set.Graph;
import edu.ncsu.csc316.transportation_manager.set.UpTree;
import edu.ncsu.csc316.transportation_manager.set.UpTreeNode;
import edu.ncsu.csc316.transportation_manager.set.WeightedEdge;
/**
 * Credit CSC316 Lecture Slides & Mr.Gaweda
 */
/**
 * This class finds the best path between a list of highways 
 * It implements Kruskal's algorithm 
 * @author Eric McAllister
 *
 */
public class MinimumHighwayFinder {
	/** List of highways*/
	private ArrayBasedList<Highway> minList; 
	/**
	 * Method that does Kruskal's algorithm to find the best 
	 * highway connection options 
	 * @param type - the type to compare the highways by 
	 * @param list - an arraylist full of highways 
	 */
	public MinimumHighwayFinder(String type, ArrayBasedList<Highway> list) {
		minList = new ArrayBasedList<Highway>();
		Graph<City, Highway> g = new Graph<City, Highway>();
		MinHighwayHeap heap = new MinHighwayHeap(type);
		UpTree<String, Integer> upTree = new UpTree<String, Integer>();
		ArrayBasedList<UpTreeNode<String, Integer>> roadMap = new ArrayBasedList<UpTreeNode<String, Integer>>();
		for(int i = 0; i < list.size(); i++) {
			WeightedEdge<City, Highway> edge = new WeightedEdge<City, Highway>(list.get(i).getU(), list.get(i).getV(), list.get(i));
			g.insertEdge(edge);
			heap.insert(edge.weight);
		}
		for(int i = 0; i < g.vertices.size(); i++) {
			roadMap.add(g.vertices.get(i).value.cityAddress, g.vertices.get(i).value.node);
		}
		int components = g.numOfVertices();
		while (components > 1) {
			Highway way = heap.deleteMin();
			//Get city address here
			UpTreeNode<String, Integer> node = roadMap.get(way.getU().cityAddress);
			UpTreeNode<String, Integer> node2 = roadMap.get(way.getV().cityAddress);
			if(!node.sameParent(node2)) {
				upTree.union(node, node2);
				minList.add(way);
				components = components - 1; 
			}
		}		
//		Algorithm KruskalMST(graph 𝐺):
//		E ← ∅     (done with minList) 
//		components ← |V| // # of vertices in 𝐺	
//		H ← empty heap
//		for each edge 𝑒 ∈ 𝐺 do
//			H.insert(𝑒) // Orders edges per heap structure
//		while components > 1 do
//			e ← H.removeMin() // remove e (u,v) from 𝐻
//			U ← find(e.u) // root vertex of e.u
//			V ← find(e.v) // root vertex of e.v
//			if 𝑈 ≠ 𝑉 then // check for a cycle
//				union(𝑈, 𝑉)
//				ET ← ET ∪ e
//				components ← components-1
//		return 𝐸
//	
		}
	/**
	 * Turns class into a string representation
	 * @return string representation of the class
	 */
	public String toString() {
		mergeSort(minList); 
		StringBuilder sb = new StringBuilder();
		sb.append("List[\n");
		for(int i = 0; i < minList.size() - 1; i++) {
			sb.append("   " + minList.get(i).toString() + ",\n");
		}
		sb.append("   " + minList.get(minList.size() - 1) + "\n]");
		return sb.toString();
	}
	/**
	 * Credit *Project 1
	 */
	/**
	 * Merge-sort to sort the list of highways after all connections are found
	 * @param list - list to be sorted
	 */
	private void mergeSort(ArrayBasedList<Highway> list) {
		if(list.size() >= 2) {
			int q = list.size() / 2;
			ArrayBasedList<Highway> left = new ArrayBasedList<Highway>();
			for(int i = 0; i <= q - 1; i++) {
				left.add(list.getArray()[i]);
			}
			ArrayBasedList<Highway> right = new ArrayBasedList<Highway>();
			for(int i = q; i <= list.size() - 1; i++) {
				right.add(list.getArray()[i]); 
			}
			mergeSort(left);
			mergeSort(right);
			
			merge(list, left, right);
		}
	}
	/**
	 * Credit *Project 1
	 */
	/**
	 * Merge sort helper method
	 * @param elements - elements in the full list
	 * @param left - the left side of the list 
	 * @param right - the right side of the list
	 */
	private void merge(ArrayBasedList<Highway> elements, ArrayBasedList<Highway> left, ArrayBasedList<Highway> right) {
		int a = 0;
		int b = 0;
		for(int i = 0; i < elements.size(); i++) {
			if(b >= right.size() || (a < left.size() && left.get(a).compareTo(right.get(b)) < 0)) {
				elements.getArray()[i] = left.get(a);
				a++;
			} else {
				elements.getArray()[i] = right.get(b);
				b++;
			}
		}
	}
}
