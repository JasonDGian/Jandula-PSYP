package evalInicial.ejercicio1;

import evalInicial.ejercicio1.excepciones.WordException;
import evalInicial.ejercicio1.excepciones.WordSearchSizeException;

public class App
{

	public static void main(String[] args)
	{

		try
		{

			// Genera la sopa de letras.
			WordSearch sopa = new WordSearch(10);

			// Coloca palabras en la sopa.
			try
			{
				sopa.colocarPalabraVertical("Conocer", new Coordinate(0, 0), false);
				sopa.colocarPalabraVertical("Formacion", new Coordinate(1, 1), false);
				sopa.colocarPalabraHorizontal("Caracter", new Coordinate(0, 0), false);
				sopa.colocarPalabraHorizontal("Tenor", new Coordinate(3, 1), true);
				sopa.colocarPalabraHorizontal("Disponer", new Coordinate(7, 0), false);
				sopa.colocarPalabraVertical("Tono", new Coordinate(2, 2), false);
				sopa.colocarPalabraVertical("Raton", new Coordinate(0, 2), false);
				sopa.colocarPalabraVertical("Roedor", new Coordinate(0, 7), false);
				sopa.colocarPalabraVertical("Raros", new Coordinate(5, 7), false);
				sopa.colocarPalabraHorizontal("Sol", new Coordinate(9, 7), false);
				sopa.colocarPalabraHorizontal("Negar", new Coordinate(9, 1), false);
				sopa.colocarPalabraHorizontal("Roca", new Coordinate(5, 4), true);
				sopa.colocarPalabraVertical("Sorpresa", new Coordinate(0, 9), false);

			} catch (WordException e)
			{
				System.out.println(e.getMessage());

			}

			// Cuarda la sopa en un fichero.
			sopa.sendDataToFile();

			// Muestra la sopa por pantalla.
			System.out.println(sopa);

			// Muestra el resumen de letras.
			sopa.showCharSummary();

			WordSearch sopa2 = new WordSearch(10);

			// Carga la sopa de letras desde fichero.
			sopa2.loadDataFromFile();

			// Muestra la sopa (una vez cargada.)
			System.out.println(sopa2);

		} catch (WordSearchSizeException e)
		{
			System.out.println(e.getMessage());
		}

	}
}
