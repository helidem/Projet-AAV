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



    }

}
