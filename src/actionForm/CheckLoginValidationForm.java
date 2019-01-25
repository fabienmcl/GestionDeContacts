package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CheckLoginValidationForm extends ActionForm {
	  
	private String firstName=null;
	private String lastName=null;




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





	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName=null;
		this.lastName=null;
	}

	public ActionErrors validate( 
			ActionMapping mapping, HttpServletRequest request ) {
		
		System.out.println("je suis dans validate");
		ActionErrors errors = new ActionErrors();

		if( getFirstName()== null || getFirstName().length() < 1 ) {
			errors.add("first name",new ActionMessage("login.fn.error.required"));
		}
		if( getLastName()== null || getLastName().length() < 1 ) {
			errors.add("last name",new ActionMessage("login.ln.error.required"));
		}
		if( !getLastName().equals(getFirstName()) ) {
			errors.add("first last name",new ActionMessage("login.error.required"));
		}
		
		System.out.println(errors);
		
		return errors;
	}


}
