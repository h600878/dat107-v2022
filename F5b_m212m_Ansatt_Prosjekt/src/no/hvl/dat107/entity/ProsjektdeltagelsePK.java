package no.hvl.dat107.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Denne klassen inneholder primærnøkler
 */
@Embeddable
public class ProsjektdeltagelsePK implements Serializable {

    @Column(name = "ansatt_Id")
    private int ansatt;    //NB! Må hete det samme som i Prosjektdeltagelse
    @Column(name = "prosjekt_Id")
    private int prosjekt;  //NB! Må hete det samme som i Prosjektdeltagelse

    public ProsjektdeltagelsePK() {

    }

    public ProsjektdeltagelsePK(int ansatt, int prosjekt) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
    }

    public int getAnsatt() {
        return ansatt;
    }

    public void setAnsatt(int ansatt) {
        this.ansatt = ansatt;
    }

    public int getProsjekt() {
        return prosjekt;
    }

    public void setProsjekt(int prosjekt) {
        this.prosjekt = prosjekt;
    }
}
