package evalInicial.ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

// The application asks the user for information in order to fill the ticket.
// In a real world application the user would not have to input anything as 
// it would all be automated by sensors and detectors. The only thing the user
// would have to do is collect the ticket on the entry KM point and deliver it
// at the exit point, being the rest all calculated.
public class App
{

	// Program main entry point.
	public static void main(String[] args)
	{

		// Scanner for user input interactions.
		Scanner sc = new Scanner(System.in);

		// Stores the user input.
		int userInput = 0;

		// Loop control flag.
		boolean answered = false;

		while (!answered)
		{

			try
			{

				System.out.println(
						"Select the type of vehicle.\n 1) General type vechile\n 2) Special type vehicle (Busses):");
				userInput = sc.nextInt();

				switch (userInput)
				{

				case 1:
					System.out.println("You've selected GENERAL TYPE VEHICLE");
					answered = true;
					GenericTicket genericTicket = new GenericTicket();
					fillTicket(sc, genericTicket);
					printTicket(genericTicket);
					break;

				case 2:
					System.out.println("You've selected SPECIAL TYPE VEHICLE");
					answered = true;
					SpecialTicket specialTicket = new SpecialTicket();
					fillTicket(sc, specialTicket);
					printTicket(specialTicket);
					break;
				default:
					System.out.println("Please enter a valid option.");

				}

			} catch (InputMismatchException e)
			{
				System.out.println("Please enter a valid option.");
				sc.next();
			}

		}

	}

	public static void printTicket(Ticket ticket)
	{
		System.out.println("Your ticket is:\n" + ticket.toString());
	}

	public static void fillTicket(Scanner sc, Ticket ticket)
	{

		recordEntryPoint(sc, ticket);
		recordKMPrice(sc, ticket);
		recordExitPoint(sc, ticket);

	}

	public static void recordEntryPoint(Scanner sc, Ticket ticket) throws InputMismatchException
	{

		boolean answered = false;

		while (!answered)
		{
			try
			{
				System.out.println("Enter the entry Kilometer.");
				ticket.setEntryKm(sc.nextInt());
				answered = true;
			} catch (InputMismatchException e)
			{
				System.out.println("Please enter a valid kilometer entry point (Integer numbers only).");
				sc.next();
				answered = false;
			}
		}
	}

	public static void recordKMPrice(Scanner sc, Ticket ticket) throws InputMismatchException
	{
		boolean answered = false;
		while (!answered)
		{
			try
			{
				System.out.println("Enter the Kilometer fee (Per KM).");
				ticket.setKmPrice(sc.nextDouble());
				answered = true;
			} catch (InputMismatchException e)
			{
				System.out.println("Please enter a valid Kilometer value. (Integer numbers only).");
				sc.next();
				answered = false;
			}
		}
	}

	public static void recordExitPoint(Scanner sc, Ticket ticket) throws InputMismatchException
	{
		boolean answered = false;
		while (!answered)
		{
			try
			{
				System.out.println("Enter the exit Kilometer.");
				ticket.setExitKm(sc.nextInt());
				answered = true;
			} catch (InputMismatchException e)
			{
				System.out.println("Please enter a valid fee value (Use comma for decimal numbers).");
				sc.next();
				answered = false;
			}
		}

	}

}
