package edu.ncsu.csc316.transportation_manager.ui;

import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.manager.TransportationManager;
/**
 * UI class to run software
 * @author Eric McAllister
 *
 */
public class TransportationManagerUI {
	/**
	 * Main driver method 
	 * @param args - empty 
	 */
	public static void main(String args[]) {
		System.out.println("Welcome to Transportation Manager");
		System.out.print("Filename: ");
		Scanner scan = new Scanner(System.in);
		String filename = "";
		try {
			filename = scan.nextLine();
		} catch (Exception e) {
			System.out.println("Error in input");
			System.exit(0);
		}
		System.out.println("Choose an option: \n\t1: Create Adjacency List \n\t2: Create Minimum Highway List\n\t3: Exit\n");
		int choice = scan.nextInt();
		String type = "";
		switch (choice) {
			case 1: 
					try {
						TransportationManager manager = new TransportationManager(filename);
						System.out.print(manager.getAdjacencyList() + "\n");
					} catch (Exception e) {
						System.out.println("Something went wrong with the files");
					}
					System.out.println("");
					System.out.println("You're Welcome - Goodbye");
					break;
			case 2: 
					System.out.print("Sort by 'COST' - Cost or 'ASPHALT' - Asphalt: \n\tChoice: ");
					type = scan.next().toUpperCase();
					try {
						TransportationManager manager = new TransportationManager(filename);
						System.out.println(manager.getMinimumHighways(type));
						System.out.println("Would you like to do the other operation now? \n 'Y' or 'N' ? ");
						String yesOrNo = scan.next();
						if(yesOrNo.equals("N")) {
							System.out.println();
							System.out.println("You're Welcome - Goodbye");
							System.exit(0);
						}
						else if(yesOrNo.equals("Y") && type.equals("COST")) {
							System.out.println(manager.getMinimumHighways("ASPHALT"));
							System.out.println();
							System.out.println("Thank you - Goodbye");
							System.exit(0);
						} else {
							System.out.println(manager.getMinimumHighways("COST"));
							System.out.println();
							System.out.println("Thank you - Goodbye");
							System.exit(0);
						}
					} catch (Exception e) {
						System.out.println("Error - exiting");
						System.exit(0);
					}
					break;
			case 3:
					System.out.println("Thank you - Goodbye");
					System.exit(0);
					break;
			default: 
					System.out.println("Error - exiting");
					System.exit(0);
		}
		scan.close();
			
	}
}
