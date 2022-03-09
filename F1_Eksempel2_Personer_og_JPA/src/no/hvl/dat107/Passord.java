package no.hvl.dat107;

import javax.swing.*;

public class Passord {

    private final String passord;

    public Passord() {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf,
                "Passord:", JOptionPane.OK_CANCEL_OPTION);

        if (okCxl == JOptionPane.OK_OPTION) {
            passord = new String(pf.getPassword());
        }
        else {
            passord = "";
        }
    }

    public String getPassord() {
        return passord;
    }
}
