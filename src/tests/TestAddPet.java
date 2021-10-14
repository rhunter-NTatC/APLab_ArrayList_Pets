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
			
			//override all println()s
			public void println() {
				printCalled("\n");
			}
			public void println(boolean b) {
				printCalled(String.valueOf(b) + "\n");
			}
			public void println(char c) {
				printCalled(String.valueOf(c) + "\n");
			}
			public void println(char[] s) {
				printCalled(String.valueOf(s) + "\n");
			}
			public void println(double d) {
				printCalled(String.valueOf(d) + "\n");
			}
			public void println(float f) {
				printCalled(String.valueOf(f) + "\n");
			}
			public void println(int i) {
				printCalled(String.valueOf(i) + "\n");
			}
			public void println(long l) {
				printCalled(String.valueOf(l) + "\n");
			}
			public void println(Object obj) {
				printCalled(String.valueOf(obj) + "\n");
			}
			public void println(String str) {
				printCalled(str + "\n");
			}
			
			
			//override printf()
			public void printf(String str) {
				printCalled(str);
			}
			
			
			//override all print()s
			public void print(boolean b) {
				printCalled(String.valueOf(b));
			}
			public void print(char c) {
				printCalled(String.valueOf(c));
			}
			public void print(char[] s) {
				printCalled(String.valueOf(s));
			}
			public void print(double d) {
				printCalled(String.valueOf(d));
			}
			public void print(float f) {
				printCalled(String.valueOf(f));
			}
			public void print(int i) {
				printCalled(String.valueOf(i));
			}
			public void print(long l) {
				printCalled(String.valueOf(l));
			}
			public void print(Object obj) {
				printCalled(String.valueOf(obj));
			}
			public void print(String str) {
				printCalled(str);
			}
			
			
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
