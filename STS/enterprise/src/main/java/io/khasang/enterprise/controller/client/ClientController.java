package io.khasang.enterprise.controller.client;

import io.khasang.enterprise.model.client.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

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

    @RequestMapping("/registration")
    public String registrationCustomer(@RequestParam("fullname") String fullName,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("email") String email,
                                       @RequestParam("address") String address,
                                       @RequestParam("companyName") String companyName,
                                       @RequestParam("login") String login,
                                       @RequestParam("password") String password,
                                       Model model, Customer customer){
        System.out.println(address);
        return "client/account";
    }

}