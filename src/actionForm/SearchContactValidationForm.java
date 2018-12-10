package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class SearchContactValidationForm extends ActionForm {
	
	private String element=null;

	/**
	 * @param string Sets the element
	 */
	public void setElement(String string) {
		element = string;
	}
	/**
	 * @return Element
	 */
	public String getElement() {
		return element;
	}

	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.element=null;
	}

	public ActionErrors validate( 
			ActionMapping mapping, HttpServletRequest request ) {
		
		System.out.println("je suis dans validate");
		
		ActionErrors errors = new ActionErrors();
		if( getElement()== null || getElement().length() < 1 ) {
			//errors.add("element", new ActionMessage("recherche.element.error.required"));
			setElement(" ");
		}
		System.out.println(errors);
		
		return errors;
	}


}
