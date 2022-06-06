package hexlet.code.shemas;


import java.util.function.Predicate;

public class BaseSchema {
    static Predicate<Object> predicate;
    public boolean isValid(Object object) {
        return predicate == null || predicate.test(object);
    }
}
