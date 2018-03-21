import java.util.Scanner;

public class PersonView {

	private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	private static final int CREATE_PERSON = 1;
	private static final int DELETE_PERSON = 2;
	private static final int UPDATE_PERSON = 3;
	private static final int LIST_OPTIONS = 4;
	private static final int BACK = 5;

	public static void showPersonView() {
		try {
			Util.printPersonFunctionalities();
			int userInput = scanner.nextInt();
			scanner.nextLine();
			int personIndex = 0;
			/*
			*	Create a new Person
			*/
			if (userInput == CREATE_PERSON) {
				Dao.create(Service.getPersonInput(false, null));
			}
			/*
			*	Delete a Person
			*/
			else if (userInput == DELETE_PERSON) {
				System.out.print("Enter the index of the Person: ");
				personIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(personIndex, "Person") != null) {
					Dao.delete((ContactInformation)Dao.get(personIndex, "ContactInformation"));
					Dao.delete((Person)Dao.get(personIndex, "Person"));
				}
				else {
					System.out.println("Wrong Index!");
				}
			}
			/*
			*	Update a Person
			*/
			else if (userInput == UPDATE_PERSON) {
				System.out.print("Enter the index of the Person: ");
				personIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(personIndex, "Person") != null) {
					Dao.update(Service.getPersonInput(true, (Person)Dao.get(personIndex, "Person")));
				}
				else {
					System.out.println("Wrong Index!");
				}
			}
			/*
			*	List Person
			*/
			else if (userInput == LIST_OPTIONS) {
				PersonListView.showPersonListView();
			}
			/*
			*	Go Back
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