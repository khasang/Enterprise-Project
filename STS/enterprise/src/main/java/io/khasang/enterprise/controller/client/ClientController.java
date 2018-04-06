package io.khasang.enterprise.controller.client;

import io.khasang.enterprise.webservice.exchangerates.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String clientHome(Model model) {
        model.addAttribute("USD", currencyService.getCurrency("USD"));
        model.addAttribute("EUR", currencyService.getCurrency("EUR"));
        model.addAttribute("currentDay", currencyService.getCurrentDay());
        return "client/account";
    }

    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
    public String employeeTracking(Model model) {
        return "client/track";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String clientOrder() {
        return "client/order";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String clientChat() {
        return "client/chat";
    }

    @RequestMapping(value = "/structure", method = RequestMethod.GET)
    public String clientStructure() {
        return "client/structure";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String clientNews() {
        return "client/news";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String clientContacts() {
        return "client/contacts";
    }
}