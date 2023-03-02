package no.hvl.dat107.entity;

import javax.persistence.*;

@Entity
@Table(schema = "forelesning5b")
public class Prosjektdeltagelse {

    private int timer;

    @EmbeddedId
    ProsjektdeltagelsePK id;

    @ManyToOne
    @MapsId("ansatt")
    @JoinColumn(name = "ansatt_Id")  //Slår sammen fra Ansatt
    private Ansatt ansatt;

    @ManyToOne
    @MapsId("prosjekt")
    @JoinColumn(name = "prosjekt_Id") //Slår sammen fra Prosjekt
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}

    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.timer = 0;

        // Oppdaterer Ansatt og Prosjekt
        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer);
    }

    @Override
    public String toString() {
        return "IKKE I BRUK";
//        return "PD(" + ansatt.getId() + ", " + prosjekt.getId() + "): " + timer + " timer";
    }


}






