public class Address {

	private int streetNo;
	private String barangay;
	private String municipality;
	private int zipCode;

	public Address(int streetNo, String barangay, String municipality, int zipCode) {
		this.streetNo = streetNo;
		this.barangay = barangay;
		this.municipality = municipality;
		this.zipCode = zipCode;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getZipCode() {
		return zipCode;
	}
}