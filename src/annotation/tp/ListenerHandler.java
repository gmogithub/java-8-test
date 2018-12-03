package annotation.tp;

import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.swing.JFrame;


class ListenerHandler implements InvocationHandler {

    //On y stocke l'objet Fenetre pour y accéder
    private Fenetre fen;
    //Idem pour l'objet listener
    private ActionListener listener;

    public ListenerHandler(ActionListener pListener, Fenetre pFen){
        fen = pFen;
        listener = pListener;
    }

    //Méthode à redéfinir pour y coder le fonctionnement souhaité
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        //Nous récupérons la méthode actionPeformed
        //de notre listener, nous partons donc de cet objet
        Method customActionPerformed = listener .getClass()
                .getMethod(
                        method.getName(),
                        args[0].getClass()
                );

        //Pour les actions à faire avant, via notre annotation
        Before before = customActionPerformed.getAnnotation(Before.class);
        if(before != null){
            //On instancie un objet dynamiquement
            Class<? extends DoBefore> obj = before.value();
            //via son constructeur
            Constructor<? extends DoBefore> construct = obj.getConstructor(new Class[]{JFrame.class});
            //Nous avons maintenant notre objet implémentant DoBefore
            Object db = construct.newInstance(fen);
            //On récupère la méthode souhaitée
            Method m = obj.getMethod("doBefore", null);
            //et on l'invoque
            m.invoke(db, null);
        }

        System.out.println("Invocation de la méthode actionPerformed de notre proxy");
        //Ici se trouvait une petite subtilité...
        //Il fallait bien invoquer la méthode actionPerformed mais sur notre
        //implémentation perso, donc l'objet écouteur que nous avons fait
        Object o =  customActionPerformed.invoke(listener, args);

        // et les actions à faire après : idem que précédemment
        After after = customActionPerformed.getAnnotation(After.class);
        if(after != null){
            Class<? extends DoAfter> obj = after.value();
            Constructor<? extends DoAfter> construct = obj.getConstructor(new Class[]{JFrame.class});
            Object db = construct.newInstance(fen);
            Method m = obj.getMethod("doAfter", null);
            m.invoke(db, null);
        }

        return o;
    }
}
