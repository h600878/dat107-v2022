package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class TodolisteDAO {

    private EntityManagerFactory emf;

    public TodolisteDAO() {
        LogIn logIn = new LogIn();
        emf = Persistence.createEntityManagerFactory("kjell",
                Map.of("javax.persistence.jdbc.url", logIn.getURL(),
                        "javax.persistence.jdbc.user", logIn.getBrukernavn(),
                        "javax.persistence.jdbc.password", logIn.getPassord()));
    }

    public List<Todo> hentListe(int listeId) {
        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
        	
        } finally {
            em.close();
        }
        return null;
    }

    public void lagreListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            em.persist(liste);
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void slettListe(Todoliste list) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            /*TODO*/
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public /*TODO*/void oppdaterListe(Todoliste liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            
            /*TODO*/
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public /*TODO*/void hentListeMedNavn(/*TODO*/) {

        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
            
        } catch (NoResultException e) {
            // catcher denne og returnerer null :)
        } finally {
            em.close();
        }
    }

    public /*TODO*/void hentTodosIListe(/*TODO*/) {

        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
        	
        } finally {
            em.close();
        }
    }

    public List<Todo> finnListe(int listeId) {
        return null;
    }

    public boolean finnListePaaNavn(String gøy_husarbeid) {
        return false;
    }

    public boolean finnTodosIListe(int listeId) {
        return false;
    }
}
