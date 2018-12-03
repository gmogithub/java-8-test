package annotation.tp;

import java.awt.event.ActionListener;
import java.lang.reflect.Proxy;


public class ListenerProxyFactory {

    public static ActionListener newInstance(ActionListener listener, Fenetre fen){
        return (ActionListener) Proxy.newProxyInstance(
                listener.getClass().getClassLoader(),//Nous utilisons le loader par défaut
                new Class[]{ActionListener.class},   //Nous créons un proxy d'événement
                new ListenerHandler(listener, fen)   //Nous utilisons notre handler perso
        );
    }
}