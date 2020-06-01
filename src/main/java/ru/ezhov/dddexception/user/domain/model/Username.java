package ru.ezhov.dddexception.user.domain.model;

public class Username {
    private String value;

    private Username(String value) {
        this.setValue(value);
    }

    public static Username create(String value) {
        return new Username(value);
    }

    private void setValue(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
