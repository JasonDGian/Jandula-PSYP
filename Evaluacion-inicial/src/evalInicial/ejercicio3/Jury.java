package evalInicial.ejercicio3;

import java.util.Random;

/**
 * Class that provides a representation for the competition jury or judge.
 * Records country of origin to control self-voting.
 */
public class Jury
{
	private Country origin;
	// Create a random generator.
	Random generator = new Random();

	public Country getOrigin()
	{
		return origin;
	}

	public void setOrigin(Country origin)
	{
		this.origin = origin;
	}

	/**
	 * Method that provides a way to generate a random vote for the param country
	 * avoiding illegal values.
	 * 
	 * @param country - Country that is receiving the vote.
	 * @return integer - Value of the vote.
	 */
	public int emitVote(Country country)
	{
		// Possible values for the vote generation.
		int[] voteValue =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 10, 12 };

		// If the country receiving the vote is not the jury's country of origin.
		if (!(this.getOrigin().equals(country)))
		{
			// Returns a random selection within the vote values.
			return voteValue[generator.nextInt(9)];
		}

		else
		{
			return 0;
		}
	}

}
