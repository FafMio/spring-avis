package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.ModeleEconomique;
import fr.humanbooster.fx.avis.dao.ModeleEconomiqueDao;
import fr.humanbooster.fx.avis.service.ModeleEconomiqueService;

@Service
public class ModeleEconomiqueServiceImpl implements ModeleEconomiqueService {
	
	private ModeleEconomiqueDao modeleEconomiqueDao;

	public ModeleEconomiqueServiceImpl(ModeleEconomiqueDao modeleEconomiqueDao) {
		super();
		this.modeleEconomiqueDao = modeleEconomiqueDao;
	}

	@Override
	public ModeleEconomique ajouterModeleEconomique(String nom) {
		return modeleEconomiqueDao.save(new ModeleEconomique(nom));
	}

	@Override
	public List<ModeleEconomique> recupererModelesEconomiques() {
		return modeleEconomiqueDao.findAll();
	}

	@Override
	public ModeleEconomique recupererModeleEconomique(String nom) {
		return modeleEconomiqueDao.findFirstByNomLike(nom);
	}

	@Override
	public long compterModelesEconomiques() {
		return modeleEconomiqueDao.count();
	}

}