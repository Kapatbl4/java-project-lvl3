### Hexlet tests and linter status:
[![Actions Status](https://github.com/Kapatbl4/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/Kapatbl4/java-project-lvl3/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/de80a0a7358ac6c7485c/maintainability)](https://codeclimate.com/github/Kapatbl4/java-project-lvl3/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/de80a0a7358ac6c7485c/test_coverage)](https://codeclimate.com/github/Kapatbl4/java-project-lvl3/test_coverage)


### Data validator is a library for validating strings, numbers and maps.

#### String validate methods are:
* required() — any not empty string;
* minLength(int length) — string length is equal or more than input;
* contains(String input) — string contains input string.

```java
Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid("");; // false

schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
```

#### Number validate methods are:
* required() — any number;
* positive() — number is positive;
* range(int begin, int end) — number is between begin and end (included).
```java
Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false

schema.positive().isValid(10); // true
schema.isValid(-10); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

#### Map validate methods are:
* required() — any Map;
* sizeof(int size) — size of map is equal to input;
* shape(Map<String, BaseSchema> schemas) — define the keys of the object and the schemas for said keys.

```java
Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

```java
Validator v = new Validator();

MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
```
