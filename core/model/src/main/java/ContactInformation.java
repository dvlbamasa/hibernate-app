public class ContactInformation {
	
	private int id;
	private long landline;
	private long mobileNumber;
	private String email;

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

	public void setLandLine(long landline) {
		this.landline = landline;
	}

	public long getLandLine() {
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
}