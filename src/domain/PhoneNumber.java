package domain;

import java.util.List;

public class PhoneNumber {
	private long id;
	String phoneKind;
	String phoneNumber;
	Contact contact;
	
	
	public PhoneNumber() {
		super();
	}
	public PhoneNumber(long id) {
		super();
		this.id = id;
	}
	public PhoneNumber(long id, String phoneKind) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
	}
	public PhoneNumber(String phoneKind, String phoneNumber) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber(long id, String phoneKind, String phoneNumber) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber( String phoneKind, String phoneNumber, Contact contact) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	public PhoneNumber(long id, String phoneKind, String phoneNumber, Contact contact) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
