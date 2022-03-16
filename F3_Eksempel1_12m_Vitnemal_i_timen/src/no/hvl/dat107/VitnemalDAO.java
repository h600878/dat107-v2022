package no.hvl.dat107;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

    public /*TODO*/void hentKarakterForStudentIEmne(/*TODO*/) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	
        } finally {
            em.close();
        }
    }
    
    /* --------------------------------------------------------------------- */

    public /*TODO*/void registrerKarakterForStudent(/*TODO*/) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
        	tx.begin();
        	/*TODO*/
        	tx.commit();
        } finally {
            em.close();
        }
    }
   
}
















