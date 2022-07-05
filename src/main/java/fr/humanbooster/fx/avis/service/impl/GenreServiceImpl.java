package fr.humanbooster.fx.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.avis.business.Genre;
import fr.humanbooster.fx.avis.dao.GenreDao;
import fr.humanbooster.fx.avis.service.GenreService;

@Service 
public class GenreServiceImpl implements GenreService {

	private GenreDao genreDao;
	
	public GenreServiceImpl(GenreDao genreDao) {
		super();
		this.genreDao=genreDao;
	}
	
	@Override
	public Genre ajouterGenre(String nom) {
		return genreDao.save(new Genre(nom));
	}
	
	@Override
	public Genre recupererGenre(String nom) {
		return genreDao.findFirstByNomLike("%"+nom+"%");
	}
	
	@Override
	public List<Genre> recupererGenres(String nom) {
		return genreDao.findByNomLike("%"+nom+"%");
	}
	
	@Override
	public List<Genre> recupererGenres() {
		return genreDao.findAll();
	}

	@Override
	public long compterGenres() {
		return genreDao.count();
	}

}