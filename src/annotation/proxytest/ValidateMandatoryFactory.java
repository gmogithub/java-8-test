package annotation.proxytest;


import java.lang.reflect.Proxy;

public class ValidateMandatoryFactory {
    public static ValidateInterface newInstance(Object value) {
        return (ValidateInterface) Proxy.newProxyInstance(
                ProxyInvocationValidateMandatory.class.getClassLoader(),
                new Class[]{ValidateInterface.class},
                new ProxyInvocationValidateMandatory(new ValidateImpl(value)));
    }
}
