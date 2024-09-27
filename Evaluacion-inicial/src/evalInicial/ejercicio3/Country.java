package evalInicial.ejercicio3;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

public class Country implements Comparable
{

	/**
	 * Los clasificados para la final son: Serbia, Moldavia, Hungría, Ucrania,
	 * Suecia, Australia, Noruega, Dinamarca, Eslovenia, Holanda, Albania, República
	 * Checa, Lituania, Israel, Estonia, Bulgaria, Austria, Finlandia, Irlanda y
	 * Chipre. A los que hay que sumar el Big five con Alemania, Italia, Reino
	 * Unido, Francia, y España. Portugal no ha debido pasar ninguna clasificación
	 * por ser el vigente ganador de Eurovisión.
	 */

	// Possible values for the vote generation.
	int[] voteValue =
	{ 1, 2, 3, 4, 5, 6, 7, 8, 10, 12 };
	private boolean isBigFive;
	private String name;
	private int votesReceived;
	private TreeMap<Country, Integer> emitedVotes;
	// Create a random generator.
	Random generator = new Random();

	// Country constructor that intializes the country with votes to 0.
	public Country(boolean isBigFive, String name)
	{
		this.isBigFive = isBigFive;
		this.name = name;
		this.votesReceived = 0;
		this.emitedVotes = new TreeMap<>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getVotesReceived()
	{
		return votesReceived;
	}

	public TreeMap<Country, Integer> getEmitedVotes()
	{
		return emitedVotes;
	}

	public void setVotesReceived(int votes)
	{
		this.votesReceived = votes;
	}

	public void setBigFive(boolean isBigFive)
	{
		this.isBigFive = isBigFive;
	}

	public void setEmitedVotes(TreeMap<Country, Integer> emitedVotes)
	{
		this.emitedVotes = emitedVotes;
	}

	/**
	 * Method that provides a way to check if the country is part of "the big five"
	 * in the competition.
	 * 
	 * @return true - false
	 */
	public boolean isBigFive()
	{
		return this.isBigFive;
	}

	/**
	 * Method that updates the current country votes adding a new vote.
	 * 
	 * @param vote - Integer vote
	 */
	public void addVote(int vote)
	{
		this.setVotesReceived(this.getVotesReceived() + vote);
	}

	/**
	 * Method for a country to emit votes on other countries. The result of the
	 * emitted votes is stored in the countries properties.
	 * 
	 * @param countries - Array of countries to be voted.
	 */
	public TreeMap<Country, Integer> emitVote(Country[] countries)
	{

		Country randomCountry;
		int slotIndex = 0;

		// Treemap to store the emitted vodes.
		TreeMap<Country, Integer> emittedVotes = new TreeMap<>();

		while (slotIndex < this.voteValue.length)
		{
			// Pick a random country.
			randomCountry = countries[generator.nextInt(countries.length)];

			// If the currently picked country is not in the treemap yet.
			if ( !(emittedVotes.containsKey(randomCountry)) && !(randomCountry.equals(this)))
			{
				// Store the generated country in the tree map with a value slot.
				emittedVotes.put(randomCountry, voteValue[slotIndex]);
				// Send to next value slot.
				slotIndex++;
			}

		}
		return emittedVotes;
	}

	public void printEmittedVotes()
	{
		System.out.println(this.getEmitedVotes().toString());

	}

	
	// Comparison methods.
	
	@Override
	public int hashCode()
	{
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Object other) {
	    Country otherCountry = (Country) other;
	    return this.getName().compareTo(otherCountry.getName());
	}
	
	

}
