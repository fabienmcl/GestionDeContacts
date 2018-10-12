package fr.parisnanterre.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.parisnanterre.struts.actionForm.AlterContactValidationForm;
import fr.parisnanterre.struts.domain.DAOContact;

public class AlterContactAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		System.out.println("je suis dans alterContactAction");
		
		final AlterContactValidationForm lForm=(AlterContactValidationForm)pForm;
		
		final long id = lForm.getId();
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();

		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		System.out.println("je suis dans alterContactAction step dao");
		final String lError = lDAOContact.alterContact(id, firstName, lastName, email);
		System.out.println("je suis dans alterContactAction step lerror");
		System.out.println(lError);
		
		
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