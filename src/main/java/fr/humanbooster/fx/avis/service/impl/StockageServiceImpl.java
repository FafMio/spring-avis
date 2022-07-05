package fr.humanbooster.fx.avis.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fr.humanbooster.fx.avis.service.StockageService;

@PropertySource("classpath:nas.properties")
@Service
public class StockageServiceImpl implements StockageService {

	@Value("${path_nas}")
	private String path;
		
	@PostConstruct
	private void init() {
		System.out.println("Les images seront stockées dans " + path);
	}

	@Override
	public void enregistrerFichier(MultipartFile multipartFile, Long id) {
		// TODO Auto-generated method stub	
	}
}
