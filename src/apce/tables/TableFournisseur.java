package apce.tables;

import apce.bdd.Connexion;
import apce.tuples.TupleFournisseur;

import java.util.ArrayList;
import java.util.List;

public class TableFournisseur extends GestionTables{
    public TableFournisseur(Connexion cx) {
        super(cx);
        /*TODO votre code ici
        this.stmtInsert = cx.getConnection().prepareStatement(
                "INSERT INTO fournisseur" + " VALUES (?, ?, ?)"
        );*/
    }

    public boolean existe(String nom) {
        /*TODO votre code ici
        stmtGet.setString(1, nom);
        ResultSet rs = stmtGet.executeQuery();
        if (rs.next()) {
            return true;
        }
        resultSet.close();
*/
        return false;
    }
    public List<TupleFournisseur> getFournisseursProducteur(String nomProducteur) {
        //TODO votre code ici
        return new ArrayList<>();
    }
}
