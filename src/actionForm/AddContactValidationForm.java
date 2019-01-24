package actionForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class AddContactValidationForm extends ActionForm {

	private long id=0;   
	private String firstName=null;
	private String lastName=null;
	private String email=null;
	  private String street=null;
	  private String city=null;
	  private String country=null;
	  private String zip=null;

	private String phonenumber=null;
	  private String phonekind=null;
	  private String siret=null;
	  


	  
	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhonekind() {
		return phonekind;
	}

	public void setPhonekind(String phonekind) {
		this.phonekind = phonekind;
	}

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

		
		System.out.println(errors);
		
		return errors;
	}


}
