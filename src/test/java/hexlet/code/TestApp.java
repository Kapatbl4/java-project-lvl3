package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestApp {
    @Test
    public void testStringSchema() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("")); // false

        assertTrue(schema.contains("what").isValid("what does the fox say")); // true
        assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false

        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void testMinLengthOfStringSchema() {
        Validator v = new Validator();
        StringSchema schema1 = v.string();
        final int length = 5;
        schema1.required();
        assertTrue(schema1.minLength(length).isValid("what does the fox say"));
        assertFalse(schema1.isValid("USA"));
    }

    @Test
    public void testNumberSchema() {
        Validator v = new Validator();

        // creating numbers for testing
        final int four = 4;
        final int five = 5;
        final int ten = 10;
        final int eleven = 11;

        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null)); // true

        schema.positive();
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null)); // false

        assertTrue(schema.isValid(ten)); // true
        assertFalse(schema.isValid("5")); // false

        assertTrue(schema.positive().isValid(ten)); // true
        assertFalse(schema.isValid(-ten)); // false

        schema.range(five, ten);

        assertTrue(schema.isValid(five)); // true
        assertTrue(schema.isValid(ten)); // true
        assertFalse(schema.isValid(four)); // false
        assertFalse(schema.isValid(eleven)); // false

        assertFalse(schema.isValid(null));
    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);

        assertFalse(schema.isValid(data));  // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }

    @Test
    public void testShapeMethodOfMapSchema() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        // creating numbers for testing
        final int hundred = 100;
        final int five = 5;
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", hundred);
        assertTrue(schema.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -five);
        assertFalse(schema.isValid(human4));

        assertFalse(schema.isValid("zhopa")); // false
    }
}
