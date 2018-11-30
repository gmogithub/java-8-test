package annotation.tp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckForm<T extends JFrame> implements DoBefore {

    private T fen;
    public CheckForm(T pFen){
        fen = pFen;
    }

    @Override
    public void doBefore() {
        System.out.println("DO BEFORE ! ! ! !");
        Method[] methods = fen.getClass().getDeclaredMethods();

        for(Method m : methods){
            if(m.getReturnType().getName().equals(JTextField.class.getName())){
                try {
                    JTextField jtf = (JTextField)m.invoke(fen, null);
                    if(jtf.getText().trim().equals(""))
                        jtf.setText("Default value inside !");

                } catch (IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}