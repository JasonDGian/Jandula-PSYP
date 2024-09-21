package evalInicial.ejercicio2;

public class SpecialTicket extends Ticket
{

	// Represents the minimal distance a vehicle of this type must travel before a
	// discount block is applied. For each time this distance is travels a discount
	// is applied.
	private final static int MIN_DISC_DISTANCE = 100;
	private final static double DISCOUNT_BLOCK = 0.05;

	@Override
	public boolean isSpecialVehicle()
	{
		return true;
	}

	@Override
	// Function to fetch the multiplier in double format. E.G. 0.25
	public double fetchDiscountMultiplier()
	{
		return fetchDiscountMultiplierAux(0, this.getTraveledDistance());
	}

	// Auxiliary method with recursive function to find the multiplier.
	public double fetchDiscountMultiplierAux(double level, int distance)
	{
		if (distance < MIN_DISC_DISTANCE)
		{
			return (level);
		} else
		{
			return fetchDiscountMultiplierAux((level + DISCOUNT_BLOCK), (distance - MIN_DISC_DISTANCE));
		}
	}

	@Override
	// Calculates the plane discount.
	public double calculateDiscount()
	{
		return this.calculatePlaneFee() * this.fetchDiscountMultiplier();
	}

	@Override
	// Applies discount to the plane fee.
	public double calculateDiscountedFee()
	{
		return this.calculatePlaneFee() - this.calculateDiscount();
	}

	@Override
	// Returns a string representation of the ticket object.
	public String toString()
	{
		return " - - SpecialTicket - -  \nentryKm=" + this.getEntryKm() + "\nexitKm=" + this.getExitKm() + "\nkmPrice="
				+ this.getKmPrice() + "\n isSpecialVehicle()=" + isSpecialVehicle() + "\nfetchDiscountMultiplier()="
				+ fetchDiscountMultiplier() + "\ncalculateDiscount()=" + calculateDiscount()
				+ "\ngetTraveledDistance()=" + getTraveledDistance() + "\ncalculatePlaneFee()=" + calculatePlaneFee()
				+ "\ncalculateDiscountedFee()=" + calculateDiscountedFee();
	}

}
