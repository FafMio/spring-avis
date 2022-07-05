package fr.humanbooster.fx.avis.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Ne peux pas etre vide :  libellé de la classification")
	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "classification")
	private List<Jeu> jeux;

	public Classification() {

	}

	public Classification(String nom) {
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
		return "Classification [id=" + id + ", nom=" + nom + "]";
	}

}