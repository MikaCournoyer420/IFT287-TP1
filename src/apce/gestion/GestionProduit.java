package apce.gestion;

import apce.tables.TableProduit;

public class GestionProduit extends GestionTransactions {
    public GestionProduit(TableProduit produits) {
        super(produits.getConnexion());
        //TODO votre code ici
    }
}
