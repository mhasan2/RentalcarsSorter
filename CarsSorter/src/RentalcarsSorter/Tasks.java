package RentalcarsSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import RentalcarsSorter.Models.car;

public class Tasks {

	private static Map sipp1;
	private static Map sipp2;
	private static Map sipp3;
	private static Map sipp4;
	
	public static void initialiseSpecifications(Map _sipp1, Map _sipp2, Map _sipp3, Map _sipp4)
	{
		sipp1 = _sipp1;
		sipp2 = _sipp2;
		sipp3 = _sipp3;
		sipp4 = _sipp4;
	}
	
	
	public static void listCars (car[] cars)
	{
		//Sorts the array of cars in ascending order by price and prints them
		Comparator<car> priceAComparator = new Comparator<car>(){

			@Override
			public int compare(car first, car second) {
				return Float.compare(first.getPrice(),second.getPrice());
			}
		};
		
		Arrays.sort(cars, priceAComparator);
		
		for (int car = 0; car < cars.length; car++)
		{
			System.out.println((car+1) + ". " + cars[car].getName() + " - " + cars[car].getPrice());
		}
	}
	
	
	public static void listSpecifications(car[] cars)
	{
		//For each car, splits the sipp into letters and prints the corresponding specification
		
		for (int car = 0; car < cars.length; car++)
		{
			String sipp = cars[car].getSipp();
			System.out.println((car+1) + ". " + cars[car].getName() + " - " + sipp + " - " + sipp1.get(sipp.charAt(0)) + " - " + sipp2.get(sipp.charAt(1)) + " - " + sipp3.get(sipp.charAt(2)) + " - " + sipp4.get(sipp.charAt(3)));
		}
	}
	
	
	public static void bestSupplierPerType(car[] cars)
	{
		//First sort cars by rating. Then for each type of car, loop through the array until a car is found
		Comparator<car> ratingDComparator = new Comparator<car>(){

			@Override
			public int compare(car first, car second) {
				return Float.compare(second.getRating(),first.getRating());
			}
		};
		
		Arrays.sort(cars, ratingDComparator);
		
		char [] types = new char[]{'M', 'E', 'C', 'I', 'S', 'F', 'P', 'L', 'X'};
		
		for (int carType = 0; carType < types.length; carType++)
		{
			for (int car = 0; car < cars.length; car++)
			{
				char type = cars[car].getSipp().charAt(0);
				if (type == types[carType])
				{
					System.out.println((carType+1) + ". " + cars[car].getName() + " - " + sipp1.get(type) + " - " + cars[car].getSupplier() + " - " + cars[car].getRating());
					break;
				}
			}
		}
	}
	
	
	public static void listCombinedScore(car[] cars)
	{
		//First set vehicle score for each car. Then sort by combined score. Then list cars
		Comparator<car> combinedRatingDComparator = new Comparator<car>(){

			@Override
			public int compare(car first, car second) {
				return Float.compare((second.getRating() + second.getVehicleScore()), (first.getRating() + first.getVehicleScore()));
			}
		};
		
		for (int car = 0; car < cars.length; car++)
		{
			String sipp = cars[car].getSipp();
			float vehicleScore = 0;
			
			if (sipp.charAt(2) == 'M')
			{
				vehicleScore = 1;
			}
			else if (sipp.charAt(2) == 'A')
			{
				vehicleScore = 5;
			}
			
			if (sipp.charAt(3) == 'R')
			{
				vehicleScore += 2;
			}
			
			cars[car].setVehicleScore(vehicleScore);
		}
		
		Arrays.sort(cars, combinedRatingDComparator);
		
		for (int car = 0; car < cars.length; car++)
		{
			System.out.println((car+1) + ". " + cars[car].getName() + " - " + cars[car].getVehicleScore() + " - " + cars[car].getRating() + " - " + (cars[car].getVehicleScore() + cars[car].getRating()));
		}
	}
	
}
