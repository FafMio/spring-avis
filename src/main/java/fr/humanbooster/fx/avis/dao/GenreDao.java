package fr.humanbooster.fx.avis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {
	
	List<Genre> findByNomLike(String nom);

	Genre findFirstByNomLike(String nom);
	
}