package appli;

import sac.SacADos;

public class Application {

    public static void main(String[] args) {
        SacADos s = new SacADos("src/appli/itemsEval.txt",12);
        long begin = System.nanoTime();
        s.resoudre();
        long end = System.nanoTime();
        long duration = end - begin;
        System.out.println(s);
        System.out.printf( "Temps d'execution : %f millisecondes\n", duration / 1_000_000.0 );
    }
}