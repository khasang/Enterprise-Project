package io.khasang.enterprise.controller.employee;

import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.service.ProjectTrackingService;
import io.khasang.enterprise.webservice.exchangerates.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private Rates rates;
    @Autowired
    private ProjectTrackingService projectTrackingService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String employeeHome(Model model) {
        model.addAttribute("USD", rates.getRate("USD"));
        model.addAttribute("EUR", rates.getRate("EUR"));
        model.addAttribute("currentDay", rates.getCurrentDay());
        return "employee/account";
    }

    @RequestMapping(value = "/all-projects", method = RequestMethod.GET)
    public String getProject(Model model) {
        List<Project> projects = projectTrackingService.getAllProject();
        model.addAttribute("allProjects", projects);
        return "employee/projects";
    }

    @RequestMapping(value = "/all-projects/{projectId}/orders", method = RequestMethod.GET)
    public String getProjectOrders(@PathVariable("projectId") Integer projectId, Model model) {
        projectTrackingService.getProjectOrders(projectId);
        model.addAttribute("ordersOfProject", projectTrackingService.getProjectOrders(projectId));
        model.addAttribute("project", projectTrackingService.getProjectById(projectId));
        return "employee/projectOrders";
    }
}
