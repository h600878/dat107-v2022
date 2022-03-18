package no.hvl.dat107;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(schema = "forelesning3")
@Entity
public class Karakter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int karNr; //PK

    private String emnekode;
    private LocalDate eksDato;
    private char bokstav;

    @ManyToOne //Mange-til-en
    @JoinColumn(name = "StudNr", referencedColumnName = "StudNr") //StudNr referer til StudNr (PK) i Vitnemål
    private Vitnemal vitnemal; //StudNr (FK)

    public Karakter() {

    }

    public Karakter(String emnekode, LocalDate eksDato, char bokstav) {
        this.emnekode = emnekode;
        this.eksDato = eksDato;
        this.bokstav = bokstav;
    }

    public int getKarNr() {
        return karNr;
    }

    public String getEmnekode() {
        return emnekode;
    }

    public LocalDate getEksDato() {
        return eksDato;
    }

    public char getBokstav() {
        return bokstav;
    }

    public Vitnemal getVitnemal() {
        return vitnemal;
    }

    public void setVitnemal(Vitnemal vitnemal) {
        this.vitnemal = vitnemal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karakter karakter = (Karakter) o;
        return karNr == karakter.karNr && bokstav == karakter.bokstav && Objects.equals(emnekode, karakter.emnekode) && Objects.equals(eksDato, karakter.eksDato) && Objects.equals(vitnemal, karakter.vitnemal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(karNr, emnekode, eksDato, bokstav, vitnemal);
    }

    @Override
    public String toString() {
        return "Karakter{" +
                "karNr=" + karNr +
                ", emnekode='" + emnekode + '\'' +
                ", eksamensdato=" + eksDato +
                ", bokstav='" + bokstav + '\'' +
                /*", vitnemal=" + vitnemal*/ +
                '}';
    }
}
