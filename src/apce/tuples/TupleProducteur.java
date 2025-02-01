package apce.tuples;

public class TupleProducteur {
    public String nom;
    public int nbEmploi;
    public String courriel;
    public String adresse;

    public TupleProducteur(){}

    public TupleProducteur(String nom, int nbEmploi, String courriel, String adresse){
        this.nom = nom;
        this.nbEmploi = nbEmploi;
        this.courriel = courriel;
        this.adresse = adresse;
    }
}
