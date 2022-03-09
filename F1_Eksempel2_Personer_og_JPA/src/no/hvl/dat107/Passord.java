package no.hvl.dat107;

import javax.swing.*;

public class Passord {

    private final String passord;

    public Passord() {
        passord = JOptionPane.showInputDialog("passord:");
    }

    public String getPassord() {
        return passord;
    }
}
