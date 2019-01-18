package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


public class DAOContact {
	
	private SessionFactory sessionFactory;
	
	/*public DAOContact() {
        super();
    }*/
	public DAOContact(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public String addContact(Contact contact) {
		String result = null;
		super.open();
		
		try {
			
			super.getSession().save(contact.getAddress());
			for(PhoneNumber  phone : contact.getPhones()) {
				super.getSession().save(phone);
			}
			super.getSession().save(contact);
			//contact.setFirstName("Robin");
			super.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}
	
	public String addEntreprise(Entreprise entreprise) {
		String result = null;
		super.open();
		
		try {
			
			super.getSession().save(entreprise.getAddress());
			for(PhoneNumber  phone : entreprise.getPhones()) {
				super.getSession().save(phone);
			}
			super.getSession().save(entreprise);
			//contact.setFirstName("Robin");
			super.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}
	
	
	public String removeContact(final long id, final String email){
		System.out.println("je suis dans DAOcontact : remove contact");
		String result = null;
		Contact contact = this.getContact(id);
		try{
			this.sessionFactory.getCurrentSession().delete(contact);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public Contact getContact(final long id){
		Contact contact=null;
		try{
			contact = (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return contact;
	}
	
	public String alterContact(Contact contact) {
	
		String result = null;
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(contact);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Contact> getListContact() {
		List<Contact> listContacts = new ArrayList<Contact>();
		try {
			List listResultQuery = this.sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
			for (int i=0; i < listResultQuery.size(); i++) {
				listContacts.add((Contact) listResultQuery.get(i));
			}

			//super.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listContacts;
	}
	
	
}
