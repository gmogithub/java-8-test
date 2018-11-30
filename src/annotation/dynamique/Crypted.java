package annotation.dynamique;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Crypted {
    public TypeCryptage type() default TypeCryptage.MD5;
}
