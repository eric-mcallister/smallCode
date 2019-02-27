package edu.ncsu.csc316.grocerystore2.manager;

import edu.ncsu.csc316.grocerystore2.customer.Customer;
import edu.ncsu.csc316.grocerystore2.io.CustomerFileReader;
import edu.ncsu.csc316.grocerystore2.io.OrderFileScanner;
import edu.ncsu.csc316.grocerystore2.list.ArrayBasedList;
import edu.ncsu.csc316.grocerystore2.map.ProductDictionary;

/**
 * This class is tasked with gathering all the information from the files using 
 * the reader classes and creating a management system of all the information together
 * @author Eric W. McAllister
 *
 */
public class GroceryStoreManager {
	/** This is the list containing the customers*/
	public ArrayBasedList<Customer> customerList = new ArrayBasedList<Customer>();
	/** This is the list containing the products */
	public ProductDictionary productDictionary = new ProductDictionary();
    /**
	 * Constructs a new GroceryStoreManager object using
	 * the two input files of customers and products
	 * 
	 * @param pathToProductFile - the path to the product file
	 * @param pathToCustomerFile - the path to the customer file
	 */
	public GroceryStoreManager(String pathToProductFile, String pathToCustomerFile)
	{
		CustomerFileReader reader = new CustomerFileReader(pathToCustomerFile);
		OrderFileScanner reader2 = new OrderFileScanner(pathToProductFile);
		customerList = reader.returnList();
		productDictionary = reader2.getDictionary();
	}
    /**
	 * Returns the list of customers sorted in ascending order by customer ID 
	 * as a String in the following format:
	 * 
	 * Customer [id=C0000473, company=Wigmann's, state=DE, zipcode=45272]
	 * Customer [id=C0000646, company=Super Food, state=CA, zipcode=22962]
	 * Customer [id=C0000679, company=Martino's, state=SD, zipcode=05989]
	 * ... and so on
	 * 
	 * @return the sorted list of customers
	 */
	public String getCustomers()
	{
		mergeSort(customerList);
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < customerList.size(); i++) {
			st.append(customerList.get(i).toString() + "\n");
		}
		return st.toString();
	}

    /**
	 * Returns the product as a String in the following format:
	 * Product [brand=Wolf, description=soda, frequency=698]
	 * 
	 * @param brand - the brand of the product to lookup
	 * @param description - the description of the product to lookup
	 * @return the full product information
	 */
	public String getProduct(String brand, String description)
	{
		return productDictionary.get(brand, description).toString();
		
	}
	
	
	/*
	* The code for this class is based on Data Structures Book for 316 and Java 216/116 book as well as lecture slides on merge sort
	*/
	private void mergeSort(ArrayBasedList<Customer> list) {
		if(list.size() >= 2) {
			int q = list.size() / 2;
			ArrayBasedList<Customer> left = new ArrayBasedList<Customer>();
			for(int i = 0; i <= q - 1; i++) {
				left.add(list.getArray()[i]);
			}
			ArrayBasedList<Customer> right = new ArrayBasedList<Customer>();
			for(int i = q; i <= list.size() - 1; i++) {
				right.add(list.getArray()[i]); 
			}
			mergeSort(left);
			mergeSort(right);
			
			merge(list, left, right);
		}
	}
	/*
	* The code for this class is based on Data Structures Book for 316 and Java 216/116 book as well as lecture slides on merge sort
	*/
	private void merge(ArrayBasedList<Customer> elements, ArrayBasedList<Customer> left, ArrayBasedList<Customer> right) {
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
