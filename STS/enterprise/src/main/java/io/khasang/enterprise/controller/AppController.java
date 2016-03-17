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
    @Autowired
    AccessToNewBase accessToNewBase;
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


    @RequestMapping("/")
    public String home(Model model) {
        String hello = "Hello World";
        model.addAttribute("xxx", hello);
        return "index";
    }

    @RequestMapping("/track")
    public String home1(Model model) {
        ProjectTrackingService trackingService = new ProjectTrackingService();
        trackingService.setProgress("Done 5% of Enterprise app");
        model.addAttribute("trackPoint", trackingService.getProgress());
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
        model.addAttribute("xxx", accessToNewBase.getStatus());
        return "index";
    }

    @RequestMapping("/chat")
    public String chat(Model model) {
        ChatService chat = new ChatService();
        chat.setMessage("Сообщение 1");
        model.addAttribute("chatMessage1", chat.send("Андрей"));
        chat.setMessage("Сообщение 2");
        model.addAttribute("chatMessage2", chat.send());
        return "chat";
    }

}