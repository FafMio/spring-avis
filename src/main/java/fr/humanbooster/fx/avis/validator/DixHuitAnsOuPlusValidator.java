package fr.humanbooster.fx.avis.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.time.temporal.ChronoUnit.YEARS;

public class DixHuitAnsOuPlusValidator implements ConstraintValidator<DixHuitAnsOuPlus, LocalDate>{

	@Override
	public boolean isValid(LocalDate dateDeNaissance, ConstraintValidatorContext context) {
		return dateDeNaissance!=null && YEARS.between(dateDeNaissance, LocalDate.now())>=18;
	}

}
