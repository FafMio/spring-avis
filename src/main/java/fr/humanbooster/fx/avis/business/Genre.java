package fr.humanbooster.fx.avis.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Ne peux pas etre vide :  libellé du genre")
	private String nom;
	
	// Pour un genre donné, on peut
	// avoir plusieurs jeux
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(mappedBy="genre")
	private List<Jeu> jeux;

	public Genre(String nom) {
		this.nom = nom;
	}
	
}