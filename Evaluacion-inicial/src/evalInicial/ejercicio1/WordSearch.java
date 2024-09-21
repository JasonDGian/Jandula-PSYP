package evalInicial.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import evalInicial.ejercicio1.excepciones.WordException;
import evalInicial.ejercicio1.excepciones.WordSearchSizeException;

public class WordSearch {

	private char[][] table;
	private Random generator = new Random();

	/**
	 * Parametrized constructor for the wordsearch item.
	 * 
	 * @param numChars - Number of characters per height and width of the
	 *                 wordsearch.
	 * @throws WordSearchSizeException - Exception thrown when the size is invalid.
	 */
	WordSearch(int numChars) throws WordSearchSizeException {

		if (numChars <= 0) {
			throw new WordSearchSizeException("The wordsearch table can't be of size 0 or lower.");
		} else {
			table = new char[numChars][numChars];
			this.initializeLetters();
		}
	}

	// Introduce una palabra en la sopa de letras si cabe. De no caber, lanza una
	// excepción.
	public void colocarPalabraHorizontal(String palabra, Coordinate coordenada, boolean Inverso) throws WordException {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.table[coordenada.getAltitude()].length - coordenada.getLatitude())) {
			throw new WordException("ERROR: La palabra " + palabra + " excede el tamaño en la tabla.");
		}

		else {
			palabra = palabra.toUpperCase();
			if (Inverso) {
				palabra = invertirPalabra(palabra);
			}
			int indiceLetra = 0;
			for (int posicionLetra = coordenada.getLatitude(); indiceLetra < palabra.length(); posicionLetra++) {

				table[coordenada.getAltitude()][posicionLetra] = palabra.charAt(indiceLetra);
				indiceLetra++;
			}
		}
	}

	// Metodo que coloca una palabra vertical.
	public void colocarPalabraVertical(String palabra, Coordinate coordenada, boolean Inverso) throws WordException {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.table.length - coordenada.getAltitude())) {
			throw new WordException("ERROR: La palabra " + palabra + " excede el tamaño en la tabla o no cabe en las coordenadas seleccionadas.");
		}

		else {

			palabra = palabra.toUpperCase();

			if (Inverso) {
				palabra = invertirPalabra(palabra);
			}

			int indiceLetra = 0;
			for (int posicionLetra = coordenada.getAltitude(); indiceLetra < palabra.length(); posicionLetra++) {

				table[posicionLetra][coordenada.getLatitude()] = palabra.charAt(indiceLetra);
				indiceLetra++;
			}

		}

	}

	/**
	 * Method used to reverse a word direction through stringBuilder.
	 * 
	 * @param paramWord - The word to reverse.
	 * @return - Returns the reversed word string.
	 */
	public static String invertirPalabra(String paramWord) {
		StringBuilder revertedWord = new StringBuilder(paramWord);
		return revertedWord.reverse().toString();
	}

	/**
	 * Method used to initialize or overwrite the table with asterisks in all
	 * positions. CAUTION: Will overwrite all previously stored values.
	 */
	public void initializeAsterisks() {
		for (int row = 0; row < this.table.length; row++) {
			for (int column = 0; column < this.table[row].length; column++) {
				table[row][column] = '*';
			}
		}
	}

	/**
	 * Method used to initialize or overwrite the table with random characters in
	 * all positions. CAUTION: Will overwrite all previously stored values.
	 */
	public void initializeLetters() {

		char randomChar;

		for (int row = 0; row < this.table.length; row++) {

			for (int column = 0; column < this.table[row].length; column++) {
				randomChar = (char) (generator.nextInt(26) + 'A');
				table[row][column] = randomChar;
			}
		}
	}

	/**
	 * Will show for each character the number of time it appears within the word
	 * search table.
	 */
	public void showCharSummary() {

		HashMap<Character, Integer> charSummary = new HashMap<>();

		for (int column = 0; column < this.table.length; column++) {

			for (int row = 0; row < this.table[column].length; row++) {

				if (charSummary.containsKey(this.table[column][row])) {

					// Increments the value associated with the currently found character.
					charSummary.put(this.table[column][row], charSummary.get(this.table[column][row]) + 1);

				}

				else {
					// Adds the newly found character to the map with initial value 1 (first
					// instance).
					charSummary.put(this.table[column][row], 1);
				}

			}

		}
		// Prints the results on screen.
		System.out.println(charSummary);

	}

	/**
	 * Constructs a visually appealing representation of the matrix content for
	 * display.
	 */
	@Override
	public String toString() {

		StringBuilder cadenaSopa = new StringBuilder();

		for (int i = 0; i < this.table.length; i++) {

			for (int j = 0; j < this.table[i].length; j++) {

				cadenaSopa.append(this.table[i][j] + "  ");

			}

			cadenaSopa.append("\n");

		}

		return cadenaSopa.toString();

	}

	/**
	 * Constructs a representation of the matrix content for storage purposes only.
	 * 
	 * @return - String.
	 */
	public String toStrigForStorage() {

		StringBuilder cadenaSopa = new StringBuilder();

		for (int i = 0; i < this.table.length; i++) {

			for (int j = 0; j < this.table[i].length; j++) {

				cadenaSopa.append(this.table[i][j]);

			}

			cadenaSopa.append("\n");

		}

		return cadenaSopa.toString();

	}

	/**
	 * Stores the currently generated word search table into a file called
	 * "wordsearch.txt".
	 */
	public void sendDataToFile() {

		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("wordsearch.txt"));
			fileWriter.write(this.toStrigForStorage());
			fileWriter.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadDataFromFile() {
		boolean done = false;
		int column = 0;
		int row = 0;
		String line;
		int read;
		int lineFeed = '\n';

		// Codeblock to find the height and width of lines for the table size.
		try {

			BufferedReader lineReader = new BufferedReader(new FileReader("wordsearch.txt"));

			while (!done) {

				line = lineReader.readLine();

				// If the line is null then we done.
				if (line == null) {
					done = true;
				}
				// If the line is NOT null then.
				else {

					if (line.length() > column) {
						column = line.length();
					}
					row++;
				}
			}

			lineReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.table = new char[row][column];

		// Block to load data from file to the word search table.
		try {
			int tableRow = 0;
			int tableColumn = 0;

			BufferedReader fileReader = new BufferedReader(new FileReader("wordsearch.txt"));

			done = false;
			while (!done) {

				read = fileReader.read();

				if (read < 0) {
					done = true;
				} 
				else {
					
					// If a line feed is found.
					if (read == lineFeed) {
						// Send to next row and reset column..
						tableRow++;
						tableColumn = 0;
					}
					
					// If a character is successfully read.
					else {
						// Load said character and increment column positional reference.
						this.table[tableRow][tableColumn] = (char) read;
						tableColumn++;
					}
				}

			}

			fileReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method that provides a way to load data that contains instances of whitespace.
	 * This method should not be of main use, is just here for special cases.
	 */
	public void loadDataWithWhitespaces() {

		int lineFeed = '\n';
		boolean done = false;

		// Reading file.
		try {
			BufferedReader lectorArchivo = new BufferedReader(new FileReader("wordsearch.txt"));

			done = false;
			int leido;
			int column = 0;
			int row = 0;
			

			// While the reader does not encounter exit signal (-1)
			while (!done) {

				leido = lectorArchivo.read();
				if (leido < 0) {
					done = true;
				} else {
					// If a line feed is encountered.
					if (leido == lineFeed) {
						// Increment column positional reference counter.
	                    row++; // Move to the next row.
	                    column = 0; // Reset column index for the new row.
					}
					// If character is found.
					else if (!Character.isWhitespace(leido)) {
						// Load the character into the table and increment the row counter.
						this.table[row][column] = (char) leido;
						column++;
					}
				}

			}

			lectorArchivo.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
