package fr.humanbooster.fx.avis.controller;

import fr.humanbooster.fx.avis.business.Classification;
import fr.humanbooster.fx.avis.business.Jeu;
import fr.humanbooster.fx.avis.dto.JeuDTO;
import fr.humanbooster.fx.avis.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jeu")
public class JeuRestController {

    private JeuService jeuService;
    private EditeurService editeurService;
    private ModeleEconomiqueService modeleEconomiqueService;
    private ClassificationService classificationService;
    private GenreService genreService;

    @PostMapping("/")
    @ResponseStatus(code= HttpStatus.CREATED)
    private Jeu add (@RequestBody @Valid JeuDTO jeuDTO, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        } else {
            Jeu jeu = new Jeu();
            jeu.setNom(jeuDTO.getNom());
            jeu.setImage(jeuDTO.getImage());
            jeu.setModeleEconomique(modeleEconomiqueService.recupererModeleEconomique(jeuDTO.getModelEco()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            jeu.setDateSortie(LocalDate.parse(jeuDTO.getDateSortie(), formatter));
            jeu.setDescription(jeuDTO.getDescription());
            jeu.setEditeur(editeurService.recupererEditeur(jeuDTO.getEditeurId()));
            jeu.setGenre(genreService.recupererGenre(jeuDTO.getGenre()));
            jeu.setClassification(classificationService.recupererClassification(jeuDTO.getClassification()));
            return jeuService.ajouterJeu(jeu);
        }
    }

    @GetMapping("/")
    private Page<Jeu> all (@PageableDefault(size=15, page=0, sort="nom") Pageable pageable) {
        return jeuService.recupererJeux(pageable);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Jeu> obtenirUnJeuParSonId (@RequestBody Long id) throws URISyntaxException {
        URI t = new URI("/api/jeu/" + id.toString());
        Jeu jeu = jeuService.recupererJeu(id);
        return ResponseEntity.created(t).body(jeu);
    }
}