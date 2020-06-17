package com.example.contactapp.controller;

import com.example.contactapp.entity.User;
import com.example.contactapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author yuriismac on 2020-06-16.
 * @project contactApp
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/users-list/user-remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/users-list/user-update/{id}")
    public String updateUserFrom(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/users-list/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.findById(id));
        return "users-list";
    }

}
