package algos;

import sac.Objet;
import sac.SacADos;

public class PSE extends Gloutonne{

    // solution possible
    private float borneMin;

    private ABR meilleurSol;

    private float poidsMax;

    public PSE(SacADos sac){
        super(sac);
    }

    public void resoudre(){
        float borneSup = borneMin = 0;

        for(Objet o : super.objets){
            borneSup += o.getPrix();
        }

        super.resoudre();
        for(Objet o : sac)
            this.borneMin += o.getPrix();

    }


    /**
     * Résous la méthode pse recursivement
     * @param indexObj l'index de l'objet à inserer depuis la liste des objets du .txt
     * @param borneMin la borne minimal correspondante à la solution gloutonne
     * @return le prix total du sac
     */
    public float resoudreRec(int indexObj, float borneMin){
        // init
        sac.viderSac();
        float min = sac.getPrixTotal();

        // ajouter un objet dans le sac
        sac.add(objets.get(indexObj));
        min = min + objets.get(indexObj).getPrix();

        // tester si le prix total est plus élevé que la borneMin qui correspond à une solution via la methode gloutonne
        if(min > borneMin){
            borneMin = min;
        }

        // voir s'il reste des objets à mettre dans le fils droit
        if(indexObj < objets.size()){
            // re appeler cette methode avec un index + 1
            float filsDroit = resoudreRec(indexObj+1,borneMin);
            // si le fils droit a une solution meilleure :
            if(filsDroit > borneMin){
                borneMin = filsDroit;
            }
        }

        // retirer l'objet du sac
        sac.remove(objets.get(indexObj));

        // voir s'il reste des objets à mettre dans le fils gauche
        if(indexObj < objets.size()){
            // re appeler cette methode avec un index + 1
            float filsGauche = resoudreRec(indexObj+1,borneMin);
            // si le fils gauche a une solution meilleure :
            if(filsGauche > borneMin){
                borneMin = filsGauche;
            }
        }

        // retourner la borne min
        return borneMin;

    }

}
