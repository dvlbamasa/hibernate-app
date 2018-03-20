public class ContactInformation {
	
	private int id;
	private long landline;
	private long mobileNumber;
	private String email;
	private Person person;

	public ContactInformation() {}

	public ContactInformation(long landline, long mobileNumber, String email) {
		this.landline = landline;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setLandline(long landline) {
		this.landline = landline;
	}

	public long getLandline() {
		return landline;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
}