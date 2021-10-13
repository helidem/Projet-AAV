package appli;

import sac.SacADos;

public class Application {

    public static void main(String[] args) {
        SacADos s = new SacADos("src/appli/items.txt",8);
        s.resoudre();
        System.out.println(s);
    }
}