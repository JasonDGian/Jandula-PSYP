package evalInicial.ejercicio2;

public class SpecialTicket extends Ticket{
	
	private final static int MIN_DISC_DISTANCE = 100;
	
	public SpecialTicket () {
	}
	
	public SpecialTicket ( int entryPoint, double kmPrice ) {
		this.setEntryKm(entryPoint);
		this.setKmPrice(kmPrice);
	}

	@Override
	public void recordTicketEntryPoint(int entryPoint) {
		super.entryKm=entryPoint;
	}

	@Override
	public void recordTicketExitPoint(int exitPoint) {
		super.exitKm=exitPoint;
	}

	@Override
	public void recordKmPrice(double kmPrice) {
		super.kmPrice=kmPrice;		
	}

	@Override
	public double fetchDiscount() {

		// Discount multiplier.
		double discount = 0.0;

		if (this.getTraveledDistance() >= 100) {

			// For every certain amount of traveled distance (constant), the driver is given
			// a 0.1 discount (10%).
			int discountBlock = this.getTraveledDistance() / MIN_DISC_DISTANCE;
			discount = 0.05 * discountBlock;
		}
		return discount;
	}

	@Override
	public boolean isSpecialVehicle() {
		return true;
	}

	@Override
	public int getTraveledDistance() {
		return this.getExitKm()-this.getEntryKm();
	}

	@Override
	public double calculateFee() {

		
		
		return 0;
	}

	@Override
	public double calculateDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEntryKm(int entryPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEntryKm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setExitKm(int exitPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getExitKm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setKmPrice(double kmPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getKmPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
