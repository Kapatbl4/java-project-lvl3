package hexlet.code.shemas;


import java.util.function.Predicate;

public abstract class BaseSchema {
    private static Predicate<Object> predicate;
    public abstract boolean isValid(Object object);

    public static void setPredicate(Predicate<Object> p) {
        BaseSchema.predicate = p;
    }

}
