package fr.humanbooster.fx.avis.service;

import java.util.List;

import fr.humanbooster.fx.avis.business.Joueur;
import fr.humanbooster.fx.avis.business.Moderateur;
import fr.humanbooster.fx.avis.business.Utilisateur;

public interface UtilisateurService {

	Joueur ajouterJoueur(Joueur joueur);
	
	Utilisateur recupererUtilisateur(String pseudo, String motDePasse);

	Utilisateur recupererUtilisateur(Long id);

	List<Joueur> recupererJoueurs();

	List<Moderateur> recupererModerateurs();

	List<Utilisateur> recupererUtilisateurs();

}
