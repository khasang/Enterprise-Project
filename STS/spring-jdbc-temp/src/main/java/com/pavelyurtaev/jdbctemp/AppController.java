package com.pavelyurtaev.jdbctemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    DataBaseManagement dataBaseManagement;

    @RequestMapping("/create")
    public String trt(Model model) {
        model.addAttribute("table", dataBaseManagement.createTable());
        return "index";
    }
}
