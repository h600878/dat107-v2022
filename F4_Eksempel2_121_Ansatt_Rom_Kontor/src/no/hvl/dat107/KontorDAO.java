package no.hvl.dat107;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class KontorDAO {

    private EntityManagerFactory emf;

    public KontorDAO() {
        LogIn logIn = new LogIn();
        emf = Persistence.createEntityManagerFactory("ansattPersistanceUnit",
                Map.of("javax.persistence.jdbc.url", logIn.getURL(),
                        "javax.persistence.jdbc.user", logIn.getBrukernavn(),
                        "javax.persistence.jdbc.password", logIn.getPassord()));
    }

    public Rom finnRomNr(String romNr) {
        EntityManager em = emf.createEntityManager();
        Rom rom;
        try {
            rom = em.find(Rom.class, romNr);
        } finally {
            em.close();
        }
        return rom;
    }
    
    public Ansatt finnAnsattNr(int ansNr) {
        EntityManager em = emf.createEntityManager();
        Ansatt ansatt;
        try {
            ansatt = em.find(Ansatt.class, ansNr);
        } finally {
            em.close();
        }
        return ansatt;
        
    }
    
    public List<Rom> finnAlleRom() {//JPQL ?

        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Rom> q = em.createQuery("select r from Rom r", Rom.class);

            return q.getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Ansatt> finnAlleAnsatte() {
        return null; //JPQL
    }

}
