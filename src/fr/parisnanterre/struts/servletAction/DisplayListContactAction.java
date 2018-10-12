package fr.parisnanterre.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.parisnanterre.struts.domain.Contact;
import fr.parisnanterre.struts.domain.DAOContact;

public class DisplayListContactAction extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {

		
		
		List<Contact> listContactsJDBC;
		final DAOContact lDAOContact = new DAOContact();
		listContactsJDBC=lDAOContact.getListContact();
		
		if(listContactsJDBC.isEmpty()) {
			// If any exception, return the "error" forward
			return mapping.findForward("error");
			
		}
		else {
			// if no exception is raised,  forward "success"
			request.setAttribute("listContactsJDBC", listContactsJDBC);
			return mapping.findForward("success");
		}
	}
 
}