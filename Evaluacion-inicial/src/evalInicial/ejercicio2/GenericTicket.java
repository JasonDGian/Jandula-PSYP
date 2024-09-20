package evalInicial.ejercicio2;

/**
 * Generic ticket object for non-special vehicles.
 */
public class GenericTicket extends Ticket {

	private final static int MIN_DISC_DISTANCE = 500;

	public GenericTicket() {
	}

	public GenericTicket(int entryPoint, double kmPrice) {
		this.setEntryKm(entryPoint);
		this.setKmPrice(kmPrice);
	}

	@Override
	public void recordTicketEntryPoint(int entryPoint) {
		this.setEntryKm(entryPoint);
	}

	@Override
	public void recordTicketExitPoint(int exitPoint) {
		this.setExitKm(exitPoint);
	}

	@Override
	public void recordKmPrice(double ticketPrice) {
		this.setKmPrice(ticketPrice);
	}

	@Override
	public double fetchDiscount() {

		// Discount multiplier.
		double discount = 0.0;

		if (this.getTraveledDistance() >= 500) {

			// For every certain amount of traveled distance (constant), the driver is given
			// a 0.1 discount (10%).
			int discountBlock = this.getTraveledDistance() / MIN_DISC_DISTANCE;
			discount = 0.1 * discountBlock;
		}
		return discount;
	}

	public double fetchDiscount2(int level, int distance) {

		if (distance < 500) {
			return level;
		} else {
			return fetchDiscount2((level + 1), (distance - 500));
		}
	}

	@Override
	public boolean isSpecialVehicle() {
		return false;
	}

	@Override
	public int getTraveledDistance() {
		return (this.getExitKm() - this.getEntryKm());
	}

	@Override
	public double calculateFee() {
		return (this.getKmPrice() * this.getTraveledDistance()) - this.calculateDiscount();
	}

	// Calculates the plane discount value.
	@Override
	public double calculateDiscount() {
		return (this.getKmPrice() * this.getTraveledDistance()) * this.fetchDiscount();
	}

	public void setEntryKm(int entryPoint) {
		super.entryKm = entryPoint;
	}

	@Override
	public int getEntryKm() {
		return super.entryKm;
	}

	@Override
	public void setExitKm(int exitPoint) {
		super.exitKm = exitPoint;
	}

	@Override
	public int getExitKm() {
		return super.exitKm;
	}

	@Override
	public void setKmPrice(double kmPrice) {
		super.kmPrice = kmPrice;
	}

	@Override
	public double getKmPrice() {
		return super.kmPrice;
	}

	@Override
	public String toString() {
		return "GenericTicket [entryKm=" + entryKm + ", exitKm=" + exitKm + ", kmPrice=" + kmPrice
				+ ", fetchDiscount()=" + fetchDiscount() + ", isSpecialVehicle()=" + isSpecialVehicle()
				+ ", getTraveledDistance()=" + getTraveledDistance() + ", calculateFee()=" + calculateFee() + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
