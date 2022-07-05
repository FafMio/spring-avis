package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Moderateur;

public interface ModerateurDao extends JpaRepository<Moderateur, Long> {

}
