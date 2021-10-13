package algos;
import sac.SacADos;

public class Dynamique extends Algorithme{
    public Dynamique(SacADos sac) {
        super(sac);
    }

    @Override
    public void resoudre() {
        // créer une matrice de valeurs de taille nombre d'objets * le poids max du sac
        float[][] M = new float[sac.getObjetsPossibles().size()][Math.round(sac.getPoidsmax())+1];

        // remplir la premiere ligne
        for(int j = 0;j<= sac.getPoidsmax();j++){
            if(objets.get(0).getPoids() > j){
                M[0][j] = 0;
            }else{
                M[0][j] = objets.get(0).getPrix();
            }
        }

        // remplir les autres lignes
        for(int i = 1;i< objets.size();i++){
            for(int j =0;j<= sac.getPoidsmax();j++){
                if(objets.get(i).getPoids()>j){
                    M[i][j] = M[i-1][j];
                }else{
                    //M[i][j] = maximum ( M[i-1][j], M[i-1][j-poidsObjet[i]] + valeurObjet[i] )
                    M[i][j] = Math.max(M[i-1][j],M[i-1][Math.round(j-objets.get(i).getPoids())]+objets.get(i).getPrix());
                }
            }
        }

        // recuperer les objets


    }
}
