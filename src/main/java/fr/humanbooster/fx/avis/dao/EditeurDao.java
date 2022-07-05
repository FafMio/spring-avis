package fr.humanbooster.fx.avis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.humanbooster.fx.avis.business.Editeur;

public interface EditeurDao extends JpaRepository<Editeur, Long> {

	List<Editeur> findByNomLike(String nom);

	Editeur findFirstByNomLike(String nom);
	
	@Query("SELECT DISTINCT j.editeur FROM Jeu j WHERE j.genre.nom LIKE ?1%")
	List<Editeur> findDistinctByJeuGenreNomStartingWith(String nom);

	// Query method (le nom de la méthode va être interprété par Spring Data et traduit en requête
	// HQL. Hibernate reçoit cette requête HQL et va la traduire dans le SQL du SGBD choisi
	Editeur findByNom(String nom);
}
