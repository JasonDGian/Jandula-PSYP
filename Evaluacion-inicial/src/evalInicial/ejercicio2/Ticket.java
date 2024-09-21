package evalInicial.ejercicio2;

import evalInicial.ejercicio2.interfaces.ITicket;

/**
 * Ticket abstract class that provides a basic definition with the minimum
 * requirements for a ticket object. Implements the ITicket interface for main
 * logic.
 */
public abstract class Ticket implements ITicket {

	// Vehicle's entry kilometer point.
	private int entryKm;

	// Vehicle's exit kilometer point.
	private int exitKm;

	// Price per kilometer.
	private double kmPrice;

	// Public access methods.
	public int getEntryKm() {
		return entryKm;
	}

	public void setEntryKm(int entryKm) {
		this.entryKm = entryKm;
	}

	public int getExitKm() {
		return exitKm;
	}

	public void setExitKm(int exitKm) {
		this.exitKm = exitKm;
	}

	public double getKmPrice() {
		return kmPrice;
	}

	public void setKmPrice(double kmPrice) {
		this.kmPrice = kmPrice;
	}

	// Functional methods.

	public int getTraveledDistance() {
		return this.getExitKm() - this.getEntryKm();
	}

	public double calculatePlaneFee() {
		return this.kmPrice * this.getTraveledDistance();
	}

	@Override
	public abstract String toString();

}
