package edu.ncsu.csc316.transportation_manager.manager;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.util.MinimumHighwayFinder;
import edu.ncsu.csc316.transportation_manger.io.HighwayReader;
/**
 * Method to call all the parts together to output into the UI
 * @author Eric McAllister
 *
 */
public class TransportationManager {

	/** List to store values from input file*/
	private ArrayBasedList<Highway> list; 
	/**
	 * Constructs a new TransportationManager
	 * 
	 * @param pathToFile the path to the file that contains the set of highways in the graph
	 */
	
	public TransportationManager(String pathToFile)
	{
		HighwayReader reader = new HighwayReader(pathToFile);
		list = reader.getList();
	}
	/**
	 * Javadoc does not like the arrows below - not fixed because write-up said method as given was required 
	 */
	/**
	 * Returns a string representation of the AdjacencyList
	 * in the following format, where (for each city) the Highways are
	 * in sorted order by city1, then city2, then cost, then asphalt:
	 * 
	 * AdjacencyList[
	 *    City 0: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 1: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 2: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 3: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @return the string representation of the AdjacencyLists
	 */
	public String getAdjacencyList()
	{
		AdjacencyList adj = new AdjacencyList(list);
		return adj.toString();
	}
	/**
	 * Returns a string representation of the list of Highways contained in the 
	 * minimum spanning set of Highways. The returned string is in the following format,
	 * where the Highways are in sorted order by city1, city2, then cost, then asphalt:
	 * 
	 * List[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @param type the type ("COST" or "ASPHALT") of field to minimize
	 * @return a string representation of the minimum spanning set of Highways
	 */
	public String getMinimumHighways(String type)
	{
		MinimumHighwayFinder finder = new MinimumHighwayFinder(type, list);
		return finder.toString();
	}
}
