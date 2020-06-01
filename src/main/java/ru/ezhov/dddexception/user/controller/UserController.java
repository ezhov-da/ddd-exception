package ru.ezhov.dddexception.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ezhov.dddexception.user.application.UserRegisterApplication;
import ru.ezhov.dddexception.user.domain.UserRepositoryException;
import ru.ezhov.dddexception.user.domain.model.NewUsernameException;
import ru.ezhov.dddexception.user.domain.model.UserGuidException;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserRegisterApplication userRegisterApplication;

    public UserController(UserRegisterApplication userRegisterApplication) {
        this.userRegisterApplication = userRegisterApplication;
    }

    @PostMapping(path = "register")
    public ResponseEntity<String> register(@RequestParam String username) {
        ResponseEntity<String> responseEntity;

        try {
            userRegisterApplication.register(username);
            responseEntity = ResponseEntity.ok("registered");
        } catch (NewUsernameException e) {
            LOG.warn("Ошибка создания нового пользователя. username='" + username + "'", e);

            responseEntity = ResponseEntity.status(500).body(e.businessMessage());
        } catch (UserRepositoryException e) {
            LOG.warn("Ошибка работы с хранилищем пользователей. username='" + username + "'", e);

            responseEntity = ResponseEntity.status(500).body(e.businessMessage());
        } catch (UserGuidException e) {
            LOG.warn("Ошибка работы с GUID пользователя. username='" + username + "'", e);

            responseEntity = ResponseEntity.status(500).body("Ошибка GUID. Обратитесь к разработчикам");
        }

        return responseEntity;
    }
}
