package RentalcarsSorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import RentalcarsSorter.Models.car;
import RentalcarsSorter.Models.Result;

public class JsonParser {

	public static String readFile(String filename)
	{
		
		try (BufferedReader lineReader = new BufferedReader(new FileReader(filename)))
		{
		    StringBuilder sb = new StringBuilder();
		    String line = lineReader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = lineReader.readLine();
		    }
		    
		    return sb.toString();
		    
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
		return null;
	}
	
	public static car[] parseJson(String filename)
	{
		Result parsed = new Gson().fromJson(readFile(filename), Result.class);
		
		return parsed.Search.VehicleList;
	}
}
