package annotation.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationValidateMandatory implements InvocationHandler {

    private ValidateImpl validate;

    public ProxyInvocationValidateMandatory(ValidateImpl validate) {
        this.validate = validate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        if (methodName.equals("mandatory")) {
            Object value = validate.getValue();
            boolean val = false;
            if (value != null) {
                if (!((String) value).isEmpty()) {
                    val = true;
                }
            }
            validate.setValidate(val);
        }
        return method.invoke(validate);
    }
}
