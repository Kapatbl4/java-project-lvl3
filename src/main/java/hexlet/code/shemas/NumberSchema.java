package hexlet.code.shemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
//    private String stage = "neutral";
//    private int beginOfRange = 0;
//    private int endOfRange = 0;
//
//    public boolean isValid(Object object) {
//        switch (stage) {
//            case ("neutral") :
//                return true;
//            case ("required") :
//                return object instanceof Number;
//            case ("positive") :
//                return object == null || object instanceof Number && ((Number) object).intValue() > 0;
//            case ("range") :
//                return object instanceof Number && ((Number) object).intValue() >= beginOfRange
//                        && ((Number) object).intValue() <= endOfRange;
//            default: throw  new IllegalStateException();
//        }
//    }
//
//    public NumberSchema required() {
//        this.stage = "required";
//        return this;
//    }
//
//    public NumberSchema positive() {
//        this.stage = "positive";
//        return this;
//    }
//
//    public NumberSchema range(int begin, int end) {
//        this.beginOfRange = begin;
//        this.endOfRange = end;
//        this.stage = "range";
//        return this;
//    }

    Predicate<Object> predicate;

    public boolean isValid(Object object) {
        BaseSchema.predicate = this.predicate;
        return super.isValid(object);
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
