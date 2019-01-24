package servletAction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import actionForm.DeleteContactFromGroupValidationForm;
import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import service.ContactService;

public class DeleteContactFromGroupAction extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		final DeleteContactFromGroupValidationForm lForm=(DeleteContactFromGroupValidationForm) form;
		
		
		
		final long groupId = lForm.getGroupId();
		final String name = lForm.getGroupName();
		final String firstname = lForm.getFirstName();
		final String lastname = lForm.getLastName();
		final String email = lForm.getEmail();
		final long idContact = lForm.getId();
		
		ContactGroup group = contactService.getGroup(groupId);
		Contact contact = contactService.getContact(idContact);
	
		
		contactService.deleteContactInGroup(groupId, idContact);
		
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		List<Contact> listContactsGroup = contactService.getListContactGroup(groupId);
		
		List<Contact> filteredlist = listContactsJDBC.stream().filter(c -> isIdPresent(c, listContactsGroup)).collect(Collectors.toList());
		
		
		//listContactsJDBC.remove(contact);
		request.setAttribute("listContactsJDBC", filteredlist );
		request.setAttribute("listContactsGroup", listContactsGroup);
		request.setAttribute("group", group);
		
		return mapping.findForward("success");
		

	}
	
	private static boolean isIdPresent(final Contact contact, List<Contact> contacts) {
		return !contacts.stream().filter(c -> c.getId()==(contact.getId())).findAny().isPresent();
	}
 
}