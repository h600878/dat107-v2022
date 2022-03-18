package no.hvl.dat107;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "forelesning3")
public class Vitnemal {

    @Id
    private int studNr;
    private LocalDate studieStart, studieSlutt;

    //Gjør karakterer tilgjengelig i denne entiteten
    @OneToMany(mappedBy = "Vitnemal", fetch = FetchType.EAGER) //Henter alltid alle karakterene
    private List<Karakter> karakterer; //Gjør at entiteten også inneholder karakterene

    public Vitnemal() {

    }

    public void leggTilKarakter(Karakter k) {
        karakterer.add(k);
    }

    public void fjernKarakter(Karakter k) {
        karakterer.remove(k);
    }

    public int getStudNr() {
        return studNr;
    }

    public LocalDate getStudieStart() {
        return studieStart;
    }

    public LocalDate getStudieSlutt() {
        return studieSlutt;
    }

    @Override
    public String toString() {
        return "Vitnemal{" +
                "studNr=" + studNr +
                ", studieStart=" + studieStart +
                ", studieSlutt=" + studieSlutt +
                ", karakterer=" + karakterer +
                '}';
    }
}
