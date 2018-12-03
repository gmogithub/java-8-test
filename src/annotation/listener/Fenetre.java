package annotation.listener;

import java.awt.event.ActionListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    @Listener(classe = Action.class)
    private JButton bouton1 = new JButton("Bouton 1");
    @Listener(classe = Action2.class)
    private JButton bouton2 = new JButton("Bouton 2");

    private JPanel panneau = new JPanel();

    public Fenetre() {
        this.setSize(200, 200);
        panneau.add(bouton1);
        panneau.add(bouton2);

        this.getContentPane().add(panneau);
        processAnnotation();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void processAnnotation() {
        Class thisClass = this.getClass();
        Field[] listVariables = thisClass.getDeclaredFields();

        for (Field field : listVariables) {

            Listener listener = field.getAnnotation(Listener.class);
            if (listener != null) {
                // Ceci autorise la JVM à modifier le champ, même privé
                field.setAccessible(true);

                try {
                    // Nous allons créer notre instance d'écouteur dynamiquement
                    Class<? extends ActionListener> obj = listener.classe();

                    // et son constructeur
                    Constructor<? extends ActionListener> construct = obj
                            .getConstructor(new Class[] { JPanel.class });
                    // Nous avons maintenant notre objet implémentant ActionListener
                    Object db = construct.newInstance(panneau);
                    // Cette méthode permet de récupérer explicitement la variable
                    // sur laquelle nous travaillons
                    Object monBouton = field.get(this);

                    // On récupère la méthode souhaitée, addActionListener qui attend
                    // un paramètre du type que je ne vous présente plus : ActionListener
                    Method adder = monBouton.getClass().getMethod(  "addActionListener",
                            ActionListener.class);

                    // Nous invoquons cette méthode sur notre bouton
                    // En lui passant le paramètre attendu

                    adder.invoke(monBouton, db);
                    // Nous affichons un petit débuggage, pour la forme. ^^
                    System.out.println("Création dynamique d'un écouteur de type "
                            + db.getClass().getName());
                    System.out.println("Sur la variable " + field.getName() + "\n");

                } catch (IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    private @interface Listener {
        Class<? extends ActionListener> classe();
    }

    public static void main(String args[]) {
        new Fenetre();
    }
}