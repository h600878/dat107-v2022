package no.hvl.dat107;

import javax.swing.*;

public class LogIn {

    private final String passord, brukernavn;

    public LogIn() {

        JLabel jUserName = new JLabel("User Name");
        JTextField userName = new JTextField();

        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField();

        Object[] ob = {jUserName, userName, jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Logg inn:", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            brukernavn = userName.getText();
            passord = password.getText();
        }
        else {
            brukernavn = "";
            passord = "";
        }

    }

    public String getURL() {
        return "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/" + brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public String getBrukernavn() {
        return brukernavn;
    }
}
