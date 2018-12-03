package annotation.dynamique;

import java.lang.reflect.Proxy;

public class ReverseStringProxyFactory {
    public static StringInterface newInstance(String str) {
        return (StringInterface) Proxy.newProxyInstance(
                ProxyInvocationHandlerReverse.class.getClassLoader(),
                new Class[]{StringInterface.class},
                new ProxyInvocationHandlerReverse(new StringInterfaceImplementation(str))
        );
    }
}