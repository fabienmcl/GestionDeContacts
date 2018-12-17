package service;

import java.util.List;

import domain.Contact;
import domain.DAOContact;

public class ContactService {
	
	private DAOContact contactDAO;
	
	public ContactService(){
		this.contactDAO = new DAOContact();
	}
	
	public String addContact(Contact contact){
		return this.contactDAO.addContact(contact);
	}
	
	public List<Contact> getListContact(){
		return this.contactDAO.getListContact();
	}
	
	public String removeContact(final long id, final String email){
		return this.removeContact(id, email);
	}
}
