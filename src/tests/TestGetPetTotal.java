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

class TestGetPetTotal {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Get Number of Pets")
	void test1() throws FileNotFoundException {
		
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "12";
		
		PR1 p = new PR1();
		p.getPetTotal(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #1: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("You gave the wrong number of elements.");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\n\n\n");
			Assertions.fail();
		}
		
	}


	
	@Test
	@DisplayName("Test #2 - Get Number of Pets")
	void test2() throws FileNotFoundException {
		
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "14";
		
		PR1 p = new PR1();
		p.appendList("Max", 1, "dog", "chow");
		p.appendList("Spot", 8, "dog", "collie");
		p.getPetTotal(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("You gave the wrong number of elements.");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nYOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\n\n\n");
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


