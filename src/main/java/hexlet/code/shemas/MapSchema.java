package hexlet.code.shemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private String stage = "neutral";
    private int size = 0;

    public boolean isValid(Object object) {
        switch (stage) {
            case ("neutral") :
                return true;
            case ("required") :
                return object instanceof Map;
            case ("sizeof") :
                return object instanceof Map && ((Map) object).size() == size;
            default: throw new IllegalStateException();
        }
    }

    public void required() {
        this.stage = "required";
    }

    public void sizeof(int size) {
        this.stage = "sizeof";
        this.size = size;
    }

    public void shape(Map map) {

    }
}
