package no.hvl.dat107;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TidOgPengerDAO {

    private final EntityManagerFactory emf;

    public TidOgPengerDAO() {
        emf = Persistence.createEntityManagerFactory("datatyperPersistenceUnit", 
        		Map.of("javax.persistence.jdbc.password", new Passord().getPassord()));
    }

    public TidOgPenger hentTidOgPengerMedId(int id) {
        
        EntityManager em = emf.createEntityManager();

        TidOgPenger dt = null;
        try {
            dt = em.find(TidOgPenger.class, id);
        } finally {
            em.close();
        }
        return dt;
    }

    public int lagreIDatabasen(TidOgPenger ny) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(ny);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return ny.getId();
    }

}
