package Launchcode.project.PointOfSale.controllers;

import Launchcode.project.PointOfSale.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sales")
public class SalesController {

    @Autowired
    ItemDao itemDao;

    @RequestMapping(value = "")
    public String index(Model model){


        model.addAttribute("title", "sales");

        return "sales/index";
    }

}
