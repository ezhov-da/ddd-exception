package ru.ezhov.dddexception.user.application;

import org.springframework.stereotype.Service;
import ru.ezhov.dddexception.user.domain.UserRegisterService;
import ru.ezhov.dddexception.user.domain.UserRepository;
import ru.ezhov.dddexception.user.domain.UserRepositoryException;
import ru.ezhov.dddexception.user.domain.model.NewUsername;
import ru.ezhov.dddexception.user.domain.model.NewUsernameException;
import ru.ezhov.dddexception.user.domain.model.UserGuidException;

@Service
public class UserRegisterApplication {
    private final UserRepository userRepository;

    public UserRegisterApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String username) throws NewUsernameException, UserRepositoryException, UserGuidException {
        UserRegisterService userRegisterService = new UserRegisterService(userRepository);
        NewUsername newUsername = NewUsername.create(username);
        userRegisterService.register(newUsername);
    }
}
