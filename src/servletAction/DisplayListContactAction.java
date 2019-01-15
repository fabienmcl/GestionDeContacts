package servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import domain.Contact;
import domain.DAOContact;
import service.ContactService;

public class DisplayListContactAction extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		
		if(listContactsJDBC.isEmpty()) {
			// If any exception, return the "error" forward
			//return mapping.findForward("error");

			request.setAttribute("listContactsJDBC", listContactsJDBC );
			return mapping.findForward("success");
			
		}
		else {
			// if no exception is raised,  forward "success"
			request.setAttribute("listContactsJDBC", listContactsJDBC);
			return mapping.findForward("success");
		}
	}
 
}