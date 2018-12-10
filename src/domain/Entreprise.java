package domain;


public class Entreprise  extends Contact{
	int NumSiret;
	
	public Entreprise() {
		super();
	}
	

	public Entreprise(int numSiret) {
		super();
		NumSiret = numSiret;
	}

	public int getNumSiret() {
		return NumSiret;
	}
	public void setNumSiret(int numSiret) {
		NumSiret = numSiret;
	}
}
