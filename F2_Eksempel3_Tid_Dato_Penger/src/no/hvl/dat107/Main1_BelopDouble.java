package no.hvl.dat107;

public class Main1_BelopDouble {

    public static void main(String[] args) {

        float fireKronerOgTiOre = 4.20f;
        float tiOre = 0.20f;

        float fireKroner = fireKronerOgTiOre - tiOre;

        System.out.println(fireKronerOgTiOre);
        System.out.println(tiOre);
        
        System.out.println(fireKroner); //Skriver ut 3.999999... (forventet: 4.0)
    }

}
