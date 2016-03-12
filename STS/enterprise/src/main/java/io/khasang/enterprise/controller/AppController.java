package io.khasang.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String home(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        return "index";
    }

    @RequestMapping("/home1")
    public String home1(Model model) {
        model.addAttribute("xxx", "Buy");
        return "index";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        return "index";
    }

    @RequestMapping("/home3")
    public String home3(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        return "index";
    }
}