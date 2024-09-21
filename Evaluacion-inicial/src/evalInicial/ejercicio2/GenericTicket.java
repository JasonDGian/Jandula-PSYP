package evalInicial.ejercicio2;

/**
 * Generic ticket object for non-special vehicles.
 */
public class GenericTicket extends Ticket
{

	// Represents the minimal distance a vehicle of this type must travel before a
	// discount block is applied. For each time this distance is travels a discount
	// is applied.
	private final static int MIN_DISC_DISTANCE = 500;
	private final static double DISCOUNT_BLOCK = 0.1;

	@Override
	public boolean isSpecialVehicle()
	{
		return false;
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
	public double calculateDiscount()
	{
		return this.calculatePlaneFee() * this.fetchDiscountMultiplier();
	}

	@Override
	public double calculateDiscountedFee()
	{
		return this.calculatePlaneFee() - this.calculateDiscount();
	}

	@Override
	public String toString()
	{
		return " - - GenericTicket - - \nentryKm=" + this.getEntryKm() + "\nexitKm=" + this.getExitKm() + "\nkmPrice="
				+ this.getKmPrice() + "\nisSpecialVehicle()=" + isSpecialVehicle() + "\nfetchDiscountMultiplier()="
				+ fetchDiscountMultiplier() + ", calculateDiscount()=" + calculateDiscount()
				+ "\ncalculateDiscountedFee()=" + calculateDiscountedFee() + "\ngetTraveledDistance()="
				+ getTraveledDistance() + "\ncalculatePlaneFee()=" + calculatePlaneFee();
	}

}
