package service;

import java.util.List;

import fr.parisnanterre.struts.domain.Contact;
import fr.parisnanterre.struts.domain.DAOContact;

public class ContactService {
	
	private DAOContact contactDAO;
	
	public ContactService(){
		this.contactDAO = new DAOContact();
	}
	
	public List<Contact> getListContact(){
		return this.contactDAO.getListContact();
	}
	
	public String removeContact(final long id, final String email){
		return this.removeContact(id, email);
	}
}
