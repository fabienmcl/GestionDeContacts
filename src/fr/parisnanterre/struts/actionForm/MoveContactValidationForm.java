package fr.parisnanterre.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class MoveContactValidationForm extends ActionForm {

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

	public ActionErrors validate( 
			ActionMapping mapping, HttpServletRequest request ) {
		
		System.out.println("je suis dans validate");
		ActionErrors errors = new ActionErrors();

		if( getFirstName()== null || getFirstName().length() < 1 ) {
			errors.add("first name",new ActionMessage("move.fn.error.required"));
		}
		if( getLastName()== null || getLastName().length() < 1 ) {
			errors.add("last name",new ActionMessage("move.ln.error.required"));
		}
		if( getEmail() == null || getEmail().length() < 1 ) {
			errors.add("email", new ActionMessage("move.email.error.required"));
		}
		System.out.println(errors);
		
		return errors;
	}


}
