package annotation.tp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerValider implements ActionListener {
    private Fenetre fen;

    public ListenerValider(Fenetre pFen) {
        fen = pFen;
    }

    @Before(CheckForm.class)
    public void actionPerformed(ActionEvent e) {
        String message = "VALIDATION : " + "\n";
        message += "Texte 1 : " + fen.getTexte1().getText() + "\n ";
        message += "Texte 2 : " + fen.getTexte2().getText() + "\n ";
        JOptionPane.showMessageDialog(null, message, "actionPerformed", JOptionPane.INFORMATION_MESSAGE);
    }

    public Fenetre getFenetre() {
        return fen;
    }
}