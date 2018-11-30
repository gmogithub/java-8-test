package annotation.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Action2 implements ActionListener {
    private JPanel pan;

    public Action2(JPanel Ppan) {
        pan = Ppan;
    }

    public void actionPerformed(ActionEvent e) {
        pan.setBackground(Color.BLUE);
    }
}
