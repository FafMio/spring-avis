package fr.humanbooster.fx.avis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.avis.business.Avis;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.business.Joueur;
import fr.humanbooster.fx.avis.business.Utilisateur;
import fr.humanbooster.fx.avis.service.AvisService;
import fr.humanbooster.fx.avis.service.ClassificationService;
import fr.humanbooster.fx.avis.service.EditeurService;
import fr.humanbooster.fx.avis.service.GenreService;
import fr.humanbooster.fx.avis.service.JeuService;
import fr.humanbooster.fx.avis.service.ModeleEconomiqueService;
import fr.humanbooster.fx.avis.service.PlateformeService;
import fr.humanbooster.fx.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvisController {
	
	private static final int NB_JEUX_PAR_PAGE = 5;
	
	private ClassificationService classificationService;
	private EditeurService editeurService;
	private GenreService genreService;
	private JeuService jeuService;
	private ModeleEconomiqueService modeleEconomiqueService;
	private PlateformeService plateformeService;
	private UtilisateurService utilisateurService;
	private AvisService avisService;
	private HttpSession httpSession;
	private static String DOSSIER_IMAGES = "src/main/webapp/images/";

	@RequestMapping(value = { "/index", "/" }, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.PUT})
	public ModelAndView accueil(
			@PageableDefault(size = NB_JEUX_PAR_PAGE, sort = "nom", direction = Sort.Direction.ASC) Pageable pageable) {
		ModelAndView mav = new ModelAndView("index");
		Page<Jeu> jeux = jeuService.recupererJeux(pageable);
		mav.addObject("pageDeJeux", jeux);
		Joueur joueurEnSession = null;
		if ((Joueur) httpSession.getAttribute("utilisateur") != null) {
			joueurEnSession = (Joueur) httpSession.getAttribute("utilisateur");
		}
		mav.addObject("joueur", joueurEnSession);
		return mav;
	}

	@GetMapping(value = "/connexion")
	public ModelAndView connexionGet() {
		ModelAndView mav = new ModelAndView("connexion");
		return mav;
	}

	@PostMapping("connexion")
	public ModelAndView connecterPost(@RequestParam("PSEUDO") String pseudo,
			@RequestParam("MOT_DE_PASSE") String motDePasse) {
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(pseudo, motDePasse);
		if (utilisateur != null) {

			httpSession.setAttribute("utilisateur", utilisateur);
			Sort sort = Sort.by("nom");
			return accueil(PageRequest.of(0, 10, sort));
		} else {
			// On redirige l'utilisateur vers la page de connexion en le notifiant de l'erreur
			// de connexion
			ModelAndView mav = new ModelAndView("connexion");
			mav.addObject("notification", "Erreur de connection");
			return mav;
		}
	}

	@RequestMapping(value = { "/lesAvis" })
	public ModelAndView lesAvis(Pageable pageable) {
		ModelAndView mav = new ModelAndView("lesAvis");
		Page<Avis> lesAvis = avisService.recupererAvis(pageable);
		mav.addObject("pageDAvis", lesAvis);
		return mav;
	}

	@RequestMapping(value = { "/avis" })
	public ModelAndView avis() {
		ModelAndView mav = new ModelAndView("avis");
		mav.setViewName("avis");
		mav.addObject("jeux", jeuService.recupererJeux());
		return mav;
	}

	@GetMapping(value = { "/jeu" })
	public ModelAndView jeuGet(@ModelAttribute Jeu jeu,
			@RequestParam(name="ID", required=false) Long id) {
		
		System.out.println("id=" + jeu.getId());
		ModelAndView mav = new ModelAndView("jeu");
		if (id!=null) {
			//mav.addObject("jeu", jeuService.recupererJeu(id));
			// Ecriture équivalente :
			mav.getModel().put("jeu", jeuService.recupererJeu(id));
		}

		mav.addObject("editeurs", editeurService.recupererEditeurs());
		mav.addObject("genres", genreService.recupererGenres());
		mav.addObject("classifications", classificationService.recupererClassifications());
		mav.addObject("plateformes", plateformeService.recupererPlateformes());
		mav.addObject("modeleEconomiques", modeleEconomiqueService.recupererModelesEconomiques());

		return mav;
	}

	@PostMapping("jeu")
	public ModelAndView jeuPost(@Valid @ModelAttribute Jeu jeu, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView mav = jeuGet(jeu, jeu.getId());
			mav.addObject("jeu", jeu);
			return mav;
		} else {
			jeuService.ajouterJeu(jeu);
			return new ModelAndView("redirect:index");
		}
	}

	@GetMapping("/televersement")
	public ModelAndView televersementGet(@RequestParam("ID") Long id) {
		ModelAndView mav = new ModelAndView("televersement");
		mav.addObject("jeu", jeuService.recupererJeu(id));
		return mav;
	}

	@PostMapping("televersement")
	@Transactional(isolation = Isolation.DEFAULT)
	public ModelAndView televersementPost(@RequestParam("ID") Long id, @RequestParam("FICHIER") MultipartFile multipartFile)
			throws IOException {

		String nomFichier = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		jeuService.nommerImmage(id, nomFichier);
		enregisterFichier(nomFichier, multipartFile);

		return new ModelAndView("redirect:index");
	}

	@PostMapping("envoyerAvis")
	public ModelAndView envoyerAvis(@RequestParam("DESCRIPTION") String description, @RequestParam("ID_JEU") Long idJeu,
			@RequestParam("NOTE") float note, @RequestParam("ID_JOUEUR") Long idJoueur) {
		avisService.ajouterAvis(description, note, jeuService.recupererJeu(idJeu),
				(Joueur) utilisateurService.recupererUtilisateur(idJoueur));
		ModelAndView mav = new ModelAndView("avis");
		mav.addObject("joueur", new Joueur());
		return new ModelAndView("redirect:index");
	}

	@PostMapping("filtrer")
	public ModelAndView filtrer(@RequestParam("ID_GENRE") Long idGenre,
			@PageableDefault(value = 10, sort = "nom", direction = Direction.ASC) Pageable pageable) {
		ModelAndView mav = new ModelAndView("index");
		if (idGenre.equals(0L)) {
			Page<Jeu> jeux = jeuService.recupererJeux(pageable);
			mav.addObject("pageDeJeux", jeux);
			mav.addObject("jeux", jeux.getContent());
			mav.addObject("size", jeux.getSize());
			mav.addObject("sort", jeux.getSort().iterator().next().getProperty());
			mav.addObject("page", jeux.getNumber());
			mav.addObject("nbPages", jeux.getTotalPages());
			mav.addObject("genres", genreService.recupererGenres());
		} else {
			Page<Jeu> jeux = jeuService.recupererJeux(idGenre, pageable);
			mav.addObject("pageDeJeux", jeux);
			mav.addObject("jeux", jeux.getContent());
			mav.addObject("size", jeux.getSize());
			mav.addObject("sort", jeux.getSort().iterator().next().getProperty());
			mav.addObject("page", jeux.getNumber());
			mav.addObject("nbPages", jeux.getTotalPages());
			mav.addObject("genres", genreService.recupererGenres());
		}

		return mav;
	}

	@GetMapping(value = "/inscription")
	public ModelAndView inscriptionGet(@ModelAttribute Joueur joueur) {
		ModelAndView mav = new ModelAndView("inscription");
		return mav;
	}

	@PostMapping("/inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute Joueur joueur, BindingResult result) {
		System.out.println(result);
		if (result.hasErrors()) {
			ModelAndView mav = inscriptionGet(joueur);
			mav.addObject("joueur", joueur);
			return mav;
		} else {
			utilisateurService.ajouterJoueur(joueur);
			ModelAndView mav = new ModelAndView("redirect:index");
			return mav;
		}
	}

	@GetMapping("deconnexion")
	public ModelAndView deconnexion() {
		httpSession.invalidate();
		return new ModelAndView("redirect:index");
	}

	@RequestMapping(value = { "editeurs" })
	public ModelAndView editeur() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editeurs");
		mav.addObject("editeurs", editeurService.recupererEditeurs());
		return mav;
	}

	private static void enregisterFichier(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(DOSSIER_IMAGES);

		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}
}