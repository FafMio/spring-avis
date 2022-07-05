package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Plateforme;
import fr.humanbooster.fx.avis.dao.PlateformeDao;
import fr.humanbooster.fx.avis.service.PlateformeService;

@Service 
public class PlateformeServiceImpl implements PlateformeService {

	private PlateformeDao plateformeDao;
	
	public PlateformeServiceImpl(PlateformeDao plateformeDao) {
		super();
        this.plateformeDao=plateformeDao;
	}
	
	@Override
	public Plateforme ajouterPlateforme(String nom) {
		return plateformeDao.save(new Plateforme(nom));
	}
	
	@Override
	public List<Plateforme> recupererPlateformes() {
		return plateformeDao.findAll();
	}
	
	@Override
	public Plateforme recupererPlateforme(String nom) {
		return plateformeDao.findFirstByNomLike(nom);
	}

}