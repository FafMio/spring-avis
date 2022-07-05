package fr.humanbooster.fx.avis.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = DixHuitAnsOuPlusValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface DixHuitAnsOuPlus {

	String message() default "Vous devez avoir au moins 18 ans";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
