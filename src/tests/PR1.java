package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import pets.*;

public class PR1 extends PetRunner{
	
	ArrayList<Pet> p1;
	
	public PR1() throws FileNotFoundException {
		p1 = new ArrayList<Pet>();
		
		Scanner inFile = new Scanner(new File("src/pets/petInput.txt"));
		while (inFile.hasNext()) {
			String type = inFile.next();
			String breed = inFile.next();
			String name = inFile.next();
			int age = inFile.nextInt();
			p1.add(new Pet(name, age, type, breed));
		}
		
//		for (int i = 0; i < p1.size(); i++) { //loop through all pets
//			System.out.println(p1.get(i));
//		}
		
	}
	
	
	public ArrayList<Pet> getList() {return p1;}
	public void appendList(String name, int age, String type, String breed) {
		p1.add(new Pet(name, age, type, breed));
	}
	

}
