package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        this.addPredicate(x -> x instanceof Number);
        return this;
    }

    public NumberSchema positive() {
        this.addPredicate(x -> x == null || x instanceof Number && (int) x > 0);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.addPredicate(x -> x instanceof Number && (int) x >= begin && (int) x <= end);
        return this;
    }
}
