package algos;

import sac.Objet;
import sac.SacADos;

import java.util.*;

public class Gloutonne extends Algorithme{

    public Gloutonne(SacADos sac){
        super(sac);
    }

    /**
     * Methode qui resous le problème avec la méthode dynamique
     */
    @Override
    public void resoudre(){
        ArrayList<Objet> trie = new ArrayList<>(objets);
        triRapideRec(trie, 0,trie.size() -1);
        Iterator<Objet> it = trie.iterator();
        while(it.hasNext() && sac.getPoidsActuel() < sac.getPoidsmax()){
            sac.add(it.next());
        }
    }

    /**
     * Methode qui tri une liste rapidement et recursivement (vue en cours)
     * @param objets La liste d'objets
     * @param p L'indice du premier objet de la liste (début)
     * @param d L'indice du dernier objet de la liste (fin)
     */
    private void triRapideRec(List<Objet> objets, int p, int d){
        if(p<d){
            int pivot = (d - p) / 2 + p;
            pivot = repartir(objets, p, d,pivot);
            triRapideRec(objets, p, pivot-1);
            triRapideRec(objets, pivot + 1, d);
        }
    }

    /**
     * Methode qui repartit les objets à partir de leur ratio autour du pivot (vue en cours)
     * @param objets La liste d'objets
     * @param p L'indice du premier objet de la liste (début)
     * @param d L'indice du dernier objet de la liste (fin)
     * @param pivot L'indice du pivot
     * @return
     */
    private int repartir(List<Objet> objets, int p, int d, int pivot) {
        Collections.swap(objets, pivot, d);
        int tmp = p;
        for(int j = p; j < d; j++){
            if(objets.get(j).getRatio() >= objets.get(d).getRatio()){
                Collections.swap(objets,j,tmp);
                tmp++;
            }
        }
        Collections.swap(objets, d,tmp);
        return tmp;
    }

}
