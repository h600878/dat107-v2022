package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning3")
public class Vitnemal {
	
	@Id private int studNr;
	private LocalDate studiestart;
	private LocalDate studieslutt;
	
	@OneToMany(mappedBy = "vitnemal", fetch = FetchType.EAGER)
	List<Karakter> karakterer;

	@Override
	public String toString() {
		
		String karString = "";
		for (Karakter k : karakterer) {
			karString += "\n\t" + k;
		}
		return "Vitnemal for studNr=" + studNr + ", studiestart=" + studiestart 
				+ ", studieslutt=" + studieslutt + ":" + karString;
	}
}
