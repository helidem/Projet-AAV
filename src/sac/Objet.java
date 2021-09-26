package sac;

import java.util.Comparator;

public class Objet{
    private String nom;
    private float poids;
    private float prix;
    private boolean dansSac;
    private float ratio;

    public Objet(String nom, float poids, float prix) {
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
        this.dansSac = false;
        this.ratio = prix/poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isDansSac() {
        return dansSac;
    }

    public void setDansSac(boolean dansSac) {
        this.dansSac = dansSac;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
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