package no.hvl.dat107;

import java.util.List;

public class Main3CompleteCrud {

	private static Passord p;

	public static void main(String[] args) {

		p = new Passord();
		
		Main3CompleteCrud crud = new Main3CompleteCrud();
		
		System.out.println(crud.retrievePerson(1001));
		System.out.println(crud.retrievePerson(1002));
		System.out.println(crud.retrievePerson(1003));
		System.out.println("---");
		
		for (Person p : crud.retrieveAllePersoner2()) {
			System.out.println(p);
		}
		System.out.println("---");
		
		Person per = crud.retrievePerson(1001);
		System.out.println(per);
		
		crud.updatePerson(per.getId(), "X");
		per = crud.retrievePerson(1001);
		System.out.println(per);
		
		crud.updatePerson(per.getId(), "Per Viskeler");
		per = crud.retrievePerson(1001);
		System.out.println(per);
		System.out.println("---");
		
		Person mikke = new Person(1004, "Mikke Mus");
		crud.createPerson(mikke);
		mikke = crud.retrievePerson(1004);
		System.out.println(mikke);
		
		crud.deletePerson(mikke);
		mikke = crud.retrievePerson(1004);
		System.out.println(mikke);
		System.out.println("---");
		
	}
	
	private static Databasehjelper dbhjelper = new Databasehjelper();
	
	private EntityManagerFactory emf;
	
	public Main3CompleteCrud() {
		emf = Persistence
				.createEntityManagerFactory("personPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
	}
	
	public void createPerson(Person p) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		/* Eksempeldatabasen vår ser slik ut:
		 *  
		 * id		navn
		 * ----------------------
		 * 1001	'Per Viskeler'
		 * 1002	'Atle Patle'
		 * 1003	'Donald Duck'
		 */
		skrivUt("Utgangspunkt");
		
		//Create - Opprette ny(e) rad(er) i databasen
		dbhjelper.createPerson(new Person(1004, "Mikke"));
		skrivUt("Har lagt til Mikke");
		
		//Read - Hente ut data fra databasen
		//Hopper over denne
		
		//Update - Oppdatere data i databasen
		dbhjelper.updatePerson(1004, "Mikke Mus");
		skrivUt("Har endret navn til Mikke Mus");
		
		//Delete - Slette rad(er) fra databasen
		dbhjelper.deletePerson(new Person(1001, null));
		skrivUt("Har slettet person med id 1001");
		
		//Tilbakestille til utgangspunkt
		dbhjelper.createPerson(new Person(1001, "Per Viskeler"));
		dbhjelper.deletePerson(new Person(1004, null));
		skrivUt("Har tilbakestilt db");
	}

	private static void skrivUt(String tekst) {
		List<Person> personer = dbhjelper.retrieveAllePersoner();
		System.out.println("\n--- "+ tekst +" ---");
		personer.forEach(System.out::println);		
	}

}
