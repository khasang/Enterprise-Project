package io.khasang.enterprise.controller.client;

import io.khasang.enterprise.model.Client;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClientValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        String login = client.getLogin();

        if (!StringUtils.hasLength(login)) {
            errors.rejectValue("login", "required", "required");
        }

        if (client.getPassword().isEmpty()) {
            errors.rejectValue("password", "required", "required");
        }

        if (client.getEmail().length()<5) {
            errors.rejectValue("email", "required", "required");
        }
    }
}
