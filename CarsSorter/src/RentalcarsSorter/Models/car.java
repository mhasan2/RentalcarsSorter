package RentalcarsSorter.Models;

public class car {

	private String sipp;
	private String name;
	private float price;
	private String supplier;
	private float rating;
	
	public String toString()
	{
		return ("sipp : " + sipp + "\nname : " + name + "\nprice : " + price + "\nsupplier : " + supplier + "\nrating : " + rating + "\n");
	}
	
	public String getSipp(){
		return sipp;
	}
	
	public String getName(){
		return name;
	}
	
	public float getSPrice(){
		return price;
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public float getRating(){
		return rating;
	}
	
}