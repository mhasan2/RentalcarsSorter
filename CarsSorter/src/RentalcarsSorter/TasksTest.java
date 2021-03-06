package RentalcarsSorter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import RentalcarsSorter.Models.car;

public class TasksTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    
	    Map<Character, String> map1 = new HashMap<Character, String>();
		map1.put('M', "Mini");
		map1.put('E', "Economy");
		map1.put('C', "Compact");
		map1.put('I', "Intermediate");
		map1.put('S', "Standard");
		map1.put('F', "Full Size");
		map1.put('P', "Premium");
		map1.put('L', "Luxury");
		map1.put('X', "Special");
		
		Map<Character, String> map2 = new HashMap<Character, String>();
		map2.put('B', "2 doors");
		map2.put('C', "4 doors");
		map2.put('D', "5 doors");
		map2.put('W', "Estate");
		map2.put('T', "Convertible");
		map2.put('F', "SUV");
		map2.put('P', "Pick up");
		map2.put('V', "Passenger Van");
		
		Map<Character, String> map3 = new HashMap<Character, String>();
		map3.put('M', "Manual");
		map3.put('A', "Automatic");
		
		Map<Character, String> map4 = new HashMap<Character, String>();
		map4.put('N', "Petrol/no AC");
		map4.put('R', "Petrol/AC");
	    
		Tasks.initialiseSpecifications(map1, map2, map3, map4);
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	
	@Test
	public void Should_List_Cars_By_Increasing_Price() {
		car carA = new car("", "car A", 10, "", 0);
		car carB = new car("", "car B", 5, "", 0);
		car carC = new car("", "car C", 20, "", 0);
		
		Tasks.listCars(new car[]{carA, carB, carC});
		
		assertEquals("1. car B - 5.0" + System.lineSeparator() + "2. car A - 10.0" + System.lineSeparator() + "3. car C - 20.0" + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	public void Should_List_Correct_Specification_For_Each_Car(){
		car carA = new car("MBMN", "car A", 0, "", 0);
		car carB = new car("CTAR", "car B", 0, "", 0);
		
		Tasks.listSpecifications(new car[]{carA, carB});
		
		assertEquals("1. car A - MBMN - Mini - 2 doors - Manual - Petrol/no AC" + System.lineSeparator() + "2. car B - CTAR - Compact - Convertible - Automatic - Petrol/AC" + System.lineSeparator(), outContent.toString());
	}

	@Test
	public void Should_Print_Highest_Rated_Supplier_Per_Car_Type(){
		car carA = new car("MBMN", "car A", 0, "Alamo", 6);
		car carB = new car("EBMN", "car B", 0, "Europcar", 7);
		car carC = new car("EBMN", "car C", 0, "Alamo", 6);
		
		Tasks.bestSupplierPerType(new car[]{carA, carB, carC});
		
		assertEquals("1. car A - Mini - Alamo - 6.0" + System.lineSeparator() + "2. car B - Economy - Europcar - 7.0" + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	public void Should_List_Cars_By_Decreasing_Combined_Rating(){
		car carA = new car("MBMR", "car A", 0, "", 6);
		car carB = new car("MBMN", "car B", 0, "", 7);
		car carC = new car("MBAR", "car C", 0, "", 3);
		
		Tasks.listCombinedScore(new car[]{carA, carB, carC});
		
		assertEquals("1. car C - 7.0 - 3.0 - 10.0" + System.lineSeparator() + "2. car A - 3.0 - 6.0 - 9.0" + System.lineSeparator() + "3. car B - 1.0 - 7.0 - 8.0" + System.lineSeparator(), outContent.toString());
	}
}
