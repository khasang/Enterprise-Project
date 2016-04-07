package io.khasang.enterprise.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/employee")
public class EmployeeController {
    @RequestMapping(value = "/account")
    public String homeEmployee(){
        return "employee/account";
    }
}
