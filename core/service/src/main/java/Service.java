import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;

public class Service {
	
	private static Scanner scanner = new Scanner(System.in);
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
	public static Person getPersonInput() {

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
		long landline;
		long mobileNumber;
		String email;
		String roleName;
		Set<Role> roles = new HashSet<Role>();
		Set<Person> persons = new HashSet<Person>();

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
		System.out.print("Enter the date hired: ");
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
		landline = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Enter the mobile number: ");
		mobileNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Enter the email: ");
		email = scanner.nextLine();

		System.out.print("Enter the role: ");
		roleName = scanner.nextLine();
		

		Address personAddress = new Address(streetNo, barangay, municipality, zipCode);
		
		ContactInformation personContactInformation = new ContactInformation(landline, mobileNumber, email);

		Role role = new Role(roleName);

		Person person = new Person(personName, personAddress, java.sql.Date.valueOf(LocalDate.parse(birthday, formatter)), gwa, 
							java.sql.Date.valueOf(LocalDate.parse(dateHired, formatter)), (currentlyEmployed == 1 ? true : false),
							personContactInformation);
		
		roles.add(new Role(roleName));
		persons.add(person);

		person.setRoles(roles);
		role.setPersons(persons);
		
		personContactInformation.setPerson(person);
		

		Dao.create(personAddress);
		Dao.create(role);

		return person;
	}

	public static Role getRoleInput() {
		String roleName;
		System.out.print("Enter the name role: ");
		roleName = scanner.nextLine();
		return new Role(roleName);
	}

	public static ContactInformation getContactInput() {
		long landline;
		long mobileNumber;
		String email;

		System.out.print("The following entries are for the contact information.\nEnter the landline: ");
		landline = scanner.nextLong();
		System.out.print("Enter the mobile number: ");
		mobileNumber = scanner.nextLong();
		System.out.print("Enter the email: ");
		email = scanner.nextLine();

		return new ContactInformation(landline, mobileNumber, email);
	}
}