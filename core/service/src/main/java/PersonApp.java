import java.util.Scanner;

public class PersonApp {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final int PERSON = 1;
	private static final int ROLE = 2;
	private static final int CONTACT_INFORMATION = 3;
	private static final int EXIT = 4;

	public PersonApp() {
		startApp();
	}


	public void startApp() {
		Util.printStartScreen();
		if(DBConnection.isDBEmpty()) {
			Util.printDBEmpty();
			insertInitialInput();
			showMenu();
		}
		else {
			showMenu();
		}
	}

	public void insertInitialInput() {
		Dao.create(Service.getPersonInput());
	}

	public void showMenu() {
		int userInput = 0;
		while (userInput != EXIT) {
			try {
				Util.printMenu();
				userInput = scanner.nextInt();
				if (userInput == PERSON) {
					Util.printPersonFunctionalities();
					userInput = scanner.nextInt();
					if (userInput == 1) {

					}
					else if (userInput == 2) {

					}
					else if (userInput == 3) {

					}
					else if (userInput == 4) {

					}
					else {

					}

				}
				else if (userInput == ROLE) {
					Util.printRoleFunctionalities();
					userInput = scanner.nextInt();
					if (userInput == 1) {

					}
					else if (userInput == 2) {

					}
					else if (userInput == 3) {

					}
					else if (userInput == 4) {

					}
					else if (userInput == 5) {

					}
					else if (userInput == 6) {

					}
					else {
						
					}

				}
				else if (userInput == CONTACT_INFORMATION) {
					Util.printContactFunctionalities();
					userInput = scanner.nextInt();
					if (userInput == 1) {

					}
					else if (userInput == 2) {

					}
					else if (userInput == 3) {

					}
					else {
						
					}

				}
				else if (userInput == EXIT) {
					System.exit(0);
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("***Wrong input choice!");
				scanner.nextLine();
			}
		}
		System.exit(0);
	}
}