package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Classification;
import fr.humanbooster.fx.avis.dao.ClassificationDao;
import fr.humanbooster.fx.avis.service.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	private ClassificationDao classificationDao;

	public ClassificationServiceImpl(ClassificationDao classificationDao) {
		super();
		this.classificationDao = classificationDao;
	}

	@Override
	public Classification ajouterClassification(String nom) {
		return classificationDao.save(new Classification(nom));
	}

	@Override
	public List<Classification> recupererClassifications() {
		return classificationDao.findAll();
	}

	@Override
	public Classification recupererClassification(String nom) {
		return classificationDao.findFirstByNomLike(nom);
	}

	@Override
	public long compterClassifications() {
		return classificationDao.count();
	}

}
