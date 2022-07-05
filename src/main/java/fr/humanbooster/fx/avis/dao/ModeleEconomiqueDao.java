package fr.humanbooster.fx.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.avis.business.ModeleEconomique;

public interface ModeleEconomiqueDao extends JpaRepository<ModeleEconomique, Long> {

	ModeleEconomique findFirstByNomLike(String nom);
}
