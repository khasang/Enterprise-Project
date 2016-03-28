package io.khasang.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
//    ProjectTrackingService trackingService;
//    ChatService chatService;

//    @Autowired
//    public AppController(ProjectTrackingService trackingService, ChatService chatService) {
//        this.trackingService = trackingService;
//        this.chatService = chatService;
//    }

    @RequestMapping(value = {"/", "/index"})
    public String home(Model model) {
        return "index";
    }

    @RequestMapping("/structure")
    public String structure(Model model) {
        return "structure";
    }

    @RequestMapping("/services")
    public String services(Model model) {
        return "services";
    }

    @RequestMapping("/news")
    public String news(Model model) {
        model.addAttribute("allnews", "что то динамичное");
        return "news";
    }

    @RequestMapping("/projects")
    public String projects(Model model) {
        return "projects";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        return "contacts";
    }

    @RequestMapping("/customer/customer")
    public String customer() {
        return "customer/customer";
    }

    @RequestMapping("/customer/order")
    public String customerOrder() {
        return "customer/order";
    }

    @RequestMapping("/customer/chat")
    public String customerChat() {
        return "customer/chat";
    }

    @RequestMapping("/customer/structure")
    public String customerStructure() {
        return "customer/structure";
    }

    @RequestMapping("/customer/news")
    public String customerNews() {
        return "customer/news";
    }

    @RequestMapping("/customer/contacts")
    public String customerContacts() {
        return "customer/contacts";
    }

}