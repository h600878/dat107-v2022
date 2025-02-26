package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "autogen_id")
public class Person {
	
	@Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autogenerert (SERIAL i postgreSQL)
	private Integer id;
	private String navn;
	
	public Integer getId() {
		return id;
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return String.format("Person: id=%d, navn=%s", id, navn);
	}
}
