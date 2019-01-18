package domain;


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


	public String getNumSiret() {
		return numSiret;
	}
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
}
