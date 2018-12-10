package servletAction;

import java.io.IOException;

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

import actionForm.AddContactValidationForm;
import actionForm.MoveContactValidationForm;
import domain.Contact;
import domain.DAOContact;

public class MoveToAlterContactFormAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		System.out.println("##########################################");
		System.out.println("Step 1: Je suis dans moveToAlter");
		
		final MoveContactValidationForm lForm=(MoveContactValidationForm)pForm;
		System.out.println("Step 2: moveToAlter formulaie ok");
		final long id = lForm.getId();
		
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		Contact c = new Contact(id,firstName,lastName,email);
		pRequest.setAttribute("c",c);
		return pMapping.findForward("success");
		
	}
}
