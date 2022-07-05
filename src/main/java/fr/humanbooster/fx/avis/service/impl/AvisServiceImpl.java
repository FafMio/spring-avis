package fr.humanbooster.fx.avis.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Avis;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.Joueur;
import fr.humanbooster.fx.avis.dao.AvisDao;
import fr.humanbooster.fx.avis.service.AvisService;

@Service
public class AvisServiceImpl implements AvisService {
	
	private AvisDao avisDao;
	
	public AvisServiceImpl(AvisDao avisDao) {
		super();
		this.avisDao=avisDao;
	}

	@Override
	public Avis ajouterAvis(String description, float note, Jeu jeu, Joueur joueur) {
		return avisDao.save(new Avis(description, note, jeu, joueur));
	}

	@Override
	public Page<Avis> recupererAvis(Long id, Pageable pageable) {
		return avisDao.findByJeuId(id, pageable);
	}

	@Override
	public Page<Avis> recupererAvis(Pageable pageable) {
		return avisDao.findAll(pageable);
	}

}