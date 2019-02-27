package edu.ncsu.csc316.grocerystore2.map;

import java.util.Iterator;

import edu.ncsu.csc316.grocerystore2.list.LinkedList;
import edu.ncsu.csc316.grocerystore2.order.Product;
/**
 * Dictionary to find products 
 * @author Eric Mcallister
 *
 */
public class ProductDictionary {
	/** Array of linked list */
	private LinkedList<Product>[] dict;
	/** The max capacity for the array*/
	public final static int CAPACITY = 10000;
	/** The current amount of items in the array*/
	private int size; 
	/**
	 * Constructor for the product dictionary
	 */
	@SuppressWarnings("unchecked")
	public ProductDictionary() {
		dict = new LinkedList[CAPACITY];
		for(int i = 0; i < CAPACITY; i++) {
			dict[i] = new LinkedList<Product>();
		}
		size = 0;
	}
	/**
	 * Adds a product to the dictionary 
	 * @param p - the product to add
	 */
	public void add(Product p) {
		if(p.getPosition() > CAPACITY) {
			throw new IllegalArgumentException();
		}
		if(dict[p.getPosition()].size() == 0) {
			dict[p.getPosition()].add(p);
			size = size + 1;
		} else {
			LinkedList<Product> list = dict[p.getPosition()];
			Iterator<Product> itr = list.iterator();
			boolean spotFound = false;
			while(!spotFound) {
				Product found = itr.next();
				if(p.compareTo(found) == 0) {
					found.incrementFrequency();
					size = size + 1;
					spotFound = true; 
				} else if(!itr.hasNext()){
					dict[p.getPosition()].add(p);
					spotFound = true;
					size = size + 1;
				}
			}
		}
	}
	/**
	 * Returns a product from the dictionary given it's brand and description
	 * @param brand - the name of the product 
	 * @param description - the product's description 
	 * @return - the product information
	 */
	public Product get(String brand, String description) {
		Product search = new Product(brand, description);
		LinkedList<Product> list = dict[search.getPosition()];
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product found = itr.next();
			if(found.compareTo(search) == 0) {
				return found;
			}
		}
		return null;
	}
	/**
	 * Returns the size of the dictionary 
	 * @return - the size
	 */
	public int size() {
		return size;
	}
	
	
	
}
