package fr.humanbooster.fx.avis.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, message="Le nom de l''éditeur doit comporter au moins 3 caractères")
	@NotBlank(message = "Ne peux pas etre vide :  nom de l'éditeur")
	@Column(unique=true)
	private String nom;
	
	@OneToMany(mappedBy = "editeur", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Jeu> jeux;

	public Editeur() {

	}

	public Editeur(String nom) {
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
		return "Editeur [id=" + id + ", nom=" + nom + "]";
	}

}
