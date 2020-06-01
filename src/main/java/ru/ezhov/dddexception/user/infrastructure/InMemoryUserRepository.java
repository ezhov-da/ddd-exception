package ru.ezhov.dddexception.user.infrastructure;

import org.springframework.stereotype.Repository;
import ru.ezhov.dddexception.user.domain.UserRepository;
import ru.ezhov.dddexception.user.domain.UserRepositoryException;
import ru.ezhov.dddexception.user.domain.model.NewUser;
import ru.ezhov.dddexception.user.domain.model.User;
import ru.ezhov.dddexception.user.domain.model.UserGuid;
import ru.ezhov.dddexception.user.domain.model.Username;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<UserGuid, User> userMap = new ConcurrentHashMap<>();

    @Override
    public void save(NewUser newUser) throws UserRepositoryException {
        userMap.put(
                newUser.guid(),
                User.create(
                        Username.create(newUser.username().value()),
                        newUser.guid()
                )
        );
    }

    @Override
    public List<User> all() throws UserRepositoryException {
        return Collections.unmodifiableList(new ArrayList<>(userMap.values()));
    }

    @Override
    public Optional<User> by(UserGuid userGuid) throws UserRepositoryException {
        return Optional.ofNullable(userMap.get(userGuid));
    }
}
