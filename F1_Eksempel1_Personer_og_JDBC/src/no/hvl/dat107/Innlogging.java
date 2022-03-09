package no.hvl.dat107;

import javax.swing.*;

public class Innlogging {

    private final String DB_URL;
    private final String BRUKERNAVN;
    private final String PASSORD;


    public Innlogging() {
        BRUKERNAVN = JOptionPane.showInputDialog("Brukernavn");
        PASSORD = JOptionPane.showInputDialog("Passord");
        DB_URL = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/" + BRUKERNAVN;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getBRUKERNAVN() {
        return BRUKERNAVN;
    }

    public String getPASSORD() {
        return PASSORD;
    }

}
