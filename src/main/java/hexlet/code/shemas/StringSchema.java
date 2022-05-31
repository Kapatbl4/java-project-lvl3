package hexlet.code.shemas;

public class StringSchema implements Schema {
    private String stage = "neutral";
    private String contains = "";
    private int minLength = 0;

    public boolean isValid(String input) {
        switch (stage) {
            case ("neutral") :
                return true;
            case ("required") :
                return input != null && input.length() > 0;
            case ("minLength") :
                return input != null && input.length() >= minLength;
            case ("contains") :
                return input != null && input.contains(contains);
            default: throw new IllegalStateException();
        }
    }

    public void required() {
        this.stage = "required";
    }

    public StringSchema minLength(int length) {
        this.stage = "minLength";
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String input) {
        this.stage = "contains";
        this.contains = input;
        return this;
    }

}
