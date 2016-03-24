package com.maxdegree.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    JDBCManager manager;

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("massage", manager.createTableUsers());
        return "index";
    }

    @RequestMapping("/users")
    public String displayAllUsers(Model model) {
        List<User> users = manager.getAllUsers();
        String massage = "";
        for(User user: users) {
            massage += user.toString();
        }
        model.addAttribute("users", massage);
        return "users";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addNewUser() {
        return "user";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("userId") String userId, @RequestParam("userName") String userName,
                          @RequestParam("userEmail") String userEmail, Model model) {
        User user = new User(Integer.parseInt(userId), userName, userEmail);
        String massage = manager.addNewUser(user);
        model.addAttribute("massage", massage);
        return "index";
    }
}