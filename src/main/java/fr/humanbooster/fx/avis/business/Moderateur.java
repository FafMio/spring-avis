package fr.humanbooster.fx.avis.business;

import javax.persistence.Entity;

@Entity
public class Moderateur extends Utilisateur {

	private String numeroDeTelephone;

	
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}
	
	
}
