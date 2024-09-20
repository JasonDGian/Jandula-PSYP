package evalInicial.ejercicio2.interfaces;

public interface ITicket {
	
	// Record entry km.
	public void recordTicketEntryPoint(int entryPoint);
	
	// Record exit point.
	public void recordTicketExitPoint(int exitPoint);
	
	// Record established highway/motorway price.
	public void recordKmPrice( double kmPrice );
	
	// Fetch the discount if any.
	public double fetchDiscount();
	
	// Function used to get the vehicle type.
	// Returns true if the vehicle is a bus.
	public boolean isSpecialVehicle();
	
	// Function that returns the traveled distance of the vehicle.
	// Used to calculate fee.
	public int getTraveledDistance();
	
	// Function used to calculate the driver's owed fee.
	public double calculateFee();
	
	// Calculates the plane discount value.
	public double calculateDiscount();
	
}
