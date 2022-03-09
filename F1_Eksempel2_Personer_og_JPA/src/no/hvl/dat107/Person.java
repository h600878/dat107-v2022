package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity //Definerer klassen som en entitet
@Table(schema = "forelesning1") //Lagrer under schema "String"
@NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person p") //Definerer en spørring som henter all data
public class Person {
	
	@Id //Primærnøkkel
	private Integer id;
	private String navn;
	
	public Person() {

	}
	
	public Person(Integer id, String navn) {
		this.id = id;
		this.navn = navn;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * Det som skrives ut når vi utfører en spørring
	 * @return id og navn
	 */
	@Override
	public String toString() {
		return String.format("Person: id=%d, navn=%s", id, navn);
	}
}
