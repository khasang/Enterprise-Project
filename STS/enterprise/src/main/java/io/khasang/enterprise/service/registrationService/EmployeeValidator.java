package io.khasang.enterprise.service.registrationService;

import io.khasang.enterprise.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
    @Autowired
    private RegistrationService registrationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        String login = employee.getLogin();
        String password = employee.getPassword();
        Integer age = employee.getAge();

        /*------ LOGIN VALIDATOR -------*/
        if (!StringUtils.hasLength(login)) {
            errors.rejectValue("login", "required", "Login can't be empty.");
        }
//        if (!login.matches("^\\w{8,}$")) {
//            errors.rejectValue("login", "required", "Login can only consists of numbers, letters, underscore and hyphens characters.");
//        }
        if (login.length() < 3 || login.length() > 15) {
            errors.rejectValue("login", "required", "Login must be between 4 and 15 characters long.");
        }
        if (registrationService.isLoginExist(login)) {
            errors.rejectValue("login", "required", "Such login already in use");
        }

        /*------ PASSWORD VALIDATOR -------*/
        if (password.isEmpty()) {
            errors.rejectValue("password", "required", "Password can't be empty.");
        }
        if (!password.matches("^\\S+$")) {
            errors.rejectValue("password", "required", "Password can only consists of numbers, letters, underscore and hyphens characters.");
        }
        if (password.length() < 4 || password.length() > 15) {
            errors.rejectValue("password", "required", "Password must be between 4 and 15 characters long.");
        }
        /*------ PASSWORD VALIDATOR END-------*/

        if (employee.getFullName().isEmpty()) {
            errors.rejectValue("fullName", "required", "Contact person can't be empty.");
        }

        if(age == null || age < 18 || age > 100) {
            errors.rejectValue("age", "required", "Wrong age range");
        }

        if (employee.getAddress().isEmpty()) {
            errors.rejectValue("address", "required", "Address can't be empty.");
        }

        /*------ EMAIL VALIDATOR -------*/
        if (!employee.getEmail().matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")) {
            errors.rejectValue("email", "required", "Email is not valid");
        }
    }
}
