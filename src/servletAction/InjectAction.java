package servletAction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import actionForm.RemoveContactValidationForm;
import domain.Address;
import domain.Contact;
import domain.DAOContact;
import domain.Entreprise;
import domain.PhoneNumber;
import service.ContactService;


public class InjectAction extends Action{
	 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		
		Contact homer = (Contact) context.getBean("contactHomer");
		Contact marge = (Contact) context.getBean("contactMarge");
		Contact ned = (Contact) context.getBean("contactNed");
		Entreprise duff = (Entreprise) context.getBean("entrepriseDuff");
		
		Address addressHomer =  new Address(homer.getAddress().getStreet(),homer.getAddress().getCity(),homer.getAddress().getZip(),homer.getAddress().getCountry());
		Address addressMarge =  new Address(marge.getAddress().getStreet(),marge.getAddress().getCity(),marge.getAddress().getZip(),marge.getAddress().getCountry());
		Address addressNed =  new Address(ned.getAddress().getStreet(),ned.getAddress().getCity(),ned.getAddress().getZip(),ned.getAddress().getCountry());
		Address addressDuff=  new Address(duff.getAddress().getStreet(),duff.getAddress().getCity(),duff.getAddress().getZip(),duff.getAddress().getCountry());
		
		Contact homerReel = new Contact(homer.getFirstName(),homer.getLastName(),homer.getEmail(),addressHomer);
		Contact margeReel = new Contact(marge.getFirstName(),marge.getLastName(),marge.getEmail(),addressMarge);
		Contact nedReel = new Contact(ned.getFirstName(),ned.getLastName(),ned.getEmail(),addressNed);
		Entreprise duffReel = new Entreprise(duff.getNumSiret(),duff.getLastName(),duff.getEmail(), addressDuff);
		
		if(homer.getPhones().isEmpty()){
			System.out.println(homer.toString());
			
		}else{
			Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
			PhoneNumber p = homer.getPhones().iterator().next();
			PhoneNumber phone = new PhoneNumber(p.getPhoneKind(),p.getPhoneNumber());
			phone.setContact(homerReel);
			phones.add(phone);
			homerReel.setPhones(phones);
			
			phones = new HashSet<PhoneNumber>();
			p = marge.getPhones().iterator().next();
			phone = new PhoneNumber(p.getPhoneKind(),p.getPhoneNumber());
			phone.setContact(margeReel);
			phones.add(phone);
			margeReel.setPhones(phones);
			
			phones = new HashSet<PhoneNumber>();
			p = ned.getPhones().iterator().next();
			phone = new PhoneNumber(p.getPhoneKind(),p.getPhoneNumber());
			phone.setContact(nedReel);
			phones.add(phone);
			nedReel.setPhones(phones);
			
			phones = new HashSet<PhoneNumber>();
			p = duff.getPhones().iterator().next();
			phone = new PhoneNumber(p.getPhoneKind(),p.getPhoneNumber());
			phone.setContact(duffReel);
			phones.add(phone);
			duffReel.setPhones(phones);
			
		}
		contactService.addContact(homerReel);
		contactService.addContact(margeReel);
		contactService.addContact(nedReel);
		contactService.addEntreprise(duffReel);
		
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		
		if(listContactsJDBC.isEmpty()) {
			// If any exception, return the "error" forward
			//return mapping.findForward("error");

			request.setAttribute("listContactsJDBC", listContactsJDBC );
			return mapping.findForward("success");
			
		}
		else {
			// if no exception is raised,  forward "success"
			request.setAttribute("listContactsJDBC", listContactsJDBC);
			return mapping.findForward("success");
		}
	}
 
}