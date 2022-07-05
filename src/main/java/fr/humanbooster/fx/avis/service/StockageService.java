package fr.humanbooster.fx.avis.service;

import org.springframework.web.multipart.MultipartFile;

public interface StockageService {

	void enregistrerFichier(MultipartFile multipartFile, Long id);
		
}
