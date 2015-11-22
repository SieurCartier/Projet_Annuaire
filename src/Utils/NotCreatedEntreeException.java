package Utils;

public class NotCreatedEntreeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedEntreeException() {
		super("Impossible de récupérer l'ID  de l'entrée créée");
	}
}
