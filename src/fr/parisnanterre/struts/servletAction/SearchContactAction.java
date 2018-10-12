package fr.parisnanterre.struts.servletAction;

import java.io.IOException;
import java.util.List;

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


import fr.parisnanterre.struts.actionForm.AddContactValidationForm;
import fr.parisnanterre.struts.actionForm.SearchContactValidationForm;
import fr.parisnanterre.struts.domain.Contact;
import fr.parisnanterre.struts.domain.DAOContact;

public class SearchContactAction extends Action {

	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		System.out.println("je suis dans search contact");
		
		final SearchContactValidationForm lForm=(SearchContactValidationForm)pForm;
		final String element = lForm.getElement();
		
		if(element.equals(" ")){
			return pMapping.findForward("error");
		}
		
		List<Contact> listContactsJDBC;
		final DAOContact lDAOContact = new DAOContact();
		listContactsJDBC=lDAOContact.searchContact(element);
		pRequest.setAttribute("listContactsJDBC", listContactsJDBC);
		return pMapping.findForward("success");
				
	}
}
