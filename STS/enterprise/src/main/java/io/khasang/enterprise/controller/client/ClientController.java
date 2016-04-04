package io.khasang.enterprise.controller.client;

import io.khasang.enterprise.dao.ClientDaoImpl;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    UserList clientDao;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String customer() {
        return "client/account";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String customerOrder() {
        return "client/order";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String customerChat() {
        return "client/chat";
    }

    @RequestMapping(value = "/structure", method = RequestMethod.GET)
    public String customerStructure() {
        return "client/structure";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String customerNews() {
        return "client/news";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String customerContacts() {
        return "client/contacts";
    }

    @InitBinder("client")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new ClientValidator());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String ClientRegistration(Model model, @Valid Client client, BindingResult result) {

        if (result.hasErrors()){
            System.out.println("Wrong enter");
        }else {
            System.out.println("Correct input");
            System.out.println(client.toString());
            clientDao.saveEntity(client);
            return "client/account";
        }
        return "/registration";
    }

}