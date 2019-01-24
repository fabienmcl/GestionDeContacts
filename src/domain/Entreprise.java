package domain;

import java.util.Set;

public class Entreprise  extends Contact{
	String numSiret;
	
	public Entreprise() {
		super();
	}
	

	public Entreprise(String numSiret) {
		super();
		this.numSiret = numSiret;
	}

	public Entreprise(String numsiret2, String lastName, String email, Address add) {
		this.numSiret = numsiret2;
		super.setFirstName("");
		super.setLastName(lastName);
		super.setEmail(email);
		super.setAddress(add);
	}
	
	public Entreprise(String numsiret2, String lastName, String email, Address add, Set<PhoneNumber> phones) {
		this.numSiret = numsiret2;
		super.setFirstName("");
		super.setLastName(lastName);
		super.setEmail(email);
		super.setAddress(add);
		super.setPhones(phones);
	}
	
	
	


	public String getNumSiret() {
		return numSiret;
	}
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
}
