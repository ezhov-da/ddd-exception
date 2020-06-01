package ru.ezhov.dddexception.user.domain;

import ru.ezhov.dddexception.user.domain.model.NewUser;
import ru.ezhov.dddexception.user.domain.model.NewUsername;
import ru.ezhov.dddexception.user.domain.model.UserGuid;
import ru.ezhov.dddexception.user.domain.model.UserGuidException;

public class UserRegisterService {
    private final UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(NewUsername newUsername) throws UserGuidException, UserRepositoryException {
        UserGuid userGuid = UserGuid.generate();
        NewUser newUser = NewUser.create(userGuid, newUsername);

        userRepository.save(newUser);
    }
}
