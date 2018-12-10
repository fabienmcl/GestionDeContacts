package servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Contact;

public class PrintListContactAction extends Action{

	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
					throws Exception {

		List<Contact> contacts = new ArrayList<Contact>();

		contacts.add(new Contact(1,"a","a","a@a.a"));
		contacts.add(new Contact(2,"b","b","b@b.b"));
		contacts.add(new Contact(3,"c","c","c@c.c"));
		contacts.add(new Contact(4,"d","d","d@d.d"));
		//return null;
		/*
			List<User> listUsers = new ArrayList<User>();

			listUsers.add(new User("user1", "http://www.user1.com"));
			listUsers.add(new User("user2", "http://www.user2.com"));
			listUsers.add(new User("user3", "http://www.user3.com"));
			listUsers.add(new User("user4", "http://www.user4.com"));

		*/
		List<String> listMsg = new ArrayList<String>();

		listMsg.add("Message A");
		listMsg.add("Message B");
		listMsg.add("Message C");
		listMsg.add("Message D");

		request.setAttribute("listMsg", listMsg);
		//request.setAttribute("contacts", contacts);
		
		//return request.getRequestDispatcher("/listeContact").forward(request, response);

		//return mapping.findForward("/listeContact");
		return null;

	}



}
