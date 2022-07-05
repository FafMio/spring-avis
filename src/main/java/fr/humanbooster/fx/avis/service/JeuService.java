package fr.humanbooster.fx.avis.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.humanbooster.fx.avis.dto.JeuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.fx.avis.business.Classification;
import fr.humanbooster.fx.avis.business.Editeur;
import fr.humanbooster.fx.avis.business.Genre;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.ModeleEconomique;
import fr.humanbooster.fx.avis.business.Plateforme;

public interface JeuService {
	
	Jeu ajouterJeu(String nom, String description, LocalDate dateSortie, ModeleEconomique modeleEconomique,
			Classification classification, Genre genre, Editeur editeur, Set<Plateforme> plateformes, String image);
	
	List<Jeu> recupererJeux();

	List<Jeu> recupererJeux(Editeur editeur);

	List<Jeu> recupererJeux(Genre genre);

	List<Jeu> recupererJeux(Editeur editeur, Genre genre);

	List<Jeu> recupererJeux(Date dateDebut, Date dateFin);

	Page<Jeu> recupererJeux(Pageable pageable);

	//Dès qu'une méthode à en paramètre un pageable elle doit renvoyer une page
	Page<Jeu> recupererJeux(Long idGenre, Pageable pageable);

	Jeu recupererJeu(Long id);

	Jeu recupererJeu(String nom);

	Jeu ajouterJeu(Jeu jeu);

	boolean supprimerJeu(Long id);

	void nommerImmage(Long id, String fileName);

	Jeu convertFromDto(JeuDTO jeuDTO);
	
}