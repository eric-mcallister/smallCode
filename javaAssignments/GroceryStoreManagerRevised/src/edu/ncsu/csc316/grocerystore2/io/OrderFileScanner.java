package edu.ncsu.csc316.grocerystore2.io;

import java.io.FileInputStream;
import java.util.Scanner;

import edu.ncsu.csc316.grocerystore2.map.ProductDictionary;
import edu.ncsu.csc316.grocerystore2.order.Product;
/**
 * File to read the orders coming in 
 * @author Eric McAllister
 *
 */
public class OrderFileScanner {
	
	private ProductDictionary dictionary;
	/**
	 * Method for reading in the file
	 * @param filename - the name of the file
	 */
	public OrderFileScanner(String filename) {
		dictionary = new ProductDictionary();
		scanFile(filename);
	}

	private void scanFile(String filename) {
		try {
			Scanner scan = new Scanner(new FileInputStream(filename), "UTF8");
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				Product product = processLine(line);
				dictionary.add(product);
			}
			scan.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("File Issues");
		}
	}

	private Product processLine(String line) {
		Scanner input = new Scanner(line);
		String brand = input.next();
		String description = input.nextLine();
		description = description.replaceAll("\\s+", " ").trim();
		Product pro = new Product(brand, description);
		input.close();
		return pro;
	}
	/**
	 * Getter method for the dictionary 
	 * @return - the dictionary 
	 */
	public ProductDictionary getDictionary() {
		return dictionary; 
	}
	
}
