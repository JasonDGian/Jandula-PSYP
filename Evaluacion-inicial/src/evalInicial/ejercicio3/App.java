package evalInicial.ejercicio3;

import java.util.TreeMap;

public class App
{

	public static void main(String[] args)
	{

		// Data loading procedure.
		// Data would be loaded one of two ways. Either through a file or through an
		// iterating loop.

		// Country objects.
		Country serbia = new Country(false, "Serbia");
		Country moldavia = new Country(false, "Moldavia");
		Country hungria = new Country(false, "Hungría");
		Country ucrania = new Country(false, "Ucrania");
		Country suecia = new Country(false, "Suecia");
		Country australia = new Country(false, "Australia");
		Country noruega = new Country(false, "Noruega");
		Country dinamarca = new Country(false, "Dinamarca");
		Country eslovenia = new Country(false, "Eslovenia");
		Country holanda = new Country(false, "Holanda");
		Country albania = new Country(false, "Albania");
		Country republicaCheca = new Country(false, "República Checa");
		Country lituania = new Country(false, "Lituania");
		Country israel = new Country(false, "Israel");
		Country estonia = new Country(false, "Estonia");
		Country bulgaria = new Country(false, "Bulgaria");
		Country austria = new Country(false, "Austria");
		Country finlandia = new Country(false, "Finlandia");
		Country irlanda = new Country(false, "Irlanda");
		Country chipre = new Country(false, "Chipre");
		// The big five + organizer.
		Country alemania = new Country(true, "Alemania");
		Country italia = new Country(true, "Italia");
		Country reinoUnido = new Country(true, "Reino Unido");
		Country francia = new Country(true, "Francia");
		Country espana = new Country(true, "España");
		Country portugal = new Country(true, "Portugal");

		// Array of finalist countries.
		Country[] finalistCountries = new Country[]
		{ serbia, moldavia, hungria, ucrania, suecia, australia, noruega, dinamarca, eslovenia, holanda, albania,
				republicaCheca, lituania, israel, estonia, bulgaria, austria, finlandia, irlanda, chipre, alemania,
				italia, reinoUnido, francia, espana, portugal };

		for (Country participant : finalistCountries)
		{
			participant.emitVote(finalistCountries);
			// participant.printEmittedVotes();
		}

		// Print serbia's emited votes.
		serbia.printEmittedVotes();
		

	}

}
