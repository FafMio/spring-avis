package fr.humanbooster.fx.avis.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import fr.humanbooster.fx.avis.dto.JeuDTO;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import fr.humanbooster.fx.avis.business.Classification;
import fr.humanbooster.fx.avis.business.Editeur;
import fr.humanbooster.fx.avis.business.Genre;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.ModeleEconomique;
import fr.humanbooster.fx.avis.business.Plateforme;
import fr.humanbooster.fx.avis.dao.JeuDao;
import fr.humanbooster.fx.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class JeuServiceImpl implements JeuService {

	private JeuDao jeuDao;

	@Override
	public List<Jeu> recupererJeux() {

		return jeuDao.findAll();
	}

	@Override
	public List<Jeu> recupererJeux(Editeur editeur) {
		return jeuDao.findByEditeur(editeur);
	}

	@Override
	public List<Jeu> recupererJeux(Genre genre) {
		return jeuDao.findByGenre(genre);
	}

	@Override
	public List<Jeu> recupererJeux(Editeur editeur, Genre genre) {
		return jeuDao.findByEditeurAndGenre(editeur, genre);
	}

	@Override
	public List<Jeu> recupererJeux(Date dateDebut, Date dateFin) {
		return jeuDao.findByDateSortieBetweenAndSort(dateDebut, dateFin, Sort.by("dateSortie"));
	}

	@Override
	public Page<Jeu> recupererJeux(Pageable pageable) {
		return jeuDao.findAll(pageable);
	}

	@Override
	public Jeu ajouterJeu(String nom, String description, LocalDate dateSortie, ModeleEconomique modeleEconomique,
			Classification classification, Genre genre, Editeur editeur, Set<Plateforme> plateformes, String image) {
		return jeuDao.save(new Jeu( nom,  description,  dateSortie,  modeleEconomique,
			 classification,  genre,  editeur,  plateformes, image));
	}

	@Override
    public Page<Jeu> recupererJeux(Long idGenre, Pageable pageable) {
        return jeuDao.findByGenreId(idGenre,pageable);
        
    }

	@Override
	public Jeu recupererJeu(Long id) {
		return jeuDao.findById(id).orElse(null);
	}

	@Override
	public Jeu recupererJeu(String nom) {
		return jeuDao.findFirstByNom(nom);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT)
	public Jeu ajouterJeu(Jeu jeu) {
		return jeuDao.save(jeu);
	}
	
	@Override
    public boolean supprimerJeu(Long id) {
        
        jeuDao.deleteById(id);
        
        return recupererJeu(id) != null;
    }

	@Override
	public void nommerImmage(Long id, String fileName) {
		Jeu jeu = recupererJeu(id);
		jeu.setImage(fileName);
		jeuDao.save(jeu);
	}

	@Override
	public Jeu convertFromDto(JeuDTO j) {
		String dto = new Gson().toJson(j);
		Jeu jeu = new Gson().fromJson(dto, Jeu.class);
		return jeu;
	}

}