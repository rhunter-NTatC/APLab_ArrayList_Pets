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

class TestPrintType {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Print Type")
	void test1() throws FileNotFoundException {
		
		outputStream = "";
		overridePrintStatements();
		provideInput("cat");
		String expectedOutput = "A calico cat called Frisky that is 9 years old.\n"
								+ "A bombay cat called Nibbles that is 2 years old.\n"
								+ "A tabby cat called Oscar that is 17 years old.\n"
								+ "A alley cat called Oscar that is 7 years old.";
		
		PR1 p = new PR1();
		p.printType(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #1: Passed\n\n");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("Did not print all elements of that type's toString()");
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\nEXPECTIED OUTPUT CONTAINS");
			System.out.println(expectedOutput + "\n\n\n\n");
			Assertions.fail();
		}
		
		
	}
	
	@Test
	@DisplayName("Test #2 - Print Type")
	void test2() throws FileNotFoundException {
		
		outputStream = "";
		overridePrintStatements();
		provideInput("bird");
		String expectedOutput = "A parrot bird called BigMouth that is 25 years old.\n"
							    + "A parakeet bird called Tweety that is 3 years old.";
		
		PR1 p = new PR1();
		p.printType(p.getList());
		
		resetPrintStream();
		
		
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("Did not print all elements of that type's toString()");
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\nEXPECTIED OUTPUT CONTAINS");
			System.out.println(expectedOutput);
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
