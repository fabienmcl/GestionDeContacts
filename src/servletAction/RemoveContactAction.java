package servletAction;

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
import domain.DAOContact;
import service.ContactService;

public class RemoveContactAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		System.out.println("je suis dans removeContactAction");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		
		final RemoveContactValidationForm lForm=(RemoveContactValidationForm)pForm;
		
		
		System.out.println("je suis dans removeContactAction step pForm");
		final long id = lForm.getId();
		
		final String email = lForm.getEmail();
		
		// create a new Contact
		//final DAOContact lDAOContact = new DAOContact();
		System.out.println("je suis dans removeContactAction step dao");
		//final String lError = lDAOContact.removeContact(id, email);
		
		final boolean lError = email==null ? null : contactService.removeContact(contactService.getContact(id));
			
		
		
		
		
		if(lError == true) {
			System.out.println("je suis dans removeContactAction step sucess");
			System.out.println(lError);
			
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			System.out.println("je suis dans removeContactAction step lerror");
			System.out.println(lError);
			
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
