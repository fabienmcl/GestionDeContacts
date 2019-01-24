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
import actionForm.AlterContactValidationForm;
import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import service.ContactService;

public class AddContactToGroup extends Action{
 
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {


		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final ContactService contactService = (ContactService) context.getBean("contactService");
		
		final AddContactToGroupValidationForm lForm=(AddContactToGroupValidationForm) form;
		
		final long id = lForm.getGroupId();
		final String name = lForm.getGroupName();
		
		ContactGroup group = contactService.getGroup(id);
		
		List<Contact> filteredlist = new ArrayList<Contact>();
		
		List<Contact> listContactsJDBC = contactService.getListContact();
		List<Contact> listContactsGroup = contactService.getListContactGroup(id);
		
		if(!listContactsGroup.isEmpty()) {
			filteredlist = listContactsJDBC.stream().filter(c -> isIdPresent(c, listContactsGroup)).collect(Collectors.toList());
		}else {
			filteredlist = listContactsJDBC;
		}
		
		
		request.setAttribute("listContactsJDBC", filteredlist );
		request.setAttribute("listContactsGroup", listContactsGroup);
		request.setAttribute("group", group);
		
		return mapping.findForward("success");
		

	}
	
	private static boolean isIdPresent(final Contact contact, List<Contact> contacts) {
		return !contacts.stream().filter(c -> c.getId()==(contact.getId())).findAny().isPresent();
	}
 
}