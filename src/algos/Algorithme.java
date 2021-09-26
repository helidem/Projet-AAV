package algos;

import sac.Objet;
import sac.SacADos;

import java.util.ArrayList;

public abstract class Algorithme {

    protected SacADos sac;
    ArrayList<Objet> objets;

    public Algorithme(SacADos sac) {
        this.sac = sac;
        this.objets = sac.getObjetsPossibles();
    }

    public abstract void resoudre();
}
