package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.*;
import pets.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.InputStream;

class TestPrintAll {

	private static final PrintStream systemOut = System.out;
	private static final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	private String outputStream;
	
	@Test
	@DisplayName("Test #1 - Print All")
	void test1() throws Exception {
		
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "A germanShepherd dog called Chief that is 8 years old.\n"
								+ "A calico cat called Frisky that is 9 years old.\n"
								+ "A angora ferret called Frisky that is 4 years old.\n"
								+ "A parrot bird called BigMouth that is 25 years old.\n"
								+ "A snapping turtle called SlowPoke that is 18 years old.\n"
								+ "A bombay cat called Nibbles that is 2 years old.\n"
								+ "A tabby cat called Oscar that is 17 years old.\n"
								+ "A labrador dog called Buddy that is 12 years old.\n"
								+ "A parakeet bird called Tweety that is 3 years old.\n"
								+ "A labrador dog called Jeff that is 2 years old.\n"
								+ "A alley cat called Oscar that is 7 years old.\n"
								+ "A golden hamster called Whiskers that is 3 years old.";
		PR1 p = new PR1();
		p.printAll(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #1: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #1: Failed");
			System.out.println("Did not print all elements's toString() in order.\n");
			System.out.println("YOUR OUTPUT:");
			System.out.println(outputStream);
			System.out.println("\nEXPECTIED OUTPUT CONTAINS");
			System.out.println(expectedOutput);
			Assertions.fail();
		}
		
		
		
	}
	
	@Test
	@DisplayName("Test #2 - Print All")
	void test2() throws Exception {
		
		outputStream = "";
		overridePrintStatements();
		String expectedOutput = "A germanShepherd dog called Chief that is 8 years old.\n"
								+ "A calico cat called Frisky that is 9 years old.\n"
								+ "A angora ferret called Frisky that is 4 years old.\n"
								+ "A parrot bird called BigMouth that is 25 years old.\n"
								+ "A snapping turtle called SlowPoke that is 18 years old.\n"
								+ "A bombay cat called Nibbles that is 2 years old.\n"
								+ "A tabby cat called Oscar that is 17 years old.\n"
								+ "A labrador dog called Buddy that is 12 years old.\n"
								+ "A parakeet bird called Tweety that is 3 years old.\n"
								+ "A labrador dog called Jeff that is 2 years old.\n"
								+ "A alley cat called Oscar that is 7 years old.\n"
								+ "A golden hamster called Whiskers that is 3 years old.\n"
								+ "A rattle snake called Joe that is 7 years old.";
		PR1 p = new PR1();
		p.appendList("Joe", 7, "snake", "rattle");
		p.printAll(p.getList());
		
		resetPrintStream();
		
		try {
			
			Assertions.assertTrue(outputStream.contains(expectedOutput)); 
			
			System.out.println("Test #2: Passed");
			
		}
		catch (Error e) {
			System.out.println("Test #2: Failed");
			System.out.println("Did not print all elements's toString() in order.\n");
			System.out.println("YOUR OUTPUT:");
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

			public void print(Object a) {
				printCalled(String.valueOf(a));
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
