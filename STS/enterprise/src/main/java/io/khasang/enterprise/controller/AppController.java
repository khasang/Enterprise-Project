package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.ExampleMySqlDump;
import io.khasang.enterprise.service.NewsService;
import io.khasang.enterprise.service.registrationService.ClientValidator;
import io.khasang.enterprise.service.registrationService.RegistrationService;
import io.khasang.enterprise.webservice.exchangerates.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AppController {
    @Autowired
    NewsService newsService;
    @Autowired
    ClientValidator clientValidator;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    private Rates rates;
    @Autowired
    ExampleMySqlDump exampleMySqlDump;

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

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String example(Model model) {
        model.addAttribute("example",exampleMySqlDump.newBaseResult());
        return "example";
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Неверный логин или пароль!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Неверный логин или пароль!";
        }
        return error;
    }

    @RequestMapping("/registration")
    public String registrationPage() {
        return "/registration";
    }

    @RequestMapping(value = "reg/registration", method = RequestMethod.POST)
    public String ClientRegistration(@ModelAttribute("client") @Valid Client newClient, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration";
        } else {
            registrationService.saveClientToDB(newClient);
            return "welcome";
        }
    }

    @InitBinder("client")
    public void initClientBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(clientValidator);
    }
}