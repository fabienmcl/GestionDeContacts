package servletAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import domain.Entreprise;
import service.ContactService;

public class CreateGroupContactAction2 extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		//List<Contact> listContactsJDBC = contactService.getListContact();
		
		//Set<Contact> contacts = new HashSet<Contact>();
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		
		//ContactGroup group = new ContactGroup();
		
		final boolean lError = true;
		//lError = contactService.addGroup(group);
		System.out.println("groupe cr�e");
		
		List<ContactGroup> listGroupsJDBC = contactService.getGroupsContact();
		request.setAttribute("listGroupsJDBC", listGroupsJDBC );
		
		if(lError == true) {
			// if no exception is raised,  forward "success"
			return mapping.findForward("success");
			
		}
		else {
			// If any exception, return the "error" forward
			return mapping.findForward("error");
		}
	}
 
}