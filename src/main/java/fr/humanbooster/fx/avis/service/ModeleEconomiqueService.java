package fr.humanbooster.fx.avis.service;

import java.util.List;

import fr.humanbooster.fx.avis.business.ModeleEconomique;

public interface ModeleEconomiqueService {

	ModeleEconomique ajouterModeleEconomique(String nom);

	List<ModeleEconomique> recupererModelesEconomiques();

	ModeleEconomique recupererModeleEconomique(String nom);

	long compterModelesEconomiques();
	
}
