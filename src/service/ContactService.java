package service;

import java.util.List;

import domain.Contact;
import domain.DAOContact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactService {
	
	private DAOContact contactDAO;
	
	public ContactService(){
		//this.contactDAO = new DAOContact();
	}
	
	public void setDAOContact(DAOContact contactDAO) {
		this.contactDAO = contactDAO;
	}
	public DAOContact getDAOContact() {
		return this.contactDAO;
	}
	
	public String addContact(Contact contact){
		return this.contactDAO.addContact(contact);
	}
	
	public List<Contact> getListContact(){
		return this.contactDAO.getListContact();
	}
	public String alterContact(Contact contact){
		return this.contactDAO.alterContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail());
	}
	
	public String removeContact(final long id, final String email){
		return this.contactDAO.removeContact(id, email);
	}
}
