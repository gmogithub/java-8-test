package annotation.proxytest;

public class ValidateImpl implements ValidateInterface {

    private Object value = null;
    private boolean validate = true;

    public ValidateImpl(Object value) {
        this.value = value;
    }

    @Override
    public boolean mandatory() {
        return isValidate();
    }

    @Override
    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    @Override
    public boolean isValidate() {
        return this.validate;
    }

    public Object getValue() {
        return value;
    }
}
