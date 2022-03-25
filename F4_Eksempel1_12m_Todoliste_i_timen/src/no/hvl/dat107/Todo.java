package no.hvl.dat107;

import javax.persistence.*;

@Entity
@Table(name = "Todo", schema = "forelesning4")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    
    private String tekst;

    @ManyToOne //Mange-til-en
    @JoinColumn(name = "ListeId", referencedColumnName = "ListeId") //ListeId refererer til ListeId
    private Todoliste liste;

    public Todo(String tekst) {
        this.tekst = tekst;
    }

    public Todo() {

    }

    public Todoliste getListe() {
        return liste;
    }

    public void setListe(Todoliste liste) {
        this.liste = liste;
    }

    public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
    public String toString() {
        return tekst;
    }
}
