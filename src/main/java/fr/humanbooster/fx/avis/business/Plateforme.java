package fr.humanbooster.fx.avis.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plateforme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30)
	@NotBlank(message = "Ne peux pas etre vide :  nom de la plateforme")
	private String nom;

	// Une plateforme accueille
	// plusieurs jeux
	// le mappedBy doit figurer
	// sur cette annotation
	// car on souhaite écrire un
	// formulaire HTML permettant
	// l'ajout d'un jeu et contenant
	// une liste déroulante multiple
	// de plateformes
	@JsonIgnore
	@ManyToMany(mappedBy = "plateformes")
	private List<Jeu> jeux;

	public Plateforme() {

	}

	public Plateforme(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Jeu> getJeux() {
		return jeux;
	}

	public void setJeux(List<Jeu> jeux) {
		this.jeux = jeux;
	}

	@Override
	public String toString() {
		return "Plateforme [id=" + id + ", nom=" + nom + "]";
	}

}
