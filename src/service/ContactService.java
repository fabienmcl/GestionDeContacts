package service;

import java.util.List;

import domain.Contact;
import domain.ContactGroup;
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
	
	public boolean addContact(Contact contact){
		return this.contactDAO.addContact(contact);
	}
	

	
	public boolean addEntreprise(Entreprise entreprise){
		return this.contactDAO.addEntreprise(entreprise);
	}
	
	
	public List<Contact> getListContact(){
		return this.contactDAO.getListContact();
	}
	
	public List<ContactGroup> getGroupsContact(){
		return this.contactDAO.getListGroups();
	}
	
	public Contact getContact(final long id){
		return this.contactDAO.getContact(id);
	}
	public String alterContact(Contact contact){
		return this.contactDAO.alterContact(contact);
	}
	
	public boolean removeContact(Contact contact){
		System.out.println("je suis dans contact service");
		return this.contactDAO.removeContact(contact);
	}
	public boolean addGroup(ContactGroup group) {
		return this.contactDAO.addGroup(group);
	}
}
