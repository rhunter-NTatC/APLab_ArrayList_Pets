package pets;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/*
 * Pet Runner
 * 
 * This class creates a menu for tracking a list of pets
 * You will be completing the beginning of the main method
 * and the rest of the other methods
 * 
 * Instructions
 * https://docs.google.com/document/d/17oD1yQ5CYeWiw7cQF4BIxXCMqkCPTFkEIZLzDvpw3m4/edit#
 * 
 */

public class PetRunner {
	
	
	public static void main(String[] args) {

		// #1 create Pet object called pet. Use

		
		// create an Array List called pets to store Pet instances

		
		// #2 create 2 new anonymous Pet instances
		// and store them in the Array List

		
		// #3 create a file scanner
		// then use a loop to scan in all the pets from the file

		
		// #4 uncomment the next line and finish all the incomplete methods.
		//menu(pets);

		
	}

	public static void menu(ArrayList<Pet> pets) {
		int input = 0;
		while (input != 8) {
			System.out.println("\n\n         Menu     ");
			System.out.println("--------------------------");
			System.out.println("  1 - Print All Pets");
			System.out.println("  2 - Print Type of Pet");
			System.out.println("  3 - Find Name");
			System.out.println("  4 - Add Pet");
			System.out.println("  5 - Remove Pet");
			System.out.println("  6 - Get Number of Pets");
			System.out.println("  7 - Erase list");
			System.out.println("  8 - Quit");
			System.out.print("\nEnter your choice: ");
			input = new Scanner(System.in).nextInt();
			System.out.println("\n");
			switch (input) {
			case 1:  
				printAll(pets);
				break;
			case 2:  
				printType(pets);
				break;
			case 3:
				findName(pets);
				break;
			case 4:
				addPet(pets);
				break;
			case 5:
				removePet(pets);
				break;
			case 6:
				getPetTotal(pets);
				break;
			case 7:
				eraseList(pets);
				break;
			case 8:
				//print's salutation
				System.out.println("Have a great day1!\nGoodbye!");
				break;
			}
		}

	}
	
	public static void printAll(ArrayList<Pet> pets) {

	}

	public static void printType(ArrayList<Pet> pets) {

	}

	public static void findName(ArrayList<Pet> pets) {

	}

	public static void addPet(ArrayList<Pet> pets) {

	}

	public static void removePet(ArrayList<Pet> pets) {

	}

	public static void getPetTotal(ArrayList<Pet> pets) {

	}

	public static void eraseList(ArrayList<Pet> pets) {

	}

}
