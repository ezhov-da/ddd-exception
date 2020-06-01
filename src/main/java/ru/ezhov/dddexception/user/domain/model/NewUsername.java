package ru.ezhov.dddexception.user.domain.model;

public class NewUsername {
    private String value;

    private NewUsername(String value) throws NewUsernameException {
        this.setValue(value);
    }

    public static NewUsername create(String value) throws NewUsernameException {
        return new NewUsername(value);
    }

    private void setValue(String value) throws NewUsernameException {
        if (value == null || "".equals(value)) {
            throw new NewUsernameException(
                    "Имя пользователя обязательно для указания",
                    "Имя пользователя обязательно для заполнения. Подано '" + value + "'"
            );
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
