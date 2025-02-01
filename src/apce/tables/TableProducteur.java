package apce.tables;

import apce.bdd.Connexion;
import apce.tuples.TupleProducteur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableProducteur extends GestionTables {
    private final PreparedStatement stmtInsert;
    private final PreparedStatement stmtGet;
    private final PreparedStatement stmtGetAll;
    private final PreparedStatement stmtDelete;

    public TableProducteur(Connexion cx) throws SQLException {
        super(cx);
        this.stmtInsert = cx.getConnection().prepareStatement(
                "INSERT INTO Producteur(nom, courriel, nombre_employes, adresse_postale)" +
                        "VALUES (?, ?, ?, ?)"
        );
        this.stmtGet = cx.getConnection().prepareStatement(
                "SELECT nom, courriel, nombre_employes, adresse_postale FROM Producteur WHERE nom = ?"
        );
        this.stmtGetAll = cx.getConnection().prepareStatement(
                "SELECT nom, courriel, nombre_employes, adresse_postale FROM Producteur"
        );
        this.stmtDelete = cx.getConnection().prepareStatement(
                "DELETE FROM Producteur WHERE nom = ?"
        );
    }

    public boolean existe(String nom) throws SQLException {
        stmtGet.setString(1, nom);
        ResultSet resultSet = stmtGet.executeQuery();
        boolean existe = resultSet.next();
        resultSet.close();
        return existe;
    }

    public void ajouterProducteur(String nom, String courriel, int nombreEmployes, String adresse) throws SQLException {
        stmtInsert.setString(1, nom);
        stmtInsert.setString(2, courriel);
        stmtInsert.setInt(3, nombreEmployes);
        stmtInsert.setString(4, adresse);
        stmtInsert.executeUpdate();
    }

    public TupleProducteur getProducteur(String nomProducteur) throws SQLException {
        // TODO : votre implémentation ici
        return new TupleProducteur();
    }
    public void supprimerProducteur(String nomProducteur) throws SQLException {
        try {
            stmtDelete.setString(1, nomProducteur);
            stmtDelete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
