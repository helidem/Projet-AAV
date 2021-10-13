package algos;

import sac.Objet;
import sac.SacADos;

import java.util.*;

public class Gloutonne extends Algorithme{

    public Gloutonne(SacADos sac){
        super(sac);
    }

    @Override
    public void resoudre(){
        ArrayList<Objet> trie = new ArrayList<>(objets);
        triRapideRec(trie, 0,trie.size() -1);

        Iterator<Objet> it = trie.iterator();
        while(it.hasNext() && sac.getPoidsActuel() < sac.getPoidsmax()){
            sac.add(it.next());
        }
    }

    private void triRapideRec(List<Objet> objets, int p, int d){
        if(p<d){
            int pivot = (d - p) / 2 + p;
            pivot = repartir(objets, p, d,pivot);
            triRapideRec(objets, p, pivot-1);
            triRapideRec(objets, pivot + 1, d);
        }
    }

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
