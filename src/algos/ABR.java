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
    // Indice de l'objet dans la liste d'objets totaux
    private int indiceObjet;

    /**
     * Constructeur d'un ABR racine
     */
    public ABR(){
        this.parent = this;
        this.profondeur = 0;
        this.prix = 0;
        this.poids = 0;
        this.indiceObjet = -1;
    }

    /**
     * Constructeur pour créer un nœud à l'ABR
     * @param parent le nœud parent
     * @param prix le prix total du nœud
     * @param poids le poids total du noeud
     * @param indiceObjet l'indice de l'objet à ajouter
     */
    public ABR(ABR parent, float prix, float poids, int indiceObjet){
        this.parent = parent;
        this.profondeur = parent.profondeur + 1;
        this.poids = poids;
        this.prix = prix;
        this.indiceObjet = indiceObjet;
    }

    /**
     * Crée le fils droit en lui rajoutant rien (-1)
     */
    public void setFilsDroit() {
        this.filsDroit = new ABR(this, this.prix, this.poids, -1);
    }

    /**
     * Crée le fils gauche en lui rajoutant un objet de la liste
     * @param o l'objet en question
     * @param indiceObjet l'indice de cet objet
     */
    public void setFilsGauche(Objet o, int indiceObjet){
        this.filsGauche = new ABR(this,this.prix + o.getPrix(), this.poids + o.getPoids(), indiceObjet);
    }

    public ABR getFilsGauche() {
        return filsGauche;
    }

    public ABR getFilsDroit() {
        return filsDroit;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public float getPrix() {
        return prix;
    }

    public float getPoids() {
        return poids;
    }

    public int getIndiceObjet() {
        return indiceObjet;
    }

    public ABR getParent() {
        return parent;
    }

    public boolean isRoot(){
        return this.profondeur == 0;
    }
}
