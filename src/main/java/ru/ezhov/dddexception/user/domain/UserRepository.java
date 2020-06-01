package ru.ezhov.dddexception.user.domain;

import ru.ezhov.dddexception.user.domain.model.NewUser;
import ru.ezhov.dddexception.user.domain.model.User;
import ru.ezhov.dddexception.user.domain.model.UserGuid;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(NewUser newUser) throws UserRepositoryException;

    List<User> all() throws UserRepositoryException;

    Optional<User> by(UserGuid userGuid) throws UserRepositoryException;
}
