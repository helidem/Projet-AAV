package sac;

import algos.Algorithme;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SacADos implements Iterable<Objet>{ //iterable pour etre utilisé dans une boucle for each
    private final float poidsmax;
    private float poidsActuel;
    private ArrayList < Objet > objetsDansSac = new ArrayList < > (); //objets dans le sac a dos
    private ArrayList < Objet > objetsPossibles = new ArrayList < > (); //tous les objets possibles dans la liste

    public SacADos() {
        this.poidsmax = 0;
        this.poidsActuel = 0;
    }

    public float getPoidsmax() {
        return poidsmax;
    }

    public float getPoidsActuel() {
        return poidsActuel;
    }

    public float getPrixTotal(){
        float prix = 0;
        for(Objet o : this)
            prix+=o.getPrix();
        return prix;
    }

    /**
     * Constructeur du sac a dos
     * @param chemin le chemin du fichier des items
     * @param poidsmax le poids max de l'objet
     */
    public SacADos(String chemin, float poidsmax) {
        this.poidsmax = poidsmax;
        this.objetsDansSac = new ArrayList < > ();
        this.objetsPossibles = new ArrayList < > ();

        try {
            Scanner s = new Scanner(new File(chemin));
            s.useDelimiter("[;]");

            while (s.hasNext()) {
                String txt = s.nextLine();
                String[] elements = txt.split(";");
                String nom = elements[0];
                float poids = Float.parseFloat(elements[1]);
                float prix = Float.parseFloat(elements[2]);
                Objet o = new Objet(nom, poids, prix);
                objetsPossibles.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList < Objet > getObjetsPossibles() {
        return objetsPossibles;
    }

    /**
     * Lance la résolution
     * @param algo l'algorithme en question
     */
    public void resoudre(Algorithme algo) {
         algo.resoudre();
    }

    /**
     * Vide le sac entièrement
     */
    public void viderSac() {
        this.poidsActuel = 0;
        this.objetsDansSac.clear();
    }

    /**
     * Permet d'ajouter un objet dans le sac
     * @param o l'objet en question
     */
    public void add(Objet o) {
        if (o.getPoids() + this.poidsActuel <= this.poidsmax) {
            this.objetsDansSac.add(o);
            this.poidsActuel += o.getPoids();
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Sac à dos").append("\n").append("Prix total des objets : ").append(this.getPrixTotal()).append("$\n").
                append("Poids : ").append(this.getPoidsActuel()).append("\n").append("Poids max : ").
                append(this.getPoidsmax()).append("\n").append("Objets dans ce sac : ").append("\n");
        for(Objet o: this.objetsDansSac)
            sb.append("-").append(o).append("\n");
        return sb.toString();
    }

    /**
     * Pour pouvoir iterer dans le sac a dos en toute facilité
     * @return l'iterator du sac (les objets dedans)
     */
    @Override
    public Iterator<Objet> iterator() {
        return this.objetsDansSac.iterator();
    }
}