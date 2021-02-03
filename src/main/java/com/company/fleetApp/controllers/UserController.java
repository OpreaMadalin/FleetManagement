package com.company.fleetApp.controllers;

import com.company.fleetApp.models.User;
import com.company.fleetApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Get All Users
    @GetMapping("/users")
    public String findAll(Model model) {
        return "user";
    }

    @RequestMapping("users/findById")
    @ResponseBody
    public Optional<User> findById(Integer id) {
        return userService.findById(id);
    }

    //Add User
    @PostMapping(value = "users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You successfully registered!");
        return redirectView;
    }

    @RequestMapping(value = "users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
