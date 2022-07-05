package fr.humanbooster.fx.avis.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotBlank(message="{utilisateur.pseudo.manquant}")
	@Pattern(regexp = "[a-zA-Z]{3,}+", message = "La référence doit contenir uniquement des lettres")
	protected String pseudo;
	
	@NotBlank(message="Veuillez renseigner votre mot de passe")
	protected String motDePasse;

	protected String email;
}
