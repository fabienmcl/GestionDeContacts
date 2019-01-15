package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;



public class DAOContact extends DAOHibernate {
	
	
	public DAOContact() {
        super();
    }
	public String addContact(Contact contact) {
		String result = null;
		super.open();
		
		try {
			
			super.getSession().save(contact);
			contact.setFirstName("Robin");
			super.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}
	
	
	public String removeContact(final long id, final String email){
		System.out.println("je suis dans DAOcontact : remove contact");
		String result = null;
		Contact contact = getContact(id);
		super.open();
		System.out.println("after open");
		try {
			//super.getSession().delete(contact);
			String hql = "delete from Contact_table where ID_CONTACT="+contact.getId()+" ;";
			super.getSession().createQuery(hql).executeUpdate();
			System.out.println("after querry");
			super.close();
			System.out.println("after close");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Contact getContact(final long id){
		super.open();
		Contact contact = (Contact) super.getSession().get(Contact.class, id);
		super.close();
		return contact;
	}
	
	public String alterContact(final long id, final String firstName, final String lastName, final String email) {
	
		String result = null;
		/*
		Contact contact = getContact(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);*/
		Contact contact = new Contact(id, firstName, lastName, email);
		super.open();
		try {
			super.getSession().update(contact);
			super.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return result;
	}
	
	
	public List<Contact> getListContact() {
		List<Contact> listContacts = new ArrayList<Contact>();
		super.open();
		try {

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT * FROM  Contact_Table");

			//Query query = super.getSession().createQuery(stringBuilder.toString());
			

			@SuppressWarnings("unchecked")
			List<Contact> listResultQuery = (List<Contact>) super.getSession().createCriteria(Contact.class).list();//query.list();
			for (Contact contact : listResultQuery) {
				Contact c = new Contact(contact.getLastName(), contact.getFirstName(), contact.getEmail());
				c.setId(contact.getId());
				listContacts.add(c);
			}	

			super.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*if(listContacts.isEmpty()==true){
			listContacts.add(new Contact());
		}*/
		return listContacts;
	}
	
	
}
