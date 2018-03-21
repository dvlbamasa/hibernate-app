import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class RoleView {
	
	private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	private static final int CREATE_ROLE = 1;
	private static final int UPDATE_ROLE = 2;
	private static final int DELETE_ROLE = 3;
	private static final int LIST_ROLE = 4;
	private static final int ADD_PERSON_ROLE = 5;
	private static final int DELETE_PERSON_ROLE = 6;
	private static final int BACK = 7;

	public static void showRoleView() {
		try {
			Util.printRoleFunctionalities();
			int userInput = scanner.nextInt();
			scanner.nextLine();
			int roleIndex = 0;
			/*
			*	Create a new Role
			*/
			if (userInput == CREATE_ROLE) {
				Dao.create(Service.getRoleInput(false, null));
			}
			/*
			*	Update a Role
			*/
			else if (userInput == UPDATE_ROLE) {
				System.out.print("Enter the index of the Role: ");
				roleIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(roleIndex, "Role") != null) {
					Dao.update(Service.getRoleInput(true, (Role)Dao.get(roleIndex, "Role")));
				}
				else {
					System.out.println("Wrong Index!");
				}
			}
			/*
			*	Delete a Role
			*/
			else if (userInput == DELETE_ROLE) {
				System.out.print("Enter the index of the Role: ");
				roleIndex = scanner.nextInt();
				scanner.nextLine();
				if (Dao.get(roleIndex, "Role") != null) {
					Dao.delete((Role)Dao.get(roleIndex, "Role"));
				}
				else {
					System.out.println("Wrong Index!");
				}
			}
			/*
			*	List all the Roles
			*/
			else if (userInput == LIST_ROLE) {
				List roles = Dao.getList("Role");
				roles.forEach(
					(role) -> System.out.println("Role name: " + ((Role)role).getName() + " Role id: " + ((Role)role).getId()));
			}
			/*
			*	Add a role to a Person
			*/
			else if (userInput == ADD_PERSON_ROLE) {
				System.out.print("Enter the index of the Role: ");
				roleIndex = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter the index of the Person you want to add to this Role: ");
				int personIndex = scanner.nextInt();
				scanner.nextLine();

				Role newRole = (Role)Dao.get(roleIndex, "Role");
				Person person = (Person)Dao.get(personIndex, "Person");
				person.getRoles().add(newRole);
				Dao.update(person);
			}
			/*
			*	Remove a role from a Person
			*/
			else if (userInput == DELETE_PERSON_ROLE) {
				System.out.print("Enter the index of the Role: ");
				roleIndex = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter the index of the Person you want to remove from this Role: ");
				int personIndex = scanner.nextInt();
				scanner.nextLine();

				Role newRole = (Role)Dao.get(roleIndex, "Role");
				Person person = (Person)Dao.get(personIndex, "Person");

				Set<Role> roles = person.getRoles();
				Iterator<Role> iterator = roles.iterator();
			    while(iterator.hasNext()) {
			        Role setRole = iterator.next();
			        if(setRole.equals(newRole)) {
			        	System.out.print("asdasdadasd");
			            iterator.remove();
			        }
			    }
				Dao.update(person);
			}
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