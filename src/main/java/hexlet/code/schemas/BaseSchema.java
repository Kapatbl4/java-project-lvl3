package hexlet.code.schemas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> predicateList = new ArrayList<>();
    final public boolean isValid(Object object) {
        if (predicateList.size() == 0) {
            return true;
        }
        for (Predicate<Object> predicate : predicateList) {
            if (!predicate.test(object)) {
                return false;
            }
        }
        return true;
    }

    public final void addPredicate(Predicate<Object> p) {
        predicateList.add(p);
    }
}
