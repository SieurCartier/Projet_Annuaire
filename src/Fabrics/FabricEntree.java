package Fabrics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import Domaine.Entree;
import Domaine.Personne;
import Utils.NotCreatedEntreeException;

public class FabricEntree {

	private static FabricEntree singleton;
	private MySQLConnection con;
	private HashMap<Personne, List<Entree>> lesNums;

	private FabricEntree() {
		this.con = MySQLConnection.getInstanceOf();
		lesNums = new HashMap<Personne, List<Entree>>();
	}

	public static FabricEntree getInstanceOf() {
		if (singleton == null) {
			singleton = new FabricEntree();
		}
		return singleton;
	}

	public Entree createEntree(String code, String valeur, Personne p) {
		Entree ret = null;
		try {
			int idEntree;
			PreparedStatement pr = con.prepareStatement("INSERT INTO Entree(code, valeur, idpersonne) VALUES(?, ?, ?)");
			pr.setString(1, code);
			pr.setString(2, valeur);
			pr.setInt(3, p.getId());
			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (newIdResult.next()) {
				idEntree = newIdResult.getInt(1);
			} else {
				throw new NotCreatedEntreeException();
			}

			ret = new Entree(idEntree, code, valeur, p);

			if (!lesNums.containsKey(p)) {
				lesNums.put(p, new LinkedList<Entree>());
			}

			lesNums.get(p).add(ret);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void deleteAllEntries(Personne p) {
		try {
			PreparedStatement pr = con.prepareStatement("DELETE FROM Entree WHERE idPersonne =?");
			pr.setInt(1, p.getId());
			pr.executeUpdate();
			lesNums.remove(p);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteEntrie(Entree e, Personne p) {
		try {
			PreparedStatement pr = con.prepareStatement("DELETE FROM Entree WHERE idEntree =?");
			pr.setInt(1, e.getIndex());
			pr.executeUpdate();

			lesNums.get(p).remove(e);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
