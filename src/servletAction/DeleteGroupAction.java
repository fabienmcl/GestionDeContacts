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

import actionForm.DeleteGroupValidationForm;
import actionForm.RemoveContactValidationForm;
import domain.DAOContact;
import service.ContactService;

public class DeleteGroupAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		
		final DeleteGroupValidationForm lForm=(DeleteGroupValidationForm)pForm;
		
		
		System.out.println("je suis dans removeContactAction step pForm");
		final long id = lForm.getGroupId();
		
		final String name = lForm.getGroupName();
		
		// create a new Contact
		//final DAOContact lDAOContact = new DAOContact();
		System.out.println("je suis dans removeContactAction step dao");
		final boolean lError = contactService.removeGroup(contactService.getGroup(id));
		
		//final boolean lError = email==null ? null : contactService.removeContact(contactService.getContact(id));
			
		
		
		
		
		if(lError == true) {
			
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
