import java.util.Scanner;

public class ContactView {
	
	private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	private static final int CREATE_CONTACT = 1;
	private static final int UPDATE_CONTACT = 2;
	private static final int DELETE_CONTACT = 3;
	private static final int BACK = 4;

	public static void showContactView() {
		try {
			Util.printContactFunctionalities();
			int userInput = scanner.nextInt();
			scanner.nextLine();
			int contactIndex = 0;
			/*
			*	Create a new Contact Information
			*/
			if (userInput == CREATE_CONTACT) {
				Service.getContactInput(false, null);
			}
			/*
			*	Update a Contact Information
			*/
			else if (userInput == UPDATE_CONTACT) {
				System.out.print("Enter the index of the Contact Information: ");
				contactIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(contactIndex, "ContactInformation") != null) {
					Dao.update(Service.getContactInput(true, (ContactInformation)Dao.get(contactIndex, "ContactInformation")));
				}
				else {
					System.out.println("Wrong Index!");
				}	
			}
			/*
			*	Delete a Contact Information
			*/
			else if (userInput == DELETE_CONTACT) {
				System.out.print("Enter the index of the Contact Information: ");
				contactIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(contactIndex, "ContactInformation") != null) {
					Dao.delete((ContactInformation)Dao.get(contactIndex, "ContactInformation"));
				}
				else {
					System.out.println("Wrong Index!");
				}	
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