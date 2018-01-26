package Launchcode.project.PointOfSale.controllers;


import Launchcode.project.PointOfSale.models.User;
import Launchcode.project.PointOfSale.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;
    
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Employee List");
        model.addAttribute("employees", userDao.findAll());
        return "user/index";
    }

    @RequestMapping(value = "newhire", method = RequestMethod.GET)
    public String newHire(Model model){


        model.addAttribute("title", "New Hire");
        model.addAttribute("error", "");

        return "user/newhire";
    }

    @RequestMapping(value = "newhire", method = RequestMethod.POST)
    public String processNewHireForm(@RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber,
                                     @RequestParam String password, @RequestParam String verifyPassword, @RequestParam String clearance, Model model){
        model.addAttribute("title", "New Hire");
        if(password.equals(verifyPassword)){
            Integer finalPass = password.hashCode();
            Date hireDate = new Date();
            String finalDate = hireDate.toString();
            User newUser = new User(name, address, phoneNumber, finalPass, clearance, finalDate);
            userDao.save(newUser);
            return "redirect:";
        }else{
        model.addAttribute("title", "New Hire");
        model.addAttribute("error", "Password and Verify does not match");
        return "user/newhire";}
    }



}
