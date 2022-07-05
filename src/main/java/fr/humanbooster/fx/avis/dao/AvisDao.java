package fr.humanbooster.fx.avis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Avis;

public interface AvisDao extends JpaRepository<Avis, Long> {

	Page<Avis> findByJeuId(Long id, Pageable pageable);
	
}
