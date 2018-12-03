package annotation.proxytest;

public class MainProxyValidate {
    public static void main(String[] args) {
        ValidateInterface val = ValidateMandatoryFactory.newInstance("d");
        System.out.println(val.mandatory());

    }
}
