package ru.ezhov.dddexception.user.domain.model;

import java.util.Objects;
import java.util.UUID;

public class UserGuid {
    private String value;

    private UserGuid(String value) throws UserGuidException {
        this.setValue(value);
    }

    private void setValue(String value) throws UserGuidException {
        if (value == null || "".equals(value)) {
            throw new UserGuidException("GUID пользователя обязателен для указания. Получен '" + value + "'");
        }
        this.value = value;
    }

    public static UserGuid generate() throws UserGuidException {
        return new UserGuid(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGuid userGuid = (UserGuid) o;
        return Objects.equals(value, userGuid.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
