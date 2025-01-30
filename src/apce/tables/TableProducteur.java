package apce.tables;

import apce.bdd.Connexion;
import apce.tuples.TupleProducteur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableProducteur extends GestionTables {
    private final PreparedStatement stmtInsert;
    private final PreparedStatement stmtGet;
    //private final PreparedStatement stmtGetAll;
    //private final PreparedStatement stmtDelete;

    public TableProducteur(Connexion cx) throws SQLException {
        super(cx);
        this.stmtInsert = cx.getConnection().prepareStatement(
                "INSERT INTO Producteur(nomProducteur, courriel, nombreEmployes, adresse)" +
                        "VALUES (?, ?, ?, ?)"
        );
        this.stmtGet = cx.getConnection().prepareStatement(
                "SELECT nomProducteur, courriel, nombreEmployes, adresse FROM Producteur WHERE nomProducteur = ?"
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
}
