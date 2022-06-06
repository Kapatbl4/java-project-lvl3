package hexlet.code.shemas;


import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapSchema extends BaseSchema {
//    private String stage = "neutral";
//    private int size = 0;
//
//    public boolean isValid(Object object) {
//        switch (stage) {
//            case ("neutral") :
//                return true;
//            case ("required") :
//                return object instanceof Map;
//            case ("sizeof") :
//                return object instanceof Map && ((Map) object).size() == size;
//            default: throw new IllegalStateException();
//        }
//    }
//
//    public void required() {
//        this.stage = "required";
//    }
//
//    public void sizeof(int size) {
//        this.stage = "sizeof";
//        this.size = size;
//    }
//
//    public void shape(Map map) {
//
//    }
    Predicate<Object> predicate;

    @Override
    public boolean isValid(Object object) {
        BaseSchema.predicate = this.predicate;
        return super.isValid(object);
    }

    public MapSchema required() {
        this.predicate = x -> x instanceof Map;
        return this;
    }

    public MapSchema sizeof(int size) {
        this.predicate = x -> x instanceof Map && ((Map) x).size() == size;
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        this.predicate = x -> {
            if (!(x instanceof Map)) return false;
            for (String key : schemas.keySet()) {
                if (!schemas.get(key).isValid(((Map<?, ?>) x).get(key))) {
                    return false;
            }
        }
            return true;
        };

    }
}
