package fr.humanbooster.fx.avis.service;

import java.util.List;

import fr.humanbooster.fx.avis.business.Editeur;

public interface EditeurService {

	/**
	 * Méthode qui ajoute un éditeur
	 * 
	 * @param nom de l'éditeur à ajouter
	 * @return un objet de type Editeur
	 */
	Editeur ajouterEditeur(String nom);
	
	/**
	 * Méthode qui renvoie tous les éditeurs
	 * 
	 * @return
	 */
	List<Editeur> recupererEditeurs();
	
	/**
	 * Méthode qui renvoie l'éditeur dont l'id est donné en paramètre
	 * 
	 * @param id
	 * @return
	 */
	Editeur recupererEditeur(Long id);

	Editeur mettreAJour(Long id, String nom);

	boolean supprimerEditeur(Long id);

	long compterEditeurs();
	
}