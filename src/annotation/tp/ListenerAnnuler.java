package annotation.tp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAnnuler implements ActionListener {
    private Fenetre fen;

    public ListenerAnnuler(Fenetre pFen) {
        fen = pFen;
    }

    @After(ResetForm.class)
    public void actionPerformed(ActionEvent e) {
        String message = "Annulation : " + "\n";
        message += "Texte 1 : " + fen.getTexte1().getText() + "\n ";
        message += "Texte 2 : " + fen.getTexte2().getText() + "\n ";
        JOptionPane.showMessageDialog(null, message, "actionPerformed", JOptionPane.WARNING_MESSAGE);
    }

    public Fenetre getFenetre() {
        return fen;
    }
}
