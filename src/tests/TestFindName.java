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

class TestFindName {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Find Name")
	void test1() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		provideInput("Frisky");
		String expectedOutput = "A calico cat called Frisky that is 9 years old.\n"
								+ "A angora ferret called Frisky that is 4 years old.";
		
		PR1 p = new PR1();
		p.findName(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #1: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("Did not print all elements with that name's toString()");
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\nEXPECTIED OUTPUT CONTAINS");
			System.out.println(expectedOutput + "\n\n\n\n");
			Assertions.fail();
		}
	}
	
	
	
	
	@Test
	@DisplayName("Test #2 - Find Name")
	void test2() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		provideInput("Jeff");
		String expectedOutput = "A labrador dog called Jeff that is 2 years old.";
		
		PR1 p = new PR1();
		p.findName(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("Did not print all elements with that name's toString()");
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\nEXPECTIED OUTPUT CONTAINS");
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
