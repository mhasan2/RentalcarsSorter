package RentalcarsSorter.Models;

import java.util.Arrays;

public class SearchResult {

	public car[] VehicleList;
	
	public String toString()
	{
		return Arrays.toString(VehicleList);
	}
}
