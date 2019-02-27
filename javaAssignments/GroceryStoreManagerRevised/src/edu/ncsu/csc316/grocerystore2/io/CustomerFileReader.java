package edu.ncsu.csc316.grocerystore2.io;

import java.io.FileInputStream;
import java.util.Scanner;

import edu.ncsu.csc316.grocerystore2.customer.Customer;
import edu.ncsu.csc316.grocerystore2.list.ArrayBasedList;

/**
 * This class is tasked with reading a file and putting the Customers into an arrayList based on
 * the information given in the file 
 * @author Eric W. McAllister
 *
 */
public class CustomerFileReader {
	/** This is a private variable that represents the object that will become the list storing customers*/
	private ArrayBasedList<Customer> list;
	/** 
	 * This class is tasked with reading the input file and returning the list of full customers
	 * @param filename - this is the name of the file to be read 
	 */
	
	public CustomerFileReader(String filename) {
		list = new ArrayBasedList<Customer>();
		readFile(filename);
	}
	
	private ArrayBasedList<Customer> readFile(String filename) {
		try {
			Scanner scan = new Scanner(new FileInputStream(filename), "UTF8");
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				list.add(processLine(line));
			}
			scan.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Error 404: File not found");
		}
		return list;
	}
	/**
	 * This is a private method tasked with processing a single line of information 
	 * @param line - this is the line that is going to be process 
	 * @return cus - this is the customer created from the information in the file
	 */
	private Customer processLine(String line) {
		line = line.replace("\t", "");
		String[] items = line.split(",");
		Customer cus = new Customer(items[0].trim(), items[1].trim(), items[2].trim(), items[3].trim());
		return cus;
	}
	/**
	 * This is going to return the list of data back out into the other classes	
	 * @return - list of processed data
	 */
	public ArrayBasedList<Customer> returnList() {
		return list;
	}
}