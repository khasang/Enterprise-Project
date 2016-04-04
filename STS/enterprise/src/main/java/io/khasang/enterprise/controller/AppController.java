package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.NewsService;
import io.khasang.enterprise.service.RegistrationService;
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

    @RequestMapping(value = {"/", "/index"})
    public String home(Model model) {
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
        model.addAttribute("allnews", newsService.findAll());
        return "news";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(Model model) {
        return "projects";
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
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
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/regsuccess", method = RequestMethod.POST)
    public String submitUserRegistration(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        registrationService.createNewClient(client);
        return "index";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts(Model model) {
        return "contacts";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "/403";
    }
}