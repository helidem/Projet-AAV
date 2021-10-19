package algos;
import sac.SacADos;

public class Dynamique extends Algorithme{
    public Dynamique(SacADos sac) {
        super(sac);
    }

    /**
     * Methode qui resous le problème avec la méthode dynamique
     */
    @Override
    public void resoudre() {
        // créer une matrice de valeurs de taille nombre d'objets * le poids max du sac
        int nbObjets = objets.size();
        int castedPoidsMax = (int) sac.getPoidsmax()*10; // On cast pour éviter les problèmes avec les floats.
        float[][] M = new float[nbObjets][castedPoidsMax+1];

        // remplir la premiere ligne
        for(int j = 0;j<= castedPoidsMax;j++){
            if((objets.get(0).getPoids()*10) > j){
                M[0][j] = 0;
            }else{
                M[0][j] = objets.get(0).getPrix();
            }
        }

        // remplir les autres lignes
        for(int i = 1;i< nbObjets;i++){
            for(int j =0;j<= castedPoidsMax;j++){
                if((objets.get(i).getPoids()*10)>j){
                    M[i][j] = M[i-1][j];
                }else{
                    //M[i][j] = maximum ( M[i-1][j], M[i-1][j-poidsObjet[i]] + valeurObjet[i] )
                    M[i][j] =  Math.max(M[i-1][j],(M[i-1][(int) ((j-objets.get(i).getPoids()*10))]+objets.get(i).getPrix()));
                }
            }
        }

        // recuperer les objets

        // Chaque case du tableau représente le bénéfice maximum possible pour les i premiers objets avec un poids j.

        int i = nbObjets-1; // -1 sinon "outOfBounds"
        int j = castedPoidsMax;

        /*
        TANT QUE M[i][j] EGALE M[i][j-1]
            décrémente j
         */

        while(M[i][j] == M[i][j-1])
            j--;

        /*
        TANT QUE j > 0
            TANT QUE i > 0 ET M[i][j] EGALE M[i-1][j]
                décrémente i
            j = j - PoidsObjet[i]
            SI j > 0
                Ajoute-objet ( Objet[i] )
            décrémente i
         */

        while(j>0){
            while((i > 0) && (M[i ][j] == M[i-1][j])){
                i--;
            }
            j -= (int) (objets.get(i).getPoids() * 10);
            if(j>=0)
                sac.add(objets.get(i));
            i--;
        }
    }
}
