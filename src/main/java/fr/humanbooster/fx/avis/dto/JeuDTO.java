package fr.humanbooster.fx.avis.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JeuDTO {

	@NotBlank(message="Ne peux pas etre vide : le nom du jeu.")
	String nom;

	@NotBlank(message = "Ne peux pas etre vide : la description du jeu")
	private String description;

	@NotNull(message="Ne peux pas etre vide : la date de sortie")
	private String dateSortie;

	@NotNull(message="Ne peux pas etre vide : le nom du model economique")
	private String modelEco;

	@NotNull(message="Ne peux pas etre vide : le nom de la classification")
	private String classification;

	@NotNull(message="Ne peux pas etre vide : le nom du genre")
	private String genre;

	@NotNull(message="Ne peux pas etre vide : l'editeur'")
	private long editeurId;

	@NotNull(message="Ne peux pas etre vide : image'")
	private String image;
}
