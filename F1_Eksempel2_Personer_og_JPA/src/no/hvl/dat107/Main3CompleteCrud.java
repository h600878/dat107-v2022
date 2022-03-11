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
	
	private final EntityManagerFactory emf;
	
	public Main3CompleteCrud() {
		emf = Persistence
				.createEntityManagerFactory("personPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
	}
	
	public void createPerson(Person p) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin(); //Starter en ny transaksjon
			em.persist(p); //Oppretter en ny rad i databasen
			tx.commit(); //Committer transaksjonen
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Henter ut en Person fra databasen med gitt id
	 * @param id Primærnøkkel
	 * @return Person object eller null, hvis ikke funnet
	 */
	public Person retrievePerson(int id) {

		EntityManager em = emf.createEntityManager();

		Person p;
		try {
			p = em.find(Person.class, id); //Finner en Person ved gitt id
		} finally {
			em.close();
		}
		return p;
	}

	/**
	 * Henter ut alle personer i databasen
	 * @return En liste av Personer
	 */
	public List<Person> retrieveAllePersoner() {

		EntityManager em = emf.createEntityManager();

		List<Person> personer;
		try {
			TypedQuery<Person> query = em.createQuery(
			        "SELECT p FROM Person p", Person.class); //Oppretter en spørring
			personer = query.getResultList(); //Lagrer resultatet i en spørring
		} finally {
			em.close();
		}
		return personer;
	}

	public List<Person> retrieveAllePersoner2() {
		/* Tester ut NamedQuery */

		EntityManager em = emf.createEntityManager();

		List<Person> personer;
		try {
			//Sjekker om det fins en spørring ved navn "hentAllePersoner" og lager en spørring
			TypedQuery<Person> query = em.createNamedQuery("hentAllePersoner", Person.class);
			personer = query.getResultList();
		} finally {
			em.close();
		}
		return personer;
	}

	/**
	 * Oppdaterer en gitt id med nytt navn
	 * @param id
	 * @param nyttNavn
	 */
	public void updatePerson(int id, String nyttNavn) {

		EntityManager em = emf.createEntityManager();

		try {
			Person p = em.find(Person.class, id); //Finner en Person ved gitt id
			p.setNavn(nyttNavn); //Setter nytt navn
		
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void deletePerson(Person p) {
		
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			em.remove(em.find(Person.class, p.getId()));
			
			em.getTransaction().commit();
		
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
