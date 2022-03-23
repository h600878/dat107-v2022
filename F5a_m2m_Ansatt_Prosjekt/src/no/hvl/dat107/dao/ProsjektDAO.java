package no.hvl.dat107.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.dat107.LogIn;
import no.hvl.dat107.entity.Prosjekt;

import java.util.Map;

public class ProsjektDAO {

    private EntityManagerFactory emf;

    public ProsjektDAO() {
        LogIn logIn = new LogIn();
        emf = Persistence.createEntityManagerFactory("ansattPersistanceUnit",
                Map.of("javax.persistence.jdbc.url", logIn.getURL(),
                        "javax.persistence.jdbc.user", logIn.getBrukernavn(),
                        "javax.persistence.jdbc.password", logIn.getPassord()));
    }

    public Prosjekt finnProsjektMedId(int id) {

        EntityManager em = emf.createEntityManager();

        Prosjekt prosjekt = null;
        try {
            prosjekt = em.find(Prosjekt.class, id);
        } finally {
            em.close();
        }
        return prosjekt;
    }
}
