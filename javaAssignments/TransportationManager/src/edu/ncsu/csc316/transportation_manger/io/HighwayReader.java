package edu.ncsu.csc316.transportation_manger.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Reader class to go through highways to create list of those highways 
 * @author Eric McAllister
 *
 */
public class HighwayReader {
	/** ArrayList to store Highways to be passed along */
	private ArrayBasedList<Highway> list; 
	/**
	 * Constructor that takes a filename and creates a list from file
	 * @param filename - the file that it is going to get the information from
	 */
	public HighwayReader(String filename) {
		list = new ArrayBasedList<Highway>();
		readFile(filename);
	}
	/**
	 * Method to read the file called in my the constructor 
	 * @param filename - the name of the file 
	 */
	private void readFile(String filename) {
		try {
			Scanner input = new Scanner(new FileInputStream(filename), "UTF8");
			while(input.hasNextLine()) {
				String line = input.nextLine();
				list.add(parseLine(line));
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not able to be reached");
		}
	}
	/**
	 * Method to read a single line from the file 
	 * @param line - the line that is being read in 
	 * @return - a highway object that will be added to the list 
	 */
	private Highway parseLine(String line) {
		line = line.trim();
		Scanner scan = new Scanner(line);
		Highway path = new Highway(scan.nextInt(), scan.nextInt(), scan.nextDouble(), scan.nextDouble());
		scan.close();
		return path; 
	}
	/**
	 * Getter method that will return the list with all values added 
	 * @return - the list with values from a file
	 */
	public ArrayBasedList<Highway> getList() {
		return list;
	}
}
