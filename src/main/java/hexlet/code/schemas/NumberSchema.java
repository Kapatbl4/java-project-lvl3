package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    private Predicate<Object> predicate;
    private boolean required = false;

    public NumberSchema required() {
        this.predicate = x -> x instanceof Number;
        this.addPredicate(predicate);
        required = true;
        return this;
    }

    public NumberSchema positive() {
        this.predicate = x -> {
            if (required) {
                return x instanceof Number && (int) x > 0;
            } else if (x instanceof Number) {
                return (int) x > 0;
            }
            return true;
        };
        this.addPredicate(predicate);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.predicate = x -> (int) x >= begin && (int) x <= end;
        this.addPredicate(predicate);
        return this;
    }
}
