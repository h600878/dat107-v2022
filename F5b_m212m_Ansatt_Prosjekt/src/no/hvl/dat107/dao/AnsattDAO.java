package no.hvl.dat107.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;
import no.hvl.dat107.entity.Prosjektdeltagelse;
import no.hvl.dat107.entity.ProsjektdeltagelsePK;

public class AnsattDAO {

    private final EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
    }

    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        Ansatt ansatt;
        try {
            ansatt = em.find(Ansatt.class, id);
        }
        finally {
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

            //Legger til i ProsjektDeltakelse
            Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p);

//            Flyttet til konstruktør
//            a.leggTilProsjektdeltagelse(pd);
//            p.leggTilProsjektdeltagelse(pd);

            em.persist(pd); //Pusher til databasen

            tx.commit();
        }
        catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }
        finally {
            em.close();
        }

    }

    public void slettProsjektdeltagelse(int ansattId, int prosjektId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            ProsjektdeltagelsePK pk = new ProsjektdeltagelsePK(ansattId, prosjektId);

            Prosjektdeltagelse pd = em.find(Prosjektdeltagelse.class, pk);

            Ansatt a = em.find(Ansatt.class, ansattId);
            Prosjekt p = em.find(Prosjekt.class, prosjektId);

            a.fjernProsjektdeltagelse(pd);
            p.fjernProsjektdeltagelse(pd);

            em.remove(pd);

            tx.commit();
        }
        catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }
        finally {
            em.close();
        }
    }

}





