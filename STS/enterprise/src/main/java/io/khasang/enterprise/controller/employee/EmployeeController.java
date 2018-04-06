package io.khasang.enterprise.controller.employee;

import io.khasang.enterprise.model.CustomerOrder;
import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.Track;
import io.khasang.enterprise.service.ProjectTrackingService;
import io.khasang.enterprise.service.registrationService.RegistrationService;
import io.khasang.enterprise.webservice.exchangerates.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private ProjectTrackingService projectTrackingService;
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String employeeHome(Model model) {
        model.addAttribute("USD", currencyService.getCurrency("USD"));
        model.addAttribute("EUR", currencyService.getCurrency("EUR"));
        model.addAttribute("currentDay", currencyService.getCurrentDay());
        return "employee/account";
    }

    @RequestMapping(value = "/all-projects", method = RequestMethod.GET)
    public String getProject(Model model) {
        List<Project> projects = projectTrackingService.getAllProjects();
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

    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
    public String getTrackingBoard(Model model) {
        model.addAttribute("runningProjects", projectTrackingService.getUnfinishedProjects());
        return "employee/tracking";
    }

    @RequestMapping(value = "/tracking/{projectId}", method = RequestMethod.GET)
    public String getTrackingItem(@PathVariable("projectId") Integer projectId, Model model) {
        Project project = projectTrackingService.getProjectById(projectId);
        List<CustomerOrder> orders = projectTrackingService.getProjectOrders(projectId);
        model.addAttribute("lastTrack", projectTrackingService.getLastTrackOfEachOrder(orders));
        model.addAttribute("ordersOfTrackingProject", orders);
        model.addAttribute("trackingProject", project);
        return "employee/trackingItem";
    }

    @RequestMapping(value = "/tracking/{projectId}/{orderId}/history", method = RequestMethod.GET)
    public String getTrackingHistoryOfOrder(@PathVariable("projectId") Integer projectId,
                                            @PathVariable("orderId") Integer orderId, Model model) {

        model.addAttribute("orderOfProject", projectTrackingService.getOrderById(orderId));
        model.addAttribute("trackingProject", projectTrackingService.getProjectById(projectId));
        model.addAttribute("allTracks", projectTrackingService.getTrackingHistoryOfOrder(orderId));
        return "employee/history";
    }

    @RequestMapping(value = "/tracking/{projectId}/{orderId}/input_track", method = RequestMethod.GET)
    public String getFormForNewTrack(@PathVariable("projectId") Integer projectId,
                                     @PathVariable("orderId") Integer orderId, Model model) {
        model.addAttribute("orderOfProject", projectTrackingService.getOrderById(orderId));
        model.addAttribute("trackingProject", projectTrackingService.getProjectById(projectId));
        return "employee/newTrack";
    }

    @RequestMapping(value = "/tracking/{projectId}/{orderId}/create", method = RequestMethod.POST)
    public String createNewTrack(@ModelAttribute("track") @Valid Track newTrack, BindingResult result,
                                 @PathVariable("projectId") Integer projectId,
                                 @PathVariable("orderId") Integer orderId, Model model, Principal principal) {
        if (result.hasErrors()) {
            return "redirect:/tracking/{projectId}/{orderId}/input_track";
        } else {
            projectTrackingService.createNewTrack(newTrack, orderId, principal);
            model.addAttribute("trackingProject", projectTrackingService.getProjectById(projectId));
            return "employee/newTrackSuccess";
        }
    }

    @RequestMapping(value = "/mytasks", method = RequestMethod.GET)
    public String getMyTasks(Model model, Principal principal) {
        model.addAttribute("tasks", projectTrackingService.getTasksOfEmployee(principal));
        return "employee/tasks";
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public String getMyAccountData(Model model, Principal principal) {
        model.addAttribute("accountData", registrationService.getEmployeeToEdit(principal));
        return "employee/aboutme";
    }
}
