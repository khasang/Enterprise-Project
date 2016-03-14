package io.khasang.enterprise.controller;

import io.khasang.enterprise.model.AccessToNewBase;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppController {
    Employee employee = new Employee();

    @RequestMapping("/")
    public String home(Model model) {
        employee.setName("kostya");
        employee.setAddress("10004 Stedwick rd, apt 210");
        employee.setEmail("kos.koha@gmail.com");
        employee.setPhone("202-650-9228");
        employee.setLogin("kostya");
        employee.setPasword("123");
        employee.addExperience("JK movers");
        employee.addExperience("MVD movers");
        employee.addExperience("Solution");

        model.addAttribute("name", employee.getName());
        model.addAttribute("address", employee.getAddress());
        model.addAttribute("phone", employee.getPhone());
        model.addAttribute("e-mail", employee.getEmail());
        model.addAttribute("pass",employee.getPasword());
        model.addAttribute("exp", employee.getExperience());
        return "employee";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getdata() {
        employee.addExperience("JK movers");
        employee.addExperience("MVD movers");
        employee.addExperience("Solution");

        ModelAndView modelAndView = new ModelAndView("employee");
        modelAndView.addObject("exp",employee.getExperience());
        return modelAndView;
     }

}