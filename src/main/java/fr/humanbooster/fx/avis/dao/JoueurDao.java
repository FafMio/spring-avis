package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.humanbooster.fx.avis.business.Joueur;

public interface JoueurDao extends JpaRepository<Joueur, Long> {
	
	@Query("FROM Joueur j WHERE j.pseudo LIKE ?1% AND j.motDePasse LIKE ?2%")
	Joueur findByPseudoAndMotDePasse(String pseudo, String motDePasse);

	Joueur findFirstById(Long id);

}