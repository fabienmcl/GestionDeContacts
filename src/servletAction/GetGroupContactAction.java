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

public class GetGroupContactAction extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		List<ContactGroup> listGroupsJDBC = contactService.getGroupsContact();
		
		if(listGroupsJDBC.isEmpty()) {
			// If any exception, return the "error" forward
			//return mapping.findForward("error");

			request.setAttribute("listGroupsJDBC", listGroupsJDBC );
			return mapping.findForward("success");
			
		}
		else {
			// if no exception is raised,  forward "success"
			request.setAttribute("listGroupsJDBC", listGroupsJDBC);
			return mapping.findForward("success");
		}
	}
 
}