package algos;

import sac.Objet;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ABR {

    private ABR filsGauche, filsDroit;
    private ABR parent;
    private int profondeur;
    private float prix;
    private float poids;

    /**
     * Constructeur d'un ABR racine
     */
    public ABR(){
        this.parent = this;
        this.profondeur = 0;
        this.prix = 0;
        this.poids = 0;
    }




}
