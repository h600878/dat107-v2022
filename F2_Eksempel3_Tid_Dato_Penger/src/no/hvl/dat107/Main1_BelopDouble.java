package no.hvl.dat107;

public class Main1_BelopDouble {

    public static void main(String[] args) {

        double fireKronerOgTiOre = 4.10;
        double tiOre = 0.10;

        double fireKroner = fireKronerOgTiOre - tiOre;

        // Hva blir skrevet ut på skjermen?
        System.out.println(fireKronerOgTiOre);
        System.out.println(tiOre);
        
        System.out.println(fireKroner); //Skriver ut 3.999999... (forventet: 4.0)
    }

}
