package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Classification;

public interface ClassificationDao extends JpaRepository<Classification, Long> {

	Classification findFirstByNomLike(String nom);

}
