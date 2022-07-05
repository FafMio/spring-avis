package fr.humanbooster.fx.avis.controller;

import fr.humanbooster.fx.avis.business.Editeur;
import fr.humanbooster.fx.avis.service.EditeurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/editeurs")
public class EditeurController {

    private EditeurService editeurService;

    @GetMapping("/")
    public List<Editeur> showAll() {
        return editeurService.recupererEditeurs();
    }

    @GetMapping("/{id}")
    public Editeur show(@PathVariable Long id) {
        return editeurService.recupererEditeur(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return editeurService.supprimerEditeur(id);
    }

    @PatchMapping("/{id}/{nouveauNom}")
    public Editeur update(@PathVariable Long id, @PathVariable String nouveauNom) {
        return editeurService.mettreAJour(id, nouveauNom);
    }

    @PostMapping("/{nom}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Editeur add(@PathVariable String nom) {
        return editeurService.ajouterEditeur(nom);
    }
}
