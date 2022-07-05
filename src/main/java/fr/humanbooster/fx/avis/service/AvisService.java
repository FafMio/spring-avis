package fr.humanbooster.fx.avis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.fx.avis.business.Avis;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.Joueur;

public interface AvisService {
	
	Avis ajouterAvis(String description, float note, Jeu jeu, Joueur joueur);

	Page<Avis> recupererAvis(Long id, Pageable pageable);

	Page<Avis> recupererAvis(Pageable pageable);
}
