package algos;

import sac.Objet;
import sac.SacADos;

public class PSE extends Gloutonne {

    // solution possible
    private float borneMin;

    private ABR meilleurSol;

    private float poidsMax;

    public PSE(SacADos sac) {
        super(sac);
    }

    /**
     * Methode qui résoud le problème avec la méthode dynamique
     */
    public void resoudre() {
        // On initialise les bornes min et max à 0
        float borneSup = borneMin = 0;

        for (Objet o: super.objets) {
            borneSup += o.getPrix();
        }

        // on lance la methode gloutonne pour avoir un resultat de reference et une solution "réaliste" (heuristique)
        super.resoudre();
        // mise a jour de la borneMin
        for (Objet o: sac)
            this.borneMin += o.getPrix();

        // Si la methode gloutonne a réussi à trouver la solution, on ne fait pas la methode pse
        if (borneSup != sac.getPrixTotal()) {

            // On crée la racine de l'ABR
            ABR root = new ABR();

            // Initialisation
            this.meilleurSol = root;

            // resolution recursive
            resoudreRec(0, root, borneSup);

            // maintenant on vide le sac car il contient les objets issus de la methode gloutonne
            sac.viderSac();

            // on mets les objets dans le sac a partir du noeud contenant la meilleure combinaison d'objets
            ajoutRec(this.meilleurSol);

            // pistes d'améliorations : stocker une arraylist d'objets dans chaque noeud pour eviter d'utiliser la methode ajoutRec
            // ajouter une classe noeud pour faciliter la manipulation du ABR
        }
    }

    /**
     * Resous recursivement le probleme
     * @param indexObj
     * @param borneSup
     */
    public void resoudreRec(int indexObj, ABR node, float borneSup) {
        // Ajout de l'objet suivant de la liste dans le fils gauche
        node.setFilsGauche(objets.get(indexObj), indexObj);

        // Ajout du fils droit sans l'ajout de l'objet
        node.setFilsDroit();

    // On regadre si on a trouvé une meilleure solution lors de la creation du fils gauche
    if (node.getFilsGauche().getPrix() >= this.borneMin
        && node.getFilsGauche().getPoids() <= sac.getPoidsmax() /* pas obligatoire */) {

            // On indique de quel noeud il s'agit
            this.meilleurSol = node.getFilsGauche();

            // Ensuite on update la borne min car il peut etre une solution possible
            this.borneMin = this.meilleurSol.getPrix();
        }

    // On regarde s'il reste encore des objets a mettre dans le sac
    // et que le poids max n'est pas dépassé : dans ce cas on "coupe" l'arbre
    if (indexObj < objets.size() - 1 && node.getPoids() < sac.getPoidsmax()) {
            // On rappelle la fonction recursive avec l'objet suivant
            resoudreRec(indexObj + 1, node.getFilsGauche(), borneSup);

        /*
        si à partir d’un nœud, nous savons que nous ne pourrons pas faire plus de 10 (borne supérieure calculée)
        et que la borne inférieure existante est à 11 (on a déjà une solution de valeur 11), alors les solutions
        descendantes de ce nœud ne sont pas intéressantes.
        */

        /*
        La somme de toutes les
        valeurs de tous les objets déjà mis dans le sac plus la somme des valeurs des objets
        restants dont on ne sait pas encore s’ils seront dans le sac.
        */

        // cette variable correspond au prix de l'ensemble des objets dans la liste moins celui de l'objet traité en cours
        // 
        float test = borneSup - objets.get(indexObj).getPrix();

            if (test >= borneMin) {
                // une solution est alors possible
                // on appelle cette methode recursivement
                resoudreRec(indexObj + 1, node.getFilsDroit(), test);
            }
            // sinon on coupe
            // et on n'a pas besoin de continuer car "les solutions descendantes de ce nœud ne sont pas intéressantes."
        }
    }

    private void ajoutRec(ABR meilleurSol){
        int indiceObj;

        // Tester si l'indice ne vaut pas -1
        if(meilleurSol.getIndiceObjet() != -1){
            sac.add(objets.get(meilleurSol.getIndiceObjet()));
        }

        // ensuite on continue jusqu'a la racine
        if(!meilleurSol.isRoot()){
            ajoutRec(meilleurSol.getParent());
        }

    }
}