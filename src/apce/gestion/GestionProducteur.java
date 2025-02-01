package apce.gestion;

import apce.CollantException;
import apce.bdd.Connexion;
import apce.tables.TableFournisseur;
import apce.tables.TableProducteur;
import apce.tables.TableProduit;
import apce.tuples.TupleFournisseur;
import apce.tuples.TupleProducteur;
import apce.tuples.TupleProduit;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GestionProducteur extends GestionTransactions{
    private final TableProducteur producteurs;
    private final TableProduit produits;
    private final TableFournisseur fournisseurs;

    public GestionProducteur(TableProducteur producteurs, TableProduit produits, TableFournisseur fournisseurs) {
        super(producteurs.getConnexion());
        this.producteurs = producteurs;
        this.produits = produits;
        this.fournisseurs = fournisseurs;
    }

    /**
     * Ajout d'un nouveau producteur au système.
     */
    public void ajouterProducteur(String nom, String courriel, int nombreEmployes, String adresse) throws SQLException, CollantException {
        try {
            cx.demarreTransaction();
            // verifier si le client existe deja
            if (producteurs.existe(nom))
                throw new CollantException("Le producteur "+ nom +" existe deja.");
            producteurs.ajouterProducteur(nom, courriel, nombreEmployes, adresse);
            cx.executeTransaction();
        }catch (Exception e) {
            cx.annuleTransaction();
            throw e;
        }
    }

    public void afficherProducteur(String nomProducteur) throws SQLException {
        try
        {
            cx.demarreTransaction();
            TupleProducteur tupleProducteur = producteurs.getProducteur(nomProducteur);
            System.out.print("\nProducteur:");
            System.out.println("\nNom Courriel NombreEmployes Adresse");
            System.out.println(tupleProducteur.nom + " " + tupleProducteur.courriel + " " + tupleProducteur.nbEmploi + " " + tupleProducteur.adresse);


            List<TupleProduit> produitList = produits.getProduitsFromProducteur(nomProducteur);
            System.out.print("\nProduits:");
            for (TupleProduit produit : produitList)
            {
                System.out.println(produit.nom);
            }

            List<TupleFournisseur> fournisseurList = fournisseurs.getFournisseursProducteur(nomProducteur);
            System.out.print("\nFournisseurs:");
            for (TupleFournisseur fournisseur : fournisseurList)
            {
                System.out.println(fournisseur.nom);
            }
            cx.executeTransaction();
        } catch (Exception e)
        {
            cx.annuleTransaction();
            throw e;
        }
    }

    public void supprimerProducteur(String nomProducteur) throws Exception {
        //TODO votre code ici
        try {
            cx.demarreTransaction();
            if(producteurs.existe(nomProducteur)) {
                throw new Exception("Le producteur "+ nomProducteur +" n'existe pas.");
            }
            producteurs.supprimerProducteur(nomProducteur);
            cx.executeTransaction();
        } catch (Exception e) {
            cx.annuleTransaction();
            throw e;
        }
    }
}
