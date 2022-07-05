package fr.humanbooster.fx.avis.service;

import java.util.List;

import fr.humanbooster.fx.avis.business.Plateforme;

public interface PlateformeService {

	Plateforme ajouterPlateforme(String nom);

	List<Plateforme> recupererPlateformes();

	Plateforme recupererPlateforme(String nom);
	
}