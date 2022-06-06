package hexlet.code.shemas;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class StringSchema extends BaseSchema {
//    private String stage = "neutral";
//    private String contains = "";
//    private int minLength = 0;
//
//    public boolean isValid(Object object) {
//        switch (stage) {
//            case ("neutral") :
//                return true;
//            case ("required") :
//                return object != null && String.valueOf(object).length() > 0;
//            case ("minLength") :
//                return object != null && String.valueOf(object).length() >= minLength;
//            case ("contains") :
//                return object != null && String.valueOf(object).contains(contains);
//            default: throw new IllegalStateException();
//        }
//    }
//
//    public StringSchema required() {
//        this.stage = "required";
//        return this;
//    }
//
//
//    public StringSchema minLength(int length) {
//        this.stage = "minLength";
//        this.minLength = length;
//        return this;
//    }
//
//    public StringSchema contains(String input) {
//        this.stage = "contains";
//        this.contains = input;
//        return this;
//    }

    Predicate<Object> predicate;

    public boolean isValid(Object object) {
        BaseSchema.predicate = this.predicate;
        return super.isValid(object);
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
