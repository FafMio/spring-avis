package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Plateforme;

public interface PlateformeDao extends JpaRepository<Plateforme, Long> {

	Plateforme findFirstByNomLike(String nom);
	
}
