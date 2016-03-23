package com.yurtaevpavel.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String createTable(Model model){
        model.addAttribute("table", "Table created");
        return "t";
    }
}
