package RentalcarsSorter;

import java.util.HashMap;
import java.util.Map;

import RentalcarsSorter.Models.car;

public class Main {

	public static void main(String[] args) {

		car[] searchResult = JsonParser.parseJson("src/RentalcarsSorter/Sources/vehicles.json");

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
		
		Tasks.listCars(searchResult);
		Tasks.listSpecifications(searchResult);
		
	}

}
