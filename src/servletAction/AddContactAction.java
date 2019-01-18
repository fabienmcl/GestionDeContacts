package servletAction;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import domain.Address;
import domain.PhoneNumber;

import actionForm.AddContactValidationForm;
import domain.Contact;
import domain.DAOContact;
import domain.Entreprise;
import service.ContactService;

public class AddContactAction extends Action {	

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		System.out.println("je suis dans addContactAction");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		
		final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
		
		//final ContactService contactService = new ContactService(); 
		
		
		
		final long id = lForm.getId();
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		  final String street=lForm.getStreet();
		  final String city=lForm.getCity();
		  final String country=lForm.getCountry();
		  final String zip=lForm.getZip();
		  final String phonenumber=lForm.getPhonenumber();
		  final String phonekind=lForm.getPhonekind();
		  final String numsiret=lForm.getSiret();
		  
		  
		  Address add = new Address(street, city, zip, country);
		  Contact contact;
		  
		  if(!(numsiret==null) && firstName.isEmpty())
			  contact = new Entreprise(numsiret, lastName, email, add);
		  else
			  contact = new Contact(firstName, lastName, email, add);
		  
		  
		  Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
		  PhoneNumber phone = new PhoneNumber(phonekind,phonenumber);
		  phone.setContact(contact);
		  phones.add(phone);
		  contact.setPhones(phones);

		// create a new Contact
		//Contact contact = new Contact(firstName, lastName, email);
		//final DAOContact lDAOContact = new DAOContact();
		System.out.println("je suis dans addContactAction step dao");
		//final String lError = lDAOContact.addContact(id, firstName, lastName, email);
		
		final String lError;
		
		if(!(numsiret==null) && firstName.isEmpty())
			lError =contactService.addEntreprise((Entreprise) contact);
		else
			lError =contactService.addContact(contact);
		
		
		System.out.println("je suis dans addContactAction step lerror");
		System.out.println(lError);
		
		pRequest.setAttribute("s",firstName);
		
		/*
		RequestDispatcher reqDispatcher = pRequest.getRequestDispatcher("/pages/successMsg.jsp");
		try {
			reqDispatcher.forward(pRequest,pResponse);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		if(lError == null) {
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
			
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
