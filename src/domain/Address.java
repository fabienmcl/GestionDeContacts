package domain;

public class Address {

	private long addressId;
	private String street;
	private String city;
	private String zip;
	private String country;
	private Contact contact;

	public Address() {
	}

	public Address(long id, String street, String city, String zip, String country) {
		this(street, city, zip, country);
		this.addressId = id;
	}
	

	public Address(long addressId, String street, String city, String zip, String country, Contact contact) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.contact = contact;
	}

	public Address(String street, String city, String zip, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
