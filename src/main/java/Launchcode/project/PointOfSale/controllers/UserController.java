package Launchcode.project.PointOfSale.controllers;


import Launchcode.project.PointOfSale.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "user/newhire";
    }

    @RequestMapping(value = "newhire", method = RequestMethod.POST)
    public String processNewHireForm(@RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber,
                                     @RequestParam String password, Model model){
        model.addAttribute("title", "New Hire");

        return "redirect:";
    }
}
