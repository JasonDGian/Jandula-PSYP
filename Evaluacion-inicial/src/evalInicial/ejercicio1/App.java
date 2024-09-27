package evalInicial.ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

import evalInicial.ejercicio1.excepciones.WordException;
import evalInicial.ejercicio1.excepciones.WordSearchSizeException;

public class App
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		String positives = "YESJASI";
		String userStringInput = "";
		int userIntInput = 0;
		boolean userBoolInput = false;

		// Main menu block.
		boolean selected = false;
		while (!selected)
		{
			try
			{
				System.out.println(
						"Welcome to Jay-Wordsearch\nWhat would you like to do?\n  1) Generate new Word-search\n  2) Load Word-search from file.");
				switch (sc.nextInt())
				{
				case 1:
					System.out.println("Generating a new word-search.");
					selected = true;

					// Generation block.
					boolean generated = false;
					while (!generated)
					{

						// User input for generation.
						System.out.println("Enter the size of the wordsearch you wish to generate: ");
						try
						{
							WordSearch ws = new WordSearch(sc.nextInt());

							// Wordsearch on-screen
							System.out.println("- WORDSEARCH SUCCESSFULLY GENERATED - ");
							System.out.println(ws.toString());
							generated = true;
							
						
						} catch (InputMismatchException | WordSearchSizeException e)
						{
							System.out.println(e.getLocalizedMessage());
							sc.nextLine();
						}
						
						
						
						// Word insertion block.
						boolean done = false;
						while ( !done ) {
							done = insertWord( sc, ws);
						}
					}


					break;
				case 2:
					System.out.println("Loading word-search.");
					selected = true;
					break;
				default:
					System.out.println("INVALID OPTION: Please select a valid option.");
					break;

				}
			} catch (InputMismatchException e)
			{
				System.out.println("INPUT ERROR: Please enter a number to select a choice.");
				sc.nextLine();
			}
		} // Main menu block end.

	}
	
	public boolean generateWS(int numChars) {
		if (numChars <= 0)
		{
			throw new WordSearchSizeException("The wordsearch table can't be of size 0 or lower.");
		} else
		{
			table = new char[numChars][numChars];
			this.initializeLetters();
		}
	}

	public boolean insertWord(Scanner sc, WordSearch ws)
	{
		boolean valid = false;
		int wordOrientation=0;
		String positivesAnwsers = "YESIMJAOUI";
		boolean userBoolInput = false;

		System.out.println("Enter the word you wish to insert.");
		String wordToInsert = sc.nextLine();

		// Word orientation block.
		while (!valid)
		{

			System.out.println(
					"In what orientation would you like to insert the word?\n  1) - Horizontal\n  2) - Vertical");
			wordOrientation = sc.nextInt();
			// If word orientation is equal to 1 or 2 the selection will be considered
			// valid.
			valid = (wordOrientation == 1 || wordOrientation == 2);

		}

		// User coordinates configuration.
		Coordinate co = new Coordinate();
		System.out.println("Enter insertion starting ROW for the first letter.");
		co.setAltitude((sc.nextInt()));
		sc.nextLine(); // scanner pseudo-flush
		System.out.println("Enter insertion starting COLUMN for the first letter.");
		co.setLatitude((sc.nextInt()));
		sc.nextLine(); // scanner pseudo-flush

		// Would you like to reverse the word direction?
		System.out.println("Would you like to reverse the word direction? Y/N");
		if (positivesAnwsers.contains(sc.nextLine()))
		{
			userBoolInput = true;
		}

		try
		{
			userBoolInput=false;
			if (wordOrientation == 1)
			{
				ws.colocarPalabraHorizontal(wordToInsert, co, userBoolInput);
				userBoolInput=true;
			} else if (wordOrientation == 2)
			{
				ws.colocarPalabraVertical(wordToInsert, co, userBoolInput);
				userBoolInput=true;
			} else
			{
				System.out.println("Opcion de orientación no valida.");
				userBoolInput=false;
			}

		} catch (WordException e)
		{
			System.out.println("The word entered does not fit in the chosen position.");
			userBoolInput=true;
		}

		// Result print.
		System.out.println("- WORD SUCCESSFULLY ENTERED - ");
		System.out.println(ws.toString());
		return userBoolInput;
	}

}
