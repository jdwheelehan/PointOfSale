package Launchcode.project.PointOfSale.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "Welcome to Lambda Cubed Games");
        return "menu1";
    }

}
