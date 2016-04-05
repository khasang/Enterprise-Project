package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.NewsService;
import io.khasang.enterprise.service.RegistrationService;
import io.khasang.enterprise.webservice.exchangerates.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    NewsService newsService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    private Rates rates;

    @RequestMapping(value = {"/", "/index"})
    public String home(Model model) {
        model.addAttribute("USD", rates.getRate("USD"));
        model.addAttribute("EUR", rates.getRate("EUR"));
        return "index";
    }

    @RequestMapping(value = "/structure", method = RequestMethod.GET)
    public String structure(Model model) {
        return "structure";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(Model model) {
        return "services";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news(Model model) {
        model.addAttribute("news", newsService.findLatestNews());
        return "news";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(Model model) {
        return "projects";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts(Model model) {
        return "contacts";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping("/registration")
    public String registrationPage(){
        return "/registration";
    }
}