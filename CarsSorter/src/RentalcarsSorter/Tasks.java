package RentalcarsSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import RentalcarsSorter.Models.car;

public class Tasks {

	public static void listCars (car[] cars)
	{
		
		Comparator<car> priceAComparator = new Comparator<car>(){

			@Override
			public int compare(car first, car second) {
				return (int) (first.getPrice() - second.getPrice());
			}
		};
		
		Arrays.sort(cars, priceAComparator);
		
		for (int x = 0; x < cars.length; x++)
		{
			System.out.println((x+1) + ". " + cars[x].getName() + " - " + cars[x].getPrice());
		}
	}
	
	public static void listSpecifications(car[] cars)
	{
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
		
		
		for (int x = 0; x < cars.length; x++)
		{
			String sipp = cars[x].getSipp();
			System.out.println((x+1) + ". " + cars[x].getName() + " - " + sipp + " - " + map1.get(sipp.charAt(0)) + " - " + map2.get(sipp.charAt(1)) + " - " + map3.get(sipp.charAt(2)) + " - " + map4.get(sipp.charAt(3)));
		}
	}
}
