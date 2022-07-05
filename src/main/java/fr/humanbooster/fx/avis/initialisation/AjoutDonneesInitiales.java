package fr.humanbooster.fx.avis.initialisation;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.Plateforme;
import fr.humanbooster.fx.avis.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Component
public class AjoutDonneesInitiales implements CommandLineRunner {

	private EditeurService editeurService;
	private ClassificationService classificationService;
	private PlateformeService plateformeService;
	private GenreService genreService;
	private ModeleEconomiqueService modeleEconomiqueService;
	private JeuService jeuService;

//	private static Random random = new Random();

//	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"), new RandomService());
//	private static Faker faker = new Faker(new Locale("fr-FR"));

	@Override
	public void run(String... args) throws Exception {

		editeurService.ajouterEditeur("Ubisoft");
		editeurService.ajouterEditeur("EA Sports");

		plateformeService.ajouterPlateforme("Wii");
		plateformeService.ajouterPlateforme("PS5");
		plateformeService.ajouterPlateforme("Switch");
		plateformeService.ajouterPlateforme("Xbox");

		classificationService.ajouterClassification("PEGI 3");
		classificationService.ajouterClassification("PEGI 12");

		genreService.ajouterGenre("FPS (First person shooter)");
		genreService.ajouterGenre("RTS (real-time strategy)");
		genreService.ajouterGenre("RPG (Role-playing game)");
		genreService.ajouterGenre("Simulation");
		genreService.ajouterGenre("Gestion");
		genreService.ajouterGenre("TPS (Third person shooter)");
		genreService.ajouterGenre("Digital collectible card game");
		genreService.ajouterGenre("MOBA (Multiplayer online battle arena)");
		genreService.ajouterGenre("MMORPG (massively multiplayer online role-playing game)");

		modeleEconomiqueService.ajouterModeleEconomique("Free to play");
		modeleEconomiqueService.ajouterModeleEconomique("Pay to play");

//		jeuService.ajouterJeu(
//				"jeu 1",
//				"description 1",
//				LocalDate.now(),
//				null,
//				null,
//				genreService.recupererGenre("Gestion"),
//				editeurService.recupererEditeur(1L),
//				null,
//				""
//				);

	}

//	@Scheduled(initialDelay = 8, fixedDelay = 2, timeUnit = TimeUnit.SECONDS)
//	private void ajouterJeuAleatoire() {
//		Jeu jeu = new Jeu();
//		jeu.setClassification(classificationService.recupererClassifications().get(random.nextInt((int) classificationService.compterClassifications())));
//		jeu.setGenre(genreService.recupererGenres().get(random.nextInt((int) genreService.compterGenres())));
//		jeu.setModeleEconomique(modeleEconomiqueService.recupererModelesEconomiques().get(random.nextInt((int) modeleEconomiqueService.compterModelesEconomiques())));
//		jeu.setEditeur(editeurService.recupererEditeurs().get(random.nextInt((int) editeurService.compterEditeurs())));
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2022, Calendar.JANUARY, 1);
//		Date dateDebut = calendar.getTime();
//		calendar = Calendar.getInstance();
//		Date dateFin = calendar.getTime();
//		Date dateAleatoire = faker.date().between(dateDebut, dateFin);
//		calendar.setTime(dateAleatoire);
//		jeu.setDateSortie(dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//		jeu.setNom(fakeValuesService.letterify("?????"));
//		jeu.setDescription(fakeValuesService.letterify("???????????"));
//		Set<Plateforme> plateformes = new HashSet<>();
//		int nbPlateformes = plateformeService.recupererPlateformes().size();
//		while (plateformes.size()<=1) {
//			plateformes.add(plateformeService.recupererPlateformes().get(random.nextInt(nbPlateformes)));
//		}
//		jeu.setPlateformes(plateformes);
//		jeuService.ajouterJeu(jeu);
//	}
}	
