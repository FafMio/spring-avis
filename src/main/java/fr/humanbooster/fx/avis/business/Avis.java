package fr.humanbooster.fx.avis.business;

// Nouveauté du Java 8
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Avis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Veuillez expliquer votre note")
	@Size(min = 3, message = "La description doit compter au moins 3 carractères")
	@Lob
	private String description;
	
	@Past(message = "La date d'envoie doit être dans le passé")
	private LocalDateTime dateEnvoi;
	
	@Range(min = 0, max = 20, message = "La note doit être en 0 et 20")
	private Float note;
	
	@NotNull(message = "Ne peux pas etre vide :  un jeu")
	@ManyToOne
	private Jeu jeu;
	
	@NotNull(message = "Ne peux pas etre vide :  le joueur")
	@ManyToOne
	private Joueur joueur;

	@ManyToOne
	private Moderateur moderateur;
	
	public Avis() {
		dateEnvoi = LocalDateTime.now();
	}

	public Avis(String description, float note, Jeu jeu, Joueur joueur) {
		this();
		this.description = description;
		this.note = note;
		this.jeu = jeu;
		this.joueur = joueur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(LocalDateTime dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", description=" + description + ", dateEnvoi=" + dateEnvoi + ", note=" + note
				+ ", jeu=" + jeu + ", joueur=" + joueur + "]";
	}

}
