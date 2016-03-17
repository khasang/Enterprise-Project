package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.AccessToNewBase;
import io.khasang.enterprise.service.ChatService;
import io.khasang.enterprise.service.ProjectTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    AccessToNewBase accessToNewBase;

    @RequestMapping("/")
    public String home(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        return "index";
    }

    @RequestMapping("/track")
    public String home1(Model model) {
        ProjectTrackingService trackingService = new ProjectTrackingService();
        trackingService.setProgress("Done 5% of Enterprise app");
        model.addAttribute("trackPoint", trackingService.getProgress());
        return "index";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        model.addAttribute("xx1", hello);
        model.addAttribute("xx2", hello);
        model.addAttribute("xx3", hello);
        model.addAttribute("xx4", hello);
        model.addAttribute("xx5", hello);
        return "index";
    }

    @RequestMapping("/home3")
    public String home3(Model model) {
        model.addAttribute("xxx", accessToNewBase.getStatus());
        return "index";
    }

    @RequestMapping("/chat")
    public String chat(Model model) {
        ChatService chat = new ChatService();
        chat.setMessage("Сообщение 1");
        model.addAttribute("chatMessage1", chat.send("Андрей"));
        chat.setMessage("Сообщение 2");
        model.addAttribute("chatMessage2", chat.send());
        return "chat";
    }
}