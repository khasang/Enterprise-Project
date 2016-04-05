package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.registretionService.ClientValidator;
import io.khasang.enterprise.service.registretionService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController extends WebMvcConfigurerAdapter {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String ClientRegistration(@ModelAttribute("client") @Valid Client newClient, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration";
        } else {
            System.out.println(newClient.toString());
            registrationService.saveClientToDB(newClient);
            return "welcome";
        }
    }

    @InitBinder("client")
    public void initClientBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new ClientValidator());
    }
}
