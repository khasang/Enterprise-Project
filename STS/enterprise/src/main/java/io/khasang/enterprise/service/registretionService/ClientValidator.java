package io.khasang.enterprise.service.registretionService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class ClientValidator implements Validator {

    @Autowired
    ClientDao clientDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        String login = client.getLogin();
        String password = client.getPassword();

        /*------ LOGIN VALIDATOR -------*/
        if (!StringUtils.hasLength(login)) {
            errors.rejectValue("login", "required", "Login can't be empty.");
        }
        if (!client.getLogin().matches("^\\w{8,}$")){
            errors.rejectValue("login", "required", "Login can only consists of numbers, letters and the underscore characters.  ");
        }
        if (login.length()<6 || login.length()>15) {
            errors.rejectValue("login", "required", "Login must be between 8 and 15 characters long.");
        }
        if (!(clientDao.findByLogin(login) == null)){
            errors.rejectValue("login", "required", "Such login already in use");
        }

        /*------ PASSWORD VALIDATOR -------*/
        if (client.getPassword().isEmpty()) {
            errors.rejectValue("password", "required", "Password can't be empty.");
        }
        if (!client.getPassword().matches("^\\S+$")) {
            errors.rejectValue("password", "required", "Password can't contains space characters.");
        }
        if (password.length()<4 || password.length()>15) {
            errors.rejectValue("password", "required", "Password must be between 8 and 15 characters long.");
        }

        /*------ EMAIL VALIDATOR -------*/
        if (!client.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            errors.rejectValue("email", "required", "Email is not correct");
        }
    }
}
