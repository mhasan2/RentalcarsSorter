package RentalcarsSorter;

import java.util.Arrays;
import java.util.Comparator;

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
	
}
