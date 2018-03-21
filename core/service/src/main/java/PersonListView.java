import java.util.Scanner;

public class PersonListView {
	
	private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	private static final int GWA = 1;
	private static final int DATE_HIRED = 2;
	private static final int LAST_NAME = 3;
	private static final int BACK = 4;


	public static void showPersonListView() {
		try {
			Util.printListPersonOptions();
			int userInput = scanner.nextInt();
			scanner.nextLine();
			/*
			*	Create a new Person
			*/
			if (userInput == GWA) {

			}
			/*
			*	Delete a Person
			*/
			else if (userInput == DATE_HIRED) {

			}

			/*
			*	Update a Person
			*/
			else if (userInput == LAST_NAME) {

			}
			/*
			*	Go back
			*/
			else if (userInput == BACK) {
				return;
			}
			else {
				System.out.println("***Wrong input choice!");
			}
		} catch (java.util.InputMismatchException e) {
				System.out.println("***Wrong input choice!");
				scanner.nextLine();
		}
	}
}