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
		WordSearch ws = null;

		// Main menu block.
		boolean selected = false;
		while (!selected)
		{
			try
			{
				System.out.println("-".repeat(70) + "\n" + 
						"Welcome to Jay-Wordsearch\nWhat would you like to do?\n  1) Generate new Word-search\n  2) Load Word-search from file.\n  3) Check current word search.\n" + "-".repeat(70) + "\n");
				switch (sc.nextInt())
				{
				case 1:
					System.out.println("Generating a new word-search.");
					
					// Word search Generation block.
					boolean generated = false;
					while (!generated)
					{

						// User input for generation.
						System.out.println("Enter the size of the wordsearch you wish to generate: ");
						try
						{
							ws = new WordSearch(sc.nextInt());
							sc.nextLine();
							

							// Wordsearch on-screen
							System.out.println("- WORDSEARCH SUCCESSFULLY GENERATED - ");
							System.out.println(ws.toString());
							generated = true;

						} catch (InputMismatchException | WordSearchSizeException e)
						{
							System.out.println(e.getLocalizedMessage());
							sc.nextLine();
							
						}

					}

					System.out.println("Would you like to enter a word?");
					String answer = sc.nextLine();

					if (positives.contains(answer.toUpperCase()))
					{
						// Word insertion block.
						boolean inserted = false;
						while (!inserted)
						{

							try
							{
								// Method to insert word on wordsearch.
								insertWord(sc, ws);

								System.out.println("Do you wish to enter another word? ");
								answer = sc.nextLine();
								if ( !(positives.contains(answer.toUpperCase())) )
								{ inserted=true; }

							} catch (InputMismatchException e)
							{
								System.out.println(e.getLocalizedMessage());
								sc.nextLine();
							}

						}

					}
					
					if ( ws!=null ) {
						System.out.println(ws.toString());
					}

					break;
				case 2:
					try {
					System.out.println("Loading word-search.");
					ws = new WordSearch(10);
					ws.loadDataFromFile();
					System.out.println("- WORDSEARCH SUCCESSFULLY LOADED -");
					}
					catch (WordSearchSizeException e)
					{
						e.getLocalizedMessage();
					}
					break;
					
				case 3:
					
					if ( ws!=null ) {
						System.out.println(	ws.toString());
					} else {
						System.out.println("\nATTENTION:");
						System.out.println(	"No word search generated. Please generate a new wordsearch or load from file." );
					}
					
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

	public static boolean insertWord(Scanner sc, WordSearch ws)
	{
		boolean valid = false;
		int wordOrientation = 0;
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
			userBoolInput = false;
			if (wordOrientation == 1)
			{
				ws.colocarPalabraHorizontal(wordToInsert, co, userBoolInput);
				userBoolInput = true;
			} else if (wordOrientation == 2)
			{
				ws.colocarPalabraVertical(wordToInsert, co, userBoolInput);
				userBoolInput = true;
			} else
			{
				System.out.println("Opcion de orientación no valida.");
				userBoolInput = false;
			}

		} catch (WordException e)
		{
			System.out.println("The word entered does not fit in the chosen position.");
			userBoolInput = true;
		}

		// Result print.
		System.out.println("- WORD SUCCESSFULLY ENTERED - ");
		System.out.println(ws.toString());
		return userBoolInput;
	}

}
