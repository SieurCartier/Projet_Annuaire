package Utils;

public class NotCreatedEntreeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedEntreeException() {
		super("Impossible de r�cup�rer l'ID  de l'entr�e cr��e");
	}
}
