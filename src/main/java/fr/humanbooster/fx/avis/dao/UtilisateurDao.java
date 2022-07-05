package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

}
