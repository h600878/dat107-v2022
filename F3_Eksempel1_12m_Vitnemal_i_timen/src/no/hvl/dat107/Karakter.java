package no.hvl.dat107;

import javax.persistence.*;
import java.time.LocalDate;

@Table(schema = "forelesning3")
@Entity
public class Karakter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int karNr; //PK

    private String emnekode;
    private LocalDate eksDato;
    private String bokstav;

    @ManyToOne //Mange-til-en
    @JoinColumn(name = "StudNr", referencedColumnName = "StudNr") //StudNr referer til StudNr (PK) i Vitnemål
    private Vitnemal vitnemal; //StudNr (FK)

    public int getKarNr() {
        return karNr;
    }

    public String getEmnekode() {
        return emnekode;
    }

    public LocalDate getEksDato() {
        return eksDato;
    }

    public String getBokstav() {
        return bokstav;
    }

    public Vitnemal getVitnemal() {
        return vitnemal;
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
