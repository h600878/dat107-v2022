package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo", schema = "forelesning4")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    
    private String tekst;
    
    public Todo(String tekst) {
        this.tekst = tekst;
    }

    public Todo() {

    }

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

    @Override
    public String toString() {
        return tekst;
    }
}
