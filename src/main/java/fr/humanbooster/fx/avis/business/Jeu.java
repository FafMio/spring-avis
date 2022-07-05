package fr.humanbooster.fx.avis.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Ne peux pas etre vide :  nom du jeu")
	private String nom;
	
	@NotBlank(message = "Ne peux pas etre vide :  description du jeu")
	@Lob
	private String description;
	
	@NotNull(message="Ne peux pas etre vide :  la date de sortie")
	@PastOrPresent(message = "La date de sortie doit être dans le passé")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateSortie;
		
	@NotNull(message = "Ne peux pas etre vide :  un éditeur")
	// Hibernate a besoin de l'annotation ci-dessous pour créer la clé étrangère
	// par défaut elle se nomme editeur_id
	@ManyToOne
	private Editeur editeur;
	
	@NotNull(message = "Ne peux pas etre vide :  un genre")
	@ManyToOne
	private Genre genre;
	
	@NotNull(message = "Veuillez renseigner un modèle économique")
	@ManyToOne
	private ModeleEconomique modeleEconomique;
	
	@NotNull(message = "Ne peux pas etre vide :  une classification")
	@ManyToOne
	private Classification classification;

	// Un jeu est disponible sur plusieurs
	// plateformes
	@NotEmpty(message = "Merci de préciser les plateformes de sortie")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Jeu_Plateformes")
	private Set<Plateforme> plateformes;

	@JsonIgnore
	@OneToMany(mappedBy = "jeu", cascade = CascadeType.REMOVE)
	private List<Avis> avis;

	private String image;

	@ManyToOne
	private Moderateur moderateur;
	
	public Jeu() {

	}

	public Jeu(String nom, String description, LocalDate dateSortie, ModeleEconomique modeleEconomique,
			Classification classification, Genre genre, Editeur editeur, Set<Plateforme> plateformes, String image) {
		this.nom = nom;
		this.description = description;
		this.dateSortie = dateSortie;
		this.modeleEconomique = modeleEconomique;
		this.classification = classification;
		this.genre = genre;
		this.editeur = editeur;
		this.plateformes = plateformes;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public ModeleEconomique getModeleEconomique() {
		return modeleEconomique;
	}

	public void setModeleEconomique(ModeleEconomique modeleEconomique) {
		this.modeleEconomique = modeleEconomique;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Set<Plateforme> getPlateformes() {
		return plateformes;
	}

	public void setPlateformes(Set<Plateforme> plateformes) {
		this.plateformes = plateformes;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Moderateur getModerateur() {
		return moderateur;
	}

	public void setModerateur(Moderateur moderateur) {
		this.moderateur = moderateur;
	}

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", nom=" + nom + ", description=" + description + ", dateSortie=" + dateSortie
				+ ", editeur=" + editeur + ", genre=" + genre + ", modeleEconomique=" + modeleEconomique
				+ ", classification=" + classification + ", image=" + image + "]";
	}

}
