package fr.parisnanterre.struts.actionForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.parisnanterre.struts.domain.Contact;


public class AlterContactValidationForm extends ActionForm {

	private long id=0;   
	private String firstName=null;
	private String lastName=null;
	private String email=null;


	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param string Sets the Email
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string Sets the First Name
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string sets the Last Name
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l Sets the ID
	 */
	public void setId(long l) {
		id = l;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;
		this.firstName=null;
		this.lastName=null;
		this.email=null;
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
	}
	public ActionErrors validate( 
			ActionMapping mapping, HttpServletRequest request ) {
		
		System.out.println("je suis dans validate");
		ActionErrors errors = new ActionErrors();

		if( getFirstName()== null || getFirstName().length() < 1 ) {
			errors.add("first name",new ActionMessage("alter.fn.error.required"));
		}
		if( getLastName()== null || getLastName().length() < 1 ) {
			errors.add("last name",new ActionMessage("alter.ln.error.required"));
		}
		if( getEmail() == null || getEmail().length() < 1 || validateEmail(email)==false) {
			errors.add("email", new ActionMessage("alter.email.error.required"));
		}
		
		System.out.println(errors);
		
		if(!errors.isEmpty()){
			final long id = getId();
			final String firstName = getFirstName();
			final String lastName = getLastName();
			final String email = getEmail();
			Contact c = new Contact(id,firstName,lastName,email);
			request.setAttribute("c",c);
		}
		
		
		return errors;
	}


}
