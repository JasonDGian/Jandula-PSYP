package evalInicial.ejercicio3;

import java.util.Random;
import java.util.TreeMap;

public class Country
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
	private TreeMap<String, Integer> emitedVotes;
	// Create a random generator.
	Random generator = new Random();

	// Country constructor that intializes the country with votes to 0.
	public Country(boolean isBigFive, String name)
	{
		super();
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

	public TreeMap<String, Integer> getEmitedVotes()
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

	public void setEmitedVotes(TreeMap<String, Integer> emitedVotes)
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
	public void emitVote(Country[] countries)
	{

		for (Country participant : countries)
		{
			int vote = generator.nextInt(9);
			
			if (!(participant.equals(this)))
			{
				// Saves the generated vote in the emitted votes.
				this.getEmitedVotes().put(participant.getName(), vote);
				// Adds the vote to the country that received it score.
				participant.addVote(vote);
			} else
			{
				this.getEmitedVotes().put(participant.getName(), 0);
			}
		}
	}

	public void printEmittedVotes()
	{
		System.out.println(this.getEmitedVotes());

	}

}
