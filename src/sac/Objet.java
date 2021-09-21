package sac;

public class Objet {
    private String nom;
    private float poids;
    private float prix;
    private boolean dansSac;

    public Objet(String nom, float poids, float prix) {
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
        this.dansSac = false;
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

    public String toString(){
        return "";
    }
}