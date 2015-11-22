package Utils;

public class InexistantPersonException extends Exception {

	private static final long serialVersionUID = 1L;

	public InexistantPersonException() {
		super("La personne que vous tentez de supprimer n'existe pas");
	}

}
