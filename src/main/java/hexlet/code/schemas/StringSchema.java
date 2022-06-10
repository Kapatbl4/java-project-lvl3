package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    private Predicate<Object> predicate;

    public StringSchema required() {
        this.predicate = x -> x != null && String.valueOf(x).length() > 0;
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema minLength(int length) {
        this.predicate = x -> String.valueOf(x).length() >= length;
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema contains(String input) {
        this.predicate = x -> String.valueOf(x).contains(input);
        this.addPredicate(predicate);
        return this;
    }

}
