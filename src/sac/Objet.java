package sac;

import java.util.Comparator;

public class Objet{
    private String nom;
    private float poids;
    private float prix;
    private boolean dansSac;
    private float ratio;

    /**
     * Constructeur d'objet
     * @param nom Le nom de l'objet
     * @param poids Le poids de l'objet
     * @param prix Le prix de l'objet
     */
    public Objet(String nom, float poids, float prix) {
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
        this.dansSac = false;
        this.ratio = prix/poids;
    }

    public float getPoids() {
        return poids;
    }

    public float getPrix() {
        return prix;
    }

    public float getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                ", poids=" + poids +
                ", prix=" + prix +
                '}';
    }

    public static Comparator<Objet> compareTo(){
        return (o1,o2) -> Float.compare(o2.getRatio(),o1.getRatio());
    }
}