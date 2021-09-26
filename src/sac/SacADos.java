package sac;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
    private final float poidsmax;
    private float poidsActuel;
    private ArrayList<Objet> objetsDansSac= new ArrayList<>();//objets dans le sac a dos
    private ArrayList<Objet> objetsPossibles= new ArrayList<>(); //tous les objets possibles dans la liste

    public SacADos(){
        this.poidsmax = 0;
        this.poidsActuel=0;
    }

    public SacADos(String chemin, float poidsmax){
        this.poidsmax = poidsmax;
        this.objetsDansSac = new ArrayList<>();
        this.objetsPossibles = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(chemin));
            s.useDelimiter("[;]");

            while (s.hasNext()){
                String txt = s.nextLine();
                String[] elements = txt.split(";");
                String nom = elements[0];
                float poids = Float.parseFloat(elements[1]);
                float prix = Float.parseFloat(elements[2]);
                Objet o = new Objet(nom,poids,prix);
                objetsPossibles.add(o);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void resoudre(){

    }

    public void viderSac(){
        this.poidsActuel = 0;
        this.objetsDansSac.clear();
    }



}
