package apce.gestion;

import apce.tables.TableFournisseur;
import apce.tables.TableProducteurFournisseur;
import apce.tables.TableProduitFournisseur;

public class GestionFournisseur extends GestionTransactions {
    public GestionFournisseur(TableFournisseur fournisseurs, TableProduitFournisseur produitsFournisseurs, TableProducteurFournisseur producteursFournisseurs) {
        super(fournisseurs.getConnexion());
        //TODO votre code ici
    }

    public void ajouterFournisseur(String nom, String courriel, String adressePostale) {
        /*TODO votre code ici
        try {
            cx.demarrerTransaction();
            if (fournisseurs.existe(nom)) {
                throw new Exception("Le fournisseur "+ nom +" existe déjà.");
            }
            fourniseur.ajouterFournisseur(nom, courriel, adressePostale);
        } catch (Exception e) {
            cx.annuleTransaction();
            throw e;
        }*/
    }

    public void fabriquerProduit(String nomFournisseur, String nomProduit) {
        //TODO votre code ici
    }

    public void afficherFournisseur(String nom) {
        //TODO votre code ici
    }
}
