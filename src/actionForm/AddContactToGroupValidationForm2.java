package actionForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class AddContactToGroupValidationForm2 extends ActionForm {

	private long id=0;
	private String firstName=null;
	private String lastName=null;
	private String email=null;
	private long groupId=0;
	  private String groupName=null;
	  
	  
	  
	  


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupId = 0;
		this.groupName = "";
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


		
		System.out.println(errors);
		
		return errors;
	}


}
