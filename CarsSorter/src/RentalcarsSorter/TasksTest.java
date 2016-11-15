package RentalcarsSorter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import RentalcarsSorter.Models.car;

public class TasksTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	
	@Ignore
	@Test
	public void listCarsTest() {
		car carA = new car("", "car A", 10, "", 0);
		car carB = new car("", "car B", 5, "", 0);
		car carC = new car("", "car C", 20, "", 0);
		
		Tasks.listCars(new car[]{carA, carB, carC});
		
		assertEquals("1. car B - 5.0" + System.lineSeparator() + "2. car A - 10.0" + System.lineSeparator() + "3. car C - 20.0" + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	public void listSpecificationsTest(){
		car carA = new car("MBMN", "car A", 0, "", 0);
		car carB = new car("CTAR", "car B", 0, "", 0);
		
		Tasks.listSpecifications(new car[]{carA, carB});
		
		assertEquals("1. car A - MBMN - Mini - 2 doors - Manual - Petrol/no AC" + System.lineSeparator() + "2. car B - CTAR - Compact - Convertible - Automatic - Petrol/AC" + System.lineSeparator(), outContent.toString());
	}

}
