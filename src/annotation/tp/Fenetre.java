package annotation.tp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame {

    private JButton valider = new JButton("Valider");
    private JButton annuler = new JButton("Annuler");

    private JLabel label1 = new JLabel("Texte 1");
    private JLabel label2 = new JLabel("Texte 2");

    private JTextField texte1 = new JTextField();
    private JTextField texte2 = new JTextField();

    private JPanel panneau1 = new JPanel();
    private JPanel panneau2 = new JPanel();
    private JPanel panneau3 = new JPanel();

    public Fenetre() {
        getContentPane().setLayout(new BorderLayout());
        texte1.setPreferredSize(new Dimension(100, 20));
        texte2.setPreferredSize(new Dimension(100, 20));

        panneau1.add(label1);
        panneau1.add(texte1);

        panneau2.add(label2);
        panneau2.add(texte2);

        //C'est à partir de ce moment que les choses changent
        panneau3.add(valider);
        //Nous créons un proxy de notre listener pour que ce dernier
        //utilise un gestionnaire d'invocation pour intercepter les événements
        ActionListener listener1 = ListenerProxyFactory.newInstance(
                new ListenerValider(this),
                this
        );
        valider.addActionListener(listener1);

        panneau3.add(annuler);
        //Nous créons un proxy de notre listener pour que ce dernier
        //utilise un gestionnaire d'invocation pour intercepter les événements
        ActionListener listener2 = ListenerProxyFactory.newInstance(
                new ListenerAnnuler(this),
                this
        );
        annuler.addActionListener(listener2);

        getContentPane().add(panneau1, BorderLayout.NORTH);
        getContentPane().add(panneau2, BorderLayout.CENTER);
        getContentPane().add(panneau3, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTexte1() {
        return texte1;
    }

    public JTextField getTexte2() {
        return texte2;
    }
}