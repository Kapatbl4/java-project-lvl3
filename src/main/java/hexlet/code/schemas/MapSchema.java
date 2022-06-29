package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        this.addPredicate(x -> x instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.addPredicate(x -> x instanceof Map && ((Map) x).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicate = x -> {
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
        return this;
    }
}
