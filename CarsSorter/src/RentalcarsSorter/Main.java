package RentalcarsSorter;

import RentalcarsSorter.Models.car;

public class Main {

	public static void main(String[] args) {

		car[] searchResult = JsonParser.parseJson("src/RentalcarsSorter/Sources/vehicles.json");
		
		Tasks.listCars(searchResult);
		
	}

}
