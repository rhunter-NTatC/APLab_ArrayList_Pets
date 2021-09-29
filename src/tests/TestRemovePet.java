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

class TestRemovePet {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Remove Pet")
	void test1() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		String name = "Oscar";
		provideInput(name);
		String expectedOutput = "";
		
		PR1 p = new PR1();
		p.removePet(p.getList());
		
		int count = 0;
		for (Pet p1 : p.getList()) {
			count = p1.getName().equals(name) ? count + 1 : count;
		}
		
		resetPrintStream();
		
		try {
			
			Assertions.assertEquals(count, 0); 
			
			System.out.println("Test #1: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("Did not remove all pets with that name");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nAny pet named " + name + " should have been removed.\n\n\n\n");
			Assertions.fail();
		}
	}

	
	
	@Test
	@DisplayName("Test #2 - Remove Pet")
	void test2() throws FileNotFoundException {
		outputStream = "";
		overridePrintStatements();
		String name = "Frisky";
		provideInput(name);
		String expectedOutput = "";
		
		PR1 p = new PR1();
		p.removePet(p.getList());
		
		int count = 0;
		for (Pet p1 : p.getList()) {
			count = p1.getName().equals(name) ? count + 1 : count;
		}
		
		resetPrintStream();
		
		try {
			
			Assertions.assertEquals(count, 0); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("Did not remove all pets with that name");
			System.out.println("\nYOUR LIST:");
			p.printAll(p.getList());
			System.out.println("\nAny pet named " + name + " should have been removed.\n\n\n\n");
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

