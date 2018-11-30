package annotation.tp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ResetForm<T extends JFrame> implements DoAfter {

    private T fen;
    public ResetForm(T pFen){
        fen = pFen;
    }

    @Override
    public void doAfter() {
        System.out.println("DO AFTER ! ! ! !");
        Method[] methods = fen.getClass().getDeclaredMethods();
        for(Method m : methods){

            if(m.getReturnType().getName().equals(JTextField.class.getName())){
                try {
                    JTextField jtf = (JTextField)m.invoke(fen, null);
                    jtf.setText("");
                } catch (IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
