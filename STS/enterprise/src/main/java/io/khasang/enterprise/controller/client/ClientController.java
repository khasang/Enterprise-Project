package io.khasang.enterprise.controller.client;

import io.khasang.enterprise.webservice.exchangerates.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private Rates rates;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String customer(Model model) {
        model.addAttribute("USD", rates.getRate("USD"));
        model.addAttribute("EUR", rates.getRate("EUR"));
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
}