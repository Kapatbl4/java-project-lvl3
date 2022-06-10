package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private Predicate<Object> predicate;

    public MapSchema required() {
        this.predicate = x -> x instanceof Map;
        this.addPredicate(predicate);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.predicate = x -> x instanceof Map && ((Map) x).size() == size;
        this.addPredicate(predicate);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        this.predicate = x -> {
            if (!(x instanceof Map)) {
                return false;
            }
            for (String key : schemas.keySet()) {
                if (!schemas.get(key).isValid(((Map) x).get(key))) {
                    return false;
                }
            }
            return true;
        };
        this.addPredicate(predicate);
    }
}
