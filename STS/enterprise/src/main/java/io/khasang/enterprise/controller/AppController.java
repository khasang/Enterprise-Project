package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.AccessToNewBase;
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

    @RequestMapping("/binding1")
    public String home1(Model model) {
        model.addAttribute("xxx", "Buy");
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
        AccessToNewBase accessToNewBase = new AccessToNewBase();
        model.addAttribute("xxx", accessToNewBase.access());
        return "index";
    }
}