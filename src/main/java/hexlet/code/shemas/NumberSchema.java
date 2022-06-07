package hexlet.code.shemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    private Predicate<Object> predicate;

    @Override
    public boolean isValid(Object object) {
        BaseSchema.setPredicate(this.predicate);
        return predicate == null || predicate.test(object);
    }

    public NumberSchema required() {
        this.predicate = x -> x instanceof Number;
        return this;
    }

    public NumberSchema positive() {
        this.predicate = x -> x == null || (int) x > 0;
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.predicate = x -> (int) x >= begin && (int) x <= end;
        return this;
    }
}
