package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Joueur;
import fr.humanbooster.fx.avis.business.Moderateur;
import fr.humanbooster.fx.avis.business.Utilisateur;
import fr.humanbooster.fx.avis.dao.JoueurDao;
import fr.humanbooster.fx.avis.dao.ModerateurDao;
import fr.humanbooster.fx.avis.dao.UtilisateurDao;
import fr.humanbooster.fx.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private JoueurDao joueurDao;
	private ModerateurDao moderateurDao;
	private UtilisateurDao utilisateurDao;

	@Override
	public Joueur ajouterJoueur(Joueur joueur) {
		return joueurDao.save(joueur);
	}

	@Override
	public Utilisateur recupererUtilisateur(String pseudo, String motDePasse) {
		return joueurDao.findByPseudoAndMotDePasse(pseudo, motDePasse);
	}

	@Override
	public List<Joueur> recupererJoueurs() {
		return joueurDao.findAll();
	}

	@Override
	public Utilisateur recupererUtilisateur(Long id) {
		return utilisateurDao.findById(id).orElse(null);
	}

	@Override
	public List<Moderateur> recupererModerateurs() {
		return moderateurDao.findAll();
	}

	@Override
	public List<Utilisateur> recupererUtilisateurs() {
		return utilisateurDao.findAll();
	}

}