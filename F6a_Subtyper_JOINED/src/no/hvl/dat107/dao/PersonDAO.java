package no.hvl.dat107.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.LogIn;
import no.hvl.dat107.entity.Person;

public class PersonDAO {

    private EntityManagerFactory emf;

    public PersonDAO() {
        LogIn logIn = new LogIn();
        emf = Persistence.createEntityManagerFactory("PersonProsjektPU",
                Map.of("javax.persistence.jdbc.url", logIn.getURL(),
                        "javax.persistence.jdbc.user", logIn.getBrukernavn(),
                        "javax.persistence.jdbc.password", logIn.getPassord()));
    }
    
    public Person finnPersonMedFNr(String fNr) {

        EntityManager em = emf.createEntityManager();

        Person person = null;
        try {
            person = em.find(Person.class, fNr); //Søker også i subklassene
        } finally {
            em.close();
        }
        return person;
    }

    public List<Person> finnAllePersoner() {
        
        EntityManager em = emf.createEntityManager();

        List<Person> p = null;
        try {
            TypedQuery<Person> query 
                    = em.createQuery("SELECT p FROM Person p", Person.class);
            p = query.getResultList();
            
        } finally {
            em.close();
        }
        return p;
    }

    public void lagrePerson(Person person) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            em.persist(person);
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
