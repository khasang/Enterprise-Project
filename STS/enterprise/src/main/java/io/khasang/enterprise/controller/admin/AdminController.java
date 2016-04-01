package io.khasang.enterprise.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/account";
    }
}
