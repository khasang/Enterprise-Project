package io.khasang.enterprise.service.registretionService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {

    @Autowired
    RegistrationService registrationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        String login = client.getLogin();
        String password = client.getPassword();

        if (client.getContactPersonName().isEmpty()){
            errors.rejectValue("contactPersonName","required","Contact person can't be empty.");
        }
        if (client.getCompanyName().isEmpty()){
            errors.rejectValue("companyName","required", "Company name can't be empty.");
        }
        if (client.getCompanyDescription().isEmpty()){
            errors.rejectValue("companyDescription","required", "Company description can't be empty.");
        }
        if (!(client.getPhoneNumber().matches("\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})"))){
            errors.rejectValue("phoneNumber","required", "Phone number format: (111)-222-3333 | 1112223333 | 111-222-3333");
        }

        /*------ LOGIN VALIDATOR -------*/
        if (!StringUtils.hasLength(login)) {
            errors.rejectValue("login", "required", "Login can't be empty.");
        }
        if (!login.matches("^\\w{8,}$")){
            errors.rejectValue("login", "required", "Login can only consists of numbers, letters, underscore and hyphens characters.");
        }
        if (login.length()<4 || login.length()>15) {
            errors.rejectValue("login", "required", "Login must be between 4 and 15 characters long.");
        }
        if (registrationService.isLoginExist(login)){
            errors.rejectValue("login", "required", "Such login already in use");
        }

        /*------ PASSWORD VALIDATOR -------*/
        if (password.isEmpty()) {
            errors.rejectValue("password", "required", "Password can't be empty.");
        }
        if (!password.matches("^\\S+$")) {
            errors.rejectValue("password", "required", "Password can only consists of numbers, letters, underscore and hyphens characters.");
        }
        if (password.length()<4 || password.length()>15) {
            errors.rejectValue("password", "required", "Password must be between 4 and 15 characters long.");
        }

        /*------ EMAIL VALIDATOR -------*/
        if (!client.getEmail().matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")) {
            errors.rejectValue("email", "required", "Email is not valid");
        }
    }
}
