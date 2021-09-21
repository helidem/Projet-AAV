package sac;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
    private final float poidsmax;
    private ArrayList<Objet> objets = new ArrayList<>();
    private ArrayList<Objet> objetsPossibles = new ArrayList<>();

    public SacADos(){
        poidsmax = 30;
    }

    public SacADos(String chemin, float poidsmax){
        this.poidsmax = poidsmax;

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
}
