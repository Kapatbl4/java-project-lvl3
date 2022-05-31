package hexlet.code;

import hexlet.code.shemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertTrue(schema.minLength(5).isValid("hexlet"));
        assertFalse(schema.isValid("USA"));
    }
}
