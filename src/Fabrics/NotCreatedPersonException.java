package Fabrics;

public class NotCreatedPersonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotCreatedPersonException() {
		super("Impossible de récupérer l'ID  de la personne créée") ;
	}
	

}
