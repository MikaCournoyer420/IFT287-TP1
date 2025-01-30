package apce.tables;

import apce.bdd.Connexion;
import apce.tuples.TupleProduit;

import java.util.ArrayList;
import java.util.List;

public class TableProduit extends GestionTables {
    public TableProduit(Connexion cx) {
        super(cx);
        //TODO votre code ici
    }

    public List<TupleProduit> getProduitsFromProducteur(String nomProducteur) {
        //TODO : implémenter la fonction
        return new ArrayList<TupleProduit>();
    }
}
