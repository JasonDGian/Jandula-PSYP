package evalInicial.ejercicio2;

import evalInicial.ejercicio2.interfaces.ITicket;

/**
 * Ticket abstract class that provides a basic definition with the minimum
 * requirements for a ticket object. Implements the ITicket interface for main logic.
 */
public abstract class Ticket implements ITicket {
	
	// Vehicle's entry kilometer point.
	protected int entryKm;

	// Vehicle's exit kilometer point.
	protected int exitKm;
	
	// Price per kilometer.
	protected double kmPrice;
	
	// Access methods.
	public abstract void setEntryKm(int entryPoint);
	
	public abstract int getEntryKm();
	
	public abstract void setExitKm( int exitPoint );
	
	public abstract int getExitKm();
	
	public abstract void setKmPrice( double kmPrice);
	
	public abstract double getKmPrice();
	
	// Mandatory to string method.
	@Override
	public abstract String toString();

	// Mandatory equals method.
	@Override
	public abstract boolean equals(Object obj);

}
