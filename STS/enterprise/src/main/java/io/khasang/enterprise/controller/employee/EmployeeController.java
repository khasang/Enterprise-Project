package io.khasang.enterprise.controller.employee;

import io.khasang.enterprise.webservice.exchangerates.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private Rates rates;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String employeeHome(Model model) {
        model.addAttribute("USD", rates.getRate("USD"));
        model.addAttribute("EUR", rates.getRate("EUR"));
        model.addAttribute("currentDay", rates.getCurrentDay());
        return "employee/account";
    }

}
