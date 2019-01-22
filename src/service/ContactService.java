package service;

import java.util.List;

import domain.Contact;
import domain.DAOContact;
import domain.Entreprise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactService {
	
	private DAOContact contactDAO = null;
	
	public ContactService(){
	}
	public ContactService(DAOContact contactDAO){
		this.contactDAO = contactDAO;
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
	
	public String addEntreprise(Entreprise entreprise){
		return this.contactDAO.addEntreprise(entreprise);
	}
	
	
	public List<Contact> getListContact(){
		return this.contactDAO.getListContact();
	}
	public String alterContact(Contact contact){
		return this.contactDAO.alterContact(contact);
	}
	
	public String removeContact(final long id, final String email){
		System.out.println("je suis dans contact service");
		return this.contactDAO.removeContact(id, email);
	}
}
