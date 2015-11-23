package Fabrics;

import java.sql.*;
import java.util.*;

import Domaine.Personne;
import Utils.InexistantPersonException;
import Utils.NotCreatedPersonException;

public class FabricPersonne {

	private static FabricPersonne singleton;
	private MySQLConnection con;

	private HashMap<Integer, Personne> lesGens;

	private FabricPersonne() {
		this.con = MySQLConnection.getInstanceOf();
		lesGens = new HashMap<Integer, Personne>();
	}

	public static FabricPersonne getInstanceOf() {
		if (singleton == null) {
			singleton = new FabricPersonne();
		}
		return singleton;
	}

	public Personne createPersonne(String nom, String prenom) {
		Personne ret = null;
		try {
			int idPersonne;
			PreparedStatement pr = con.prepareStatement("INSERT INTO Annuaire(Nom, Prenom) VALUES(?,?)");
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (newIdResult.next()) {
				idPersonne = newIdResult.getInt(1);
			} else {
				throw new NotCreatedPersonException();
			}

			ret = new Personne(idPersonne, nom, prenom);

			lesGens.put(idPersonne, ret);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void deletePersonne(Personne p) {
		try {
			FabricEntree.getInstanceOf().deleteAllEntries(p);
			;

			PreparedStatement pr = con.prepareStatement("DELETE FROM Annuaire WHERE idPersonne =?");
			pr.setInt(1, p.getId());

			int err = pr.executeUpdate();

			if (err != 1) {
				throw new InexistantPersonException();
			}

			lesGens.remove(p);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void populate() {
		try {
			PreparedStatement pr = con.prepareStatement("SELECT * FROM Annuaire");
			ResultSet everybody = pr.executeQuery();

			while (everybody.next()) {
				lesGens.put(everybody.getInt("idPersonne"), new Personne(everybody.getInt("idPersonne"),
						everybody.getString("nom"), everybody.getString("prenom")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Collection<Personne> getEverybody() {
		return lesGens.values();
	}

}
