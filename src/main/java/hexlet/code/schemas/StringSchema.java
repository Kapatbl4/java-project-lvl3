package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        this.addPredicate(x -> x != null && String.valueOf(x).length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        this.addPredicate(x -> String.valueOf(x).length() >= length);
        return this;
    }

    public StringSchema contains(String input) {
        this.addPredicate(x -> String.valueOf(x).contains(input));
        return this;
    }

}
