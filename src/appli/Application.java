package appli;

import algos.Dynamique;
import algos.Gloutonne;
import algos.PSE;
import sac.SacADos;

import java.util.Date;

public class Application {

  public static void main(String[] args) {

    SacADos s = new SacADos(args[0], Integer.parseInt(args[1]));
    //SacADos s = new SacADos("out/artifacts/resoudre_sac_a_dos/giga liste.txt", 12);
    long begin = System.nanoTime();
    try {
      switch (args[2]) {
        case "glouton":
          s.resoudre(new Gloutonne(s));
          break;
        case "dynamique":
          s.resoudre(new Dynamique(s));
          break;
        case "pse":
          s.resoudre(new PSE(s));
          break;
        default:
          System.out.println("Algorithme inconnu ou non spécifié");
          break;
      }
    // s.resoudre(new Dynamique(s));

      long end = System.nanoTime();
      long duration = end - begin;
      System.out.println(s);
      System.out.printf("Temps d'execution : %f millisecondes\n", duration / 1_000_000.0);
    } catch (Exception e) {
      System.out.println("Arguments manquants");
    }
  }
}