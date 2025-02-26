package no.hvl.dat107.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import no.hvl.dat107.LogIn;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;

import java.util.Map;

public class AnsattDAO {

    private EntityManagerFactory emf;

    public AnsattDAO() {
        LogIn logIn = new LogIn();
        emf = Persistence.createEntityManagerFactory("ansattPersistanceUnit",
                Map.of("javax.persistence.jdbc.url", logIn.getURL(),
                        "javax.persistence.jdbc.user", logIn.getBrukernavn(),
                        "javax.persistence.jdbc.password", logIn.getPassord()));
    }
    
    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        Ansatt ansatt = null;
        try {
            ansatt = em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
        return ansatt;
    }

    public void registrerProsjektdeltagelse(int ansattId, int prosjektId) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            Ansatt a = em.find(Ansatt.class, ansattId);
            Prosjekt p = em.find(Prosjekt.class, prosjektId);
            
            a.leggTilProsjekt(p);
            p.leggTilAnsatt(a);
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void slettProsjektdeltagelse(int ansattId, int prosjektId) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Ansatt a = em.find(Ansatt.class, ansattId);
            Prosjekt p = em.find(Prosjekt.class, prosjektId);
            
            a.fjernProsjekt(p);
            p.fjernAnsatt(a);
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }
}









