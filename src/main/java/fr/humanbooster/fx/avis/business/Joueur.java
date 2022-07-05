package fr.humanbooster.fx.avis.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import fr.humanbooster.fx.avis.validator.DixHuitAnsOuPlus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Joueur extends Utilisateur {
		
	@Past(message = "La date de naissance doit être dans le passé")
	@DixHuitAnsOuPlus(message= "Vous devez être agé de 18 ans ou plus")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateDeNaissance;
	
	@OneToMany(mappedBy="joueur")
	private List<Avis> avis;
	
	public Joueur() {
	}
	
	public Joueur(String pseudo, String motDePasse, LocalDate dateDeNaissance) {
		this();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Joueur(@Past(message = "La date de naissance doit être dans le passé") LocalDate dateDeNaissance,
			List<Avis> avis) {
		super();
		this.dateDeNaissance = dateDeNaissance;
		this.avis = avis;
	}
	
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Avis> getAvis() {
		return avis;
	}
	
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	
}