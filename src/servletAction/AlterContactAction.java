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

import actionForm.AlterContactValidationForm;
import domain.Contact;
import domain.DAOContact;
import service.ContactService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AlterContactAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		
		System.out.println("je suis dans alterContactAction");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		final AlterContactValidationForm lForm=(AlterContactValidationForm)pForm;
		
		final long id = lForm.getId();
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();

		
		
		/*
		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		System.out.println("je suis dans alterContactAction step dao");
		final String lError = lDAOContact.alterContact(id, firstName, lastName, email);
		*/
		Contact c = contactService.getDAOContact().getContact(id);
		final String lError = contactService.alterContact(new Contact(id,firstName,lastName,email, c.getVersion()));
		
		if(lError == null) {
			System.out.println("je suis dans alterContactAction step sucess");
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			System.out.println("je suis dans alterContactAction step lerror");
			System.out.println(lError);
			
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
		
	}
}