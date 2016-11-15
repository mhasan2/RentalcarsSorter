package RentalcarsSorter.Models;

public class car {

	private String sipp;
	private String name;
	private float price;
	private String supplier;
	private float rating;
	private float vehicleScore;
	
	public car(String _sipp, String _name, float _price, String _supplier, float _rating)
	{
		sipp = _sipp;
		name = _name;
		price = _price;
		supplier = _supplier;
		rating = _rating;
	}
	
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
	
	public float getPrice(){
		return price;
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public float getRating(){
		return rating;
	}
	
	public float getVehicleScore(){
		return vehicleScore;
	}
	
	public void setVehicleScore(float _vehicleScore){
		vehicleScore = _vehicleScore;
	}
	
}