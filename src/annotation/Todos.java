package annotation;

public @interface Todos {
    Todo[] value() default {};

}
