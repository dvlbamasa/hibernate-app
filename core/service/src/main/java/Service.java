import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;

public class Service {
	
	private static Scanner scanner = new Scanner(System.in);
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
	
	public static Person getPersonInput(boolean update, Person personToUpdate) {
		String firstName;
		String middleName;
		String lastName;
		int streetNo;
		String barangay;
		String municipality;
		int zipCode;
		String birthday;
		float gwa;
		String dateHired;
		int currentlyEmployed;
		String landline;
		String mobileNumber;
		String email;
		String roleName;
		Set<Role> roles = new HashSet<Role>();
		Set<Person> persons = new HashSet<Person>();
		Person person = null;
		try {
			System.out.print("Enter the first name: ");
			firstName = scanner.nextLine();
			System.out.print("Enter the middle name: ");
			middleName = scanner.nextLine();
			System.out.print("Enter the last name: ");
			lastName = scanner.nextLine();

			Name personName = new Name(firstName, middleName, lastName);

			System.out.print("Enter the birthday (MM-dd-YYYY): ");
			birthday = scanner.nextLine();
			System.out.print("Enter the gwa: ");
			gwa = scanner.nextFloat();
			scanner.nextLine();
			System.out.print("Enter the date hired (MM-dd-YYYY): ");
			dateHired = scanner.nextLine();
			System.out.print("Enter 1 if currently employed or 2 if not: ");
			currentlyEmployed = scanner.nextInt();
			scanner.nextLine();

			System.out.print("The following entries are for the address info.\nEnter the street number: ");
			streetNo = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter the barangay: ");
			barangay = scanner.nextLine();
			System.out.print("Enter the municipality: ");
			municipality = scanner.nextLine();
			System.out.print("Enter the zip code: ");
			zipCode = scanner.nextInt();
			scanner.nextLine();

			System.out.print("The following entries are for the contact information.\nEnter the landline: ");
			landline = scanner.nextLine();
			System.out.print("Enter the mobile number: ");
			mobileNumber = scanner.nextLine();
			System.out.print("Enter the email: ");
			email = scanner.nextLine();

			System.out.print("Enter the name of role: ");
			roleName = scanner.nextLine();
			
			Address personAddress = new Address(streetNo, barangay, municipality, zipCode);
			
			ContactInformation personContactInformation = new ContactInformation(landline, mobileNumber, email);

			Role role = new Role(roleName);

			person = new Person(personName, personAddress, java.sql.Date.valueOf(LocalDate.parse(birthday, formatter)), gwa, 
								java.sql.Date.valueOf(LocalDate.parse(dateHired, formatter)), (currentlyEmployed == 1 ? true : false));
			
			personContactInformation.setPerson(person);
			person.setContactInformation(personContactInformation);

			roles.add(new Role(roleName));
			persons.add(person);

			role.setPersons(persons);
			person.setRoles(roles);
			
			Dao.create(personAddress);

			if (update) {
				personToUpdate.setName(personName);
				personToUpdate.setAddress(personAddress);
				personToUpdate.setBirthday(java.sql.Date.valueOf(LocalDate.parse(birthday, formatter)));
				personToUpdate.setGwa(gwa);
				personToUpdate.setDateHired(java.sql.Date.valueOf(LocalDate.parse(dateHired, formatter)));
				personToUpdate.setCurrentlyEmployed((currentlyEmployed == 1 ? true : false));
				person.setContactInformation(personContactInformation);
				person.setRoles(roles);
			}

		} catch (java.util.InputMismatchException e) {
			e.printStackTrace();
		}

		return update ? personToUpdate : person;
	}

	public static Role getRoleInput(boolean update, Role roleToUpdate) {
		String roleName;
		System.out.print("Enter the new name of the role: ");
		roleName = scanner.nextLine();
		if (update) {
			roleToUpdate.setName(roleName);
		}
		return update ? roleToUpdate : new Role(roleName);
	}

	public static <T> ContactInformation getContactInput(boolean update, final T object) {
		ContactInformation contactInformation = null;
		Person person = null;
		String landline;
		String mobileNumber;
		String email;
		int index;

		System.out.print("\nThe following entries are for the contact information.\nEnter the new landline: ");
		landline = scanner.nextLine();
		System.out.print("Enter the new mobile number: ");
		mobileNumber = scanner.nextLine();
		System.out.print("Enter the new email: ");
		email = scanner.nextLine();

		if (!update) {
			person = (Person) object;
			person.getContactInformation().setLandline(landline);
			person.getContactInformation().setMobileNumber(mobileNumber);
			person.getContactInformation().setEmail(email);
			person.getContactInformation().setPerson(person);
			Dao.update(object);
		}
		else {
			contactInformation = (ContactInformation) object;
			contactInformation.setLandline(landline);
			contactInformation.setMobileNumber(mobileNumber);
			contactInformation.setEmail(email);	
		}

		return contactInformation;
	}
}