package fr.parisnanterre.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.parisnanterre.struts.actionForm.AlterContactValidationForm;
import fr.parisnanterre.struts.actionForm.CheckLoginValidationForm;
import fr.parisnanterre.struts.domain.DAOContact;

public class CheckLoginAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		System.out.println("je suis dans check login");
		
		final CheckLoginValidationForm lForm=(CheckLoginValidationForm)pForm;

		//System.out.println("je suis dans alterContactAction step dao");
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();

		if(firstName.equals(lastName)) {
			// if no exception is raised,  forward "success"
			return pMapping.findForward("success");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
		
	}
}
