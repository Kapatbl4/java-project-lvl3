package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    private Predicate<Object> predicate;

    @Override
    public boolean isValid(Object object) {
        BaseSchema.setPredicate(this.predicate);
        return predicate == null || predicate.test(object);
    }

    public StringSchema required() {
        this.predicate = x -> x != null && String.valueOf(x).length() > 0;
        return this;
    }

    public StringSchema minLength(int length) {
        this.predicate = x -> String.valueOf(x).length() >= length;
        return this;
    }

    public StringSchema contains(String input) {
        this.predicate = x -> String.valueOf(x).contains(input);
        return this;
    }

}
