package no.hvl.dat107;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.*;

public class VitnemalDAO {

    private EntityManagerFactory emf;

    public VitnemalDAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU",
		Map.of("javax.persistence.jdbc.password", new Passord().getPassord()));
    }
    
    /* --------------------------------------------------------------------- */

    public Vitnemal hentVitnemalForStudent(int studNr) {
        
        EntityManager em = emf.createEntityManager();
        try {

            return em.find(Vitnemal.class, studNr);

        }
        finally {
            em.close();
        }
    }

    /* --------------------------------------------------------------------- */

    public Karakter hentKarakterForStudentIEmne(int studNr, String emnekode) {
        
        EntityManager em = emf.createEntityManager();

        try {
            String queryString =
                    "SELECT k FROM Karakter k " +
                            "WHERE k.vitnemal.studNr = :studNr AND k.emnekode = :emnekode";

            //Oppretter spørring
            TypedQuery<Karakter> query = em.createQuery(queryString, Karakter.class);
            //Setter parametere inn i spørring
            query.setParameter("studNr", studNr);
            query.setParameter("emnekode", emnekode);

            return query.getSingleResult(); //Returnerer første resultat som stemmer med spørring

        }
        catch (NoResultException e) { //Hvis vi ikke finner noen
            return null;
        }
        finally {
            em.close();
        }
    }
    
    /* --------------------------------------------------------------------- */

    public Karakter registrerKarakterForStudent(
            int studNr, String emnekode, LocalDate eksDato, char bokstav) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
        	tx.begin(); //Starter transaksjon

            //Henter gammel karakter og vitnemål, om det fins
            Karakter k = hentKarakterForStudentIEmne(studNr, emnekode);
            Vitnemal v = hentVitnemalForStudent(studNr);
            em.merge(v);

            if (k != null) {
                //Fjerner den gamle karakteren
                v.fjernKarakter(k);
                em.remove(em.merge(k));

                em.flush(); //Fjerner karakteren fra databasen med engang før commit
            }
            //Oppretter den nye karakteren
            k = new Karakter(emnekode, eksDato, bokstav);
            k.setVitnemal(v);

            v.leggTilKarakter(k); //Legger til i vitnemålet
            em.persist(k); //Legger til i databasen

        	tx.commit(); //Commit transaksjon

            return k;
        } finally {
            em.close();
        }
    }
}



























