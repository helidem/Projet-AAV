package algos;

import sac.Objet;
import sac.SacADos;

import java.util.*;

public class Gloutonne extends Algorithme{

    public Gloutonne(SacADos sac){
        super(sac);

    }

    public void resoudre(){
        ArrayList<Objet> trié = new ArrayList<Objet>(objets);
        triRapideRec(trié, 0,trié.size() -1);

        Iterator<Objet> it = trié.iterator();
        while(it.hasNext() && sac.getPoidsActuel() < sac.getPoidsmax()){
            sac.add(it.next());
        }
    }

    private void triRapideRec(List<Objet> objets, int premier, int dernier){
        if(premier<dernier){
            int pivot = (dernier - premier) / 2 + premier;
            pivot = repartir(objets, premier, dernier,pivot);
            triRapideRec(objets, premier, pivot-1);
            triRapideRec(objets, pivot + 1, dernier);
        }
    }

    private int repartir(List<Objet> objets, int premier, int dernier, int pivot) {
        Collections.swap(objets, pivot, dernier);
        int tmp = premier;
        for(int j = premier; j < dernier; j++){
            if(objets.get(j).getRatio() >= objets.get(dernier).getRatio()){
                Collections.swap(objets,j,tmp);
                tmp++;
            }
        }
        Collections.swap(objets, dernier,tmp);
        return tmp;
    }

}
