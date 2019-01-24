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

import actionForm.AddContactToGroupValidationForm;
import actionForm.AddContactToGroupValidationForm2;
import actionForm.AlterContactValidationForm;
import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import service.ContactService;

public class AddContactToGroup2 extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		final AddContactToGroupValidationForm2 lForm=(AddContactToGroupValidationForm2) form;
		
		
		
		final long groupId = lForm.getGroupId();
		final String name = lForm.getGroupName();
		final String firstname = lForm.getFirstName();
		final String lastname = lForm.getLastName();
		final String email = lForm.getEmail();
		final long idContact = lForm.getId();
		
		ContactGroup group = contactService.getGroup(groupId);
		Contact contact = contactService.getContact(idContact);
	
		
		contactService.updateGroupWithContact(groupId, idContact);
		
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		//listContactsJDBC.remove(contact);
		request.setAttribute("listContactsJDBC", listContactsJDBC );
		request.setAttribute("group", group);
		
		return mapping.findForward("success");
		

	}
 
}