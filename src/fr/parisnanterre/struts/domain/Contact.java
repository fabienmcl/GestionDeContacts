package fr.parisnanterre.struts.domain;

public class Contact {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * @return Id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id Sets the ID
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return FirstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName Sets the FirstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return LastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName Sets the LastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email Sets the Email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Contact(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
