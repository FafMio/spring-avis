package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Editeur;
import fr.humanbooster.fx.avis.dao.EditeurDao;
import fr.humanbooster.fx.avis.exception.EditeurDejaPresentException;
import fr.humanbooster.fx.avis.exception.EntityExceptionHandler;
import fr.humanbooster.fx.avis.service.EditeurService;

@Service
public class EditeurServiceImpl implements EditeurService {

	// Le service va faire appel à une DAO
	// NB : il n'est pas nécessaire d'instancier cette DAO
	// car Spring va s'en charger
	// @Autowired : demande à Spring l'injection de la dépendance
	@Autowired
	private EditeurDao editeurDao;
	
	@Override
	public Editeur ajouterEditeur(String nom) {
		if (editeurDao.findByNom(nom)==null) {
			return editeurDao.save(new Editeur(nom));
		}
		else {
			// TODO à reprendre
			//new EntiteDejaPresenteException<Editeur>(new Editeur(), " déja existant");
			EntityExceptionHandler.throwEntiteDejaPresente(new Editeur(nom), "Déjà existant");
		}
		return null;
	}

	@Override
	public List<Editeur> recupererEditeurs() {
		return editeurDao.findAll();
	}

	@Override
	public Editeur recupererEditeur(Long id) {
		return editeurDao.findById(id).orElse(null);
	}

	@Override
	public Editeur mettreAJour(Long id, String nom) {
		if (editeurDao.findByNom(nom)==null) {
			Editeur editeur = recupererEditeur(id);
			editeur.setNom(nom);
			return editeurDao.save(editeur);
		}
		else {
			throw new EditeurDejaPresentException("L'éditeur est déjà présent");
		}
	}

	@Override
	public boolean supprimerEditeur(Long id) {
		if (recupererEditeur(id)==null) {
			return false;
		}
		else {
			editeurDao.deleteById(id);
			return true;
		}
	}

	@Override
	public long compterEditeurs() {
		return editeurDao.count();
	}

}
