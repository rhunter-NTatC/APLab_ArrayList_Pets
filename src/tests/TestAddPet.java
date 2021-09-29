package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.*;
import pets.*;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.InputStream;

class TestAddPet {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Add Pet")
	void test1() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		provideInput("Anna\n15\ndog\nlabrador");
		String expectedOutput = "A labrador dog called Anna that is 15 years old.";
		
		PR1 p = new PR1();
		
		p.addPet(p.getList());
		
		String pet = p.getList().get(p.getList().size() - 1).toString();
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(pet.equals(expectedOutput)); 
			
			System.out.println("Test #1: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("The final element in the list is not the new pet.");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nFINAL ELEMENT SHOULD BE");
			System.out.println(expectedOutput + "\n\n\n\n");
			Assertions.fail();
		}
	}
	

	@Test
	@DisplayName("Test #2 - Add Pet")
	void test2() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		provideInput("ButtHead\n10\ncat\nsiamese");
		String expectedOutput = "A siamese cat called ButtHead that is 10 years old.";
		
		PR1 p = new PR1();
		
		p.addPet(p.getList());
		
		String pet = p.getList().get(p.getList().size() - 1).toString();
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(pet.equals(expectedOutput)); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("The final element in the list is not the new pet.");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nFINAL ELEMENT SHOULD BE");
			System.out.println(expectedOutput + "\n\n\n\n");
			Assertions.fail();
		}
	}
	
	
	private void overridePrintStatements() {
		System.setOut(new PrintStream(System.out) {
			public void println(Object a) {
				printCalled(String.valueOf(a) + "\n");
			}

			public void printf(String str) {
				printCalled(str);
			}

			public void print(String str) {
				printCalled(str);
			}
			// override some other methods?
		});

	}
	
	
	private void printCalled(String str) {
		outputStream += str; 
	}
	
	
	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}
	
	private void resetPrintStream() {
		System.setOut(systemOut);
		System.setIn(systemIn); 
	}
	
	@AfterAll
	static void afterAll() {
		System.setOut(systemOut);
		System.setIn(systemIn);
	}


}
