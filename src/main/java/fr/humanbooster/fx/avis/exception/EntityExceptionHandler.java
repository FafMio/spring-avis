package fr.humanbooster.fx.avis.exception;

/**
 * author : Samuel
 */
public class EntityExceptionHandler {
	
	  public static <E> E throwEntiteDejaPresente(E entite, String message) {
	    throw new RuntimeException(entite.toString() + message);
	  }
}
