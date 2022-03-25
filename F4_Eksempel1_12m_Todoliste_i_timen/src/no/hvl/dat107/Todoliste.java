package no.hvl.dat107;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Todoliste", schema = "forelesning4")
public class Todoliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listeId;
	
	private String navn;

	//Allerede definert i Todo, variabel liste,
	// FetchType.EAGER gjør at alle elementer i listen blir skrevet ut
	@OneToMany(mappedBy = "liste", fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}, //...
			orphanRemoval = true) //...
	@OrderBy("tekst asc") //Sorter etter stigende
	private List<Todo> todos = new ArrayList<>();

	public Todoliste() {

	}

	public Todoliste(String navn) {
		this.navn = navn;
	}

	public void leggTil(Todo todo) {
		todos.add(todo);
		todo.setListe(this); //Lager en kobling til liste i Todo
	}

	public void fjern(Todo todo) {
		todos.remove(todo);
		todo.setListe(null);
	}

	public int getListeId() {
		return listeId;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "Todoliste [listeId=" + listeId + ", navn=" + navn + ", todos=" + todos + "]";
	}

}
