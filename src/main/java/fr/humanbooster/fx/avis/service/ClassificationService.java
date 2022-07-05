package fr.humanbooster.fx.avis.service;

import java.util.List;

import fr.humanbooster.fx.avis.business.Classification;

public interface ClassificationService {
	
	Classification ajouterClassification(String nom);

	List<Classification> recupererClassifications();

	Classification recupererClassification(String nom);

	long compterClassifications();
	
}
