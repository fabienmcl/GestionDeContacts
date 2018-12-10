package domain;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	private long id; 
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<ContactGroup> books = new HashSet<ContactGroup>();

	public Contact() {
	}
	
	/**
	 * @param id
	 */
	public Contact(long id) {
		super();
		this.id = id;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.address = null;
		this.phones = null;
		this.books = null;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Contact(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = null;
		this.phones = null;
		this.books = null;
	}
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public Contact(long id, String firstName, String lastName, String email, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phones = null;
		this.books = null;
	}
	
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param phones
	 * @param books
	 */
	public Contact(long id, String firstName, String lastName, String email, Address address, Set<PhoneNumber> phones,
			Set<ContactGroup> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phones = phones;
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = (phones);
	}

	public Set<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(Set<ContactGroup> books) {
		this.books = books;
	}
	
}
