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
		//For each car, splits the sipp into letters and prints the corresponding specification
		
		for (int x = 0; x < cars.length; x++)
		{
			String sipp = cars[x].getSipp();
			System.out.println((x+1) + ". " + cars[x].getName() + " - " + sipp + " - " + sipp1.get(sipp.charAt(0)) + " - " + sipp2.get(sipp.charAt(1)) + " - " + sipp3.get(sipp.charAt(2)) + " - " + sipp4.get(sipp.charAt(3)));
		}
	}
	
	
	public static void bestSupplierPerType(car[] cars)
	{
		//First sort cars by rating. Then for each type of car, loop through the array until a car is found
		Comparator<car> ratingDComparator = new Comparator<car>(){

			@Override
			public int compare(car first, car second) {
				return (int) (second.getRating() - first.getRating());
			}
		};
		
		Arrays.sort(cars, ratingDComparator);
		
		char [] types = new char[]{'M', 'E', 'C', 'I', 'S', 'F', 'P', 'L', 'X'};
		
		for (int y = 0; y < types.length; y++)
		{
			for (int x = 0; x < cars.length; x++)
			{
				char type = cars[x].getSipp().charAt(0);
				if (type == types[y])
				{
					System.out.println((y+1) + ". " + cars[x].getName() + " - " + sipp1.get(type) + " - " + cars[x].getSupplier() + " - " + cars[x].getRating());
					break;
				}
			}
		}
	}
}
