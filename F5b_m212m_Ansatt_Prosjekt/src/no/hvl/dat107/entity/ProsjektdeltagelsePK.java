package no.hvl.dat107.entity;

import java.io.Serializable;

/**
 * Denne klassen inneholder primærnøkler
 */
@SuppressWarnings("unused") //Markerer klassen som ubrukt
public class ProsjektdeltagelsePK implements Serializable {
    
    private int ansatt;    //NB! Må hete det samme som i Prosjektdeltagelse
    private int prosjekt;  //NB! Må hete det samme som i Prosjektdeltagelse
    
    public ProsjektdeltagelsePK() {

    }
    
    public ProsjektdeltagelsePK(int ansattId, int prosjektId) {
        this.ansatt = ansattId;
        this.prosjekt = prosjektId;
    }
}
