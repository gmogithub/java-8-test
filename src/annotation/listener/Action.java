package annotation.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener{
   private JPanel pan;

   public Action(JPanel Ppan) {
      pan = Ppan;
   }

   public void actionPerformed(ActionEvent e) {
      pan.setBackground(Color.RED);
   }
}
