package evalInicial.ejercicio2.interfaces;

public interface ITicket {
		
	// Function used to get the vehicle type.
	public boolean isSpecialVehicle();
	
	// Fetch the discount if any.
	public double fetchDiscountMultiplier();
	
	// Calculates the plane discount value.
	public double calculateDiscount();
	
	public double calculateDiscountedFee();
	
}
