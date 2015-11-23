package Fabrics;

import java.sql.*;
import java.util.*;
import Domaine.*;
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

	public void deleteEntrie(Entree e) {
		try {
			PreparedStatement pr = con.prepareStatement("DELETE FROM Entree WHERE idEntree =?");
			pr.setInt(1, e.getIndex());
			pr.executeUpdate();

			lesNums.get(e.getPersonne()).remove(e);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<Entree> getEntriesOf(Personne p) {
		if (!lesNums.containsKey(p)) {
			try {
				PreparedStatement pr = con.prepareStatement("SELECT * FROM Entree where idPersonne=?");
				pr.setInt(1, p.getId());

				ResultSet allEntries = pr.executeQuery();

				while (allEntries.next()) {
					List<Entree> temp = new LinkedList<Entree>();
					temp.add(new Entree(allEntries.getInt("idEntree"), allEntries.getString("code"),
							allEntries.getString("valeur"), p));
					lesNums.put(p, temp);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return lesNums.get(p);
	}

}
